package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.helper.SessionListDefaults;
import com.cx.fluentmybatis.helper.SessionListMapping;
import com.cx.fluentmybatis.helper.SessionListWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.SessionListWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.SessionListWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * SessionListUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class SessionListUpdate extends BaseUpdate<SessionListEntity, SessionListUpdate, SessionListQuery> {
  /**
   * 默认设置器
   */
  private static final SessionListDefaults defaults = SessionListDefaults.INSTANCE;

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

  public SessionListUpdate() {
    this(defaults.table(), null);
  }

  public SessionListUpdate(Supplier<String> table, String alias) {
    super(table, alias, SessionListEntity.class, SessionListQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return SessionListMapping.MAPPING;
  }

  protected List<String> allFields() {
    return SessionListMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static SessionListUpdate updater() {
    return new SessionListUpdate();
  }

  public static SessionListUpdate updater(Supplier<String> table) {
    return new SessionListUpdate(table, null);
  }

  public static SessionListUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return SessionListMapping.Column2Mapping;
  }
}
