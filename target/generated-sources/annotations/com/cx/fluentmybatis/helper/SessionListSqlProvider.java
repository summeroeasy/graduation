package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.SessionListMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.SessionListEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * SessionListSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class SessionListSqlProvider extends BaseSqlProvider<SessionListEntity> {
  /**
   * 默认设置器
   */
  private static final SessionListDefaults defaults = SessionListDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(SessionListEntity entity) {
    return entity.getId() == null;
  }

  @Override
  public boolean primaryNotNull(SessionListEntity entity) {
    return entity.getId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, SessionListEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, id, entity.getId(), null);
    }
    inserts.add(prefix, listName, entity.getListName(), "");
    inserts.add(prefix, toUserId, entity.getToUserId(), "");
    inserts.add(prefix, unReadCount, entity.getUnReadCount(), "");
    inserts.add(prefix, userId, entity.getUserId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, SessionListEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", id, entity.getId(), null));
    }
    values.add(el("list[" + index + "].", listName, entity.getListName(), ""));
    values.add(el("list[" + index + "].", toUserId, entity.getToUserId(), ""));
    values.add(el("list[" + index + "].", unReadCount, entity.getUnReadCount(), ""));
    values.add(el("list[" + index + "].", userId, entity.getUserId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    SessionListEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), listName, entity.getListName(), "")
    	.add(this.dbType(), toUserId, entity.getToUserId(), "")
    	.add(this.dbType(), unReadCount, entity.getUnReadCount(), "")
    	.add(this.dbType(), userId, entity.getUserId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(id.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("id", "list_name", "to_user_id", "un_read_count", "user_id");
    } else {
    	return Arrays.asList("list_name", "to_user_id", "un_read_count", "user_id");
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
