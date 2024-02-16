package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.fluentmybatis.helper.QzxjDefaults;
import com.cx.fluentmybatis.helper.QzxjMapping;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * QzxjUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class QzxjUpdate extends BaseUpdate<QzxjEntity, QzxjUpdate, QzxjQuery> {
  /**
   * 默认设置器
   */
  private static final QzxjDefaults defaults = QzxjDefaults.INSTANCE;

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

  public QzxjUpdate() {
    this(defaults.table(), null);
  }

  public QzxjUpdate(Supplier<String> table, String alias) {
    super(table, alias, QzxjEntity.class, QzxjQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return QzxjMapping.MAPPING;
  }

  protected List<String> allFields() {
    return QzxjMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static QzxjUpdate updater() {
    return new QzxjUpdate();
  }

  public static QzxjUpdate updater(Supplier<String> table) {
    return new QzxjUpdate(table, null);
  }

  public static QzxjUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return QzxjMapping.Column2Mapping;
  }
}
