package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.MessageMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.MessageEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * MessageSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class MessageSqlProvider extends BaseSqlProvider<MessageEntity> {
  /**
   * 默认设置器
   */
  private static final MessageDefaults defaults = MessageDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(MessageEntity entity) {
    return entity.getMessageId() == null;
  }

  @Override
  public boolean primaryNotNull(MessageEntity entity) {
    return entity.getMessageId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, MessageEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, messageId, entity.getMessageId(), null);
    }
    inserts.add(prefix, createDate, entity.getCreateDate(), "");
    inserts.add(prefix, messageBody, entity.getMessageBody(), "");
    inserts.add(prefix, messageType, entity.getMessageType(), "");
    inserts.add(prefix, state, entity.getState(), "");
    inserts.add(prefix, toUserId, entity.getToUserId(), "");
    inserts.add(prefix, userId, entity.getUserId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, MessageEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", messageId, entity.getMessageId(), null));
    }
    values.add(el("list[" + index + "].", createDate, entity.getCreateDate(), ""));
    values.add(el("list[" + index + "].", messageBody, entity.getMessageBody(), ""));
    values.add(el("list[" + index + "].", messageType, entity.getMessageType(), ""));
    values.add(el("list[" + index + "].", state, entity.getState(), ""));
    values.add(el("list[" + index + "].", toUserId, entity.getToUserId(), ""));
    values.add(el("list[" + index + "].", userId, entity.getUserId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    MessageEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), createDate, entity.getCreateDate(), "")
    	.add(this.dbType(), messageBody, entity.getMessageBody(), "")
    	.add(this.dbType(), messageType, entity.getMessageType(), "")
    	.add(this.dbType(), state, entity.getState(), "")
    	.add(this.dbType(), toUserId, entity.getToUserId(), "")
    	.add(this.dbType(), userId, entity.getUserId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(messageId.el(this.dbType(), Param_ET));
    return sql.toString();
  }

  @Override
  public List<String> updateDefaults(Map<String, String> updates, boolean ignoreLockVersion) {
    UpdateDefault defaults = new UpdateDefault(updates);
    return defaults.getUpdateDefaults();
  }

  @Override
  public String tableName() {
    return defaults.table().get();
  }

  @Override
  protected IMapping mapping() {
    return MAPPING;
  }

  @Override
  public List<String> allFields(boolean withPk) {
    if (withPk) {
    	return Arrays.asList("message_id", "create_date", "message_body", "message_type", "state", "to_user_id", "user_id");
    } else {
    	return Arrays.asList("create_date", "message_body", "message_type", "state", "to_user_id", "user_id");
    }
  }

  @Override
  protected void setEntityByDefault(IEntity entity) {
    defaults.setEntityByDefault(entity);
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  @Override
  protected boolean longTypeOfLogicDelete() {
    return false;
  }
}
