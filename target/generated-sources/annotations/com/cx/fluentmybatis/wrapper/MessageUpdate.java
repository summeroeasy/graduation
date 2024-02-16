package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.helper.MessageDefaults;
import com.cx.fluentmybatis.helper.MessageMapping;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * MessageUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class MessageUpdate extends BaseUpdate<MessageEntity, MessageUpdate, MessageQuery> {
  /**
   * 默认设置器
   */
  private static final MessageDefaults defaults = MessageDefaults.INSTANCE;

  /**
   * same as {@link #update}
   */
  public final UpdateSetter set = new UpdateSetter(this);

  /**
   * replaced by {@link #set}
   */
  @Deprecated
  public final UpdateSetter update = set;

  public final UpdateWhere where = new UpdateWhere(this);

  public final UpdateOrderBy orderBy = new UpdateOrderBy(this);

  public MessageUpdate() {
    this(defaults.table(), null);
  }

  public MessageUpdate(Supplier<String> table, String alias) {
    super(table, alias, MessageEntity.class, MessageQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return MessageMapping.MAPPING;
  }

  protected List<String> allFields() {
    return MessageMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static MessageUpdate updater() {
    return new MessageUpdate();
  }

  public static MessageUpdate updater(Supplier<String> table) {
    return new MessageUpdate(table, null);
  }

  public static MessageUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return MessageMapping.Column2Mapping;
  }
}
