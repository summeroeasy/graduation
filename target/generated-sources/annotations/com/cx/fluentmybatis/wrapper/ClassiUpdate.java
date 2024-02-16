package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.ClassiEntity;
import com.cx.fluentmybatis.helper.ClassiDefaults;
import com.cx.fluentmybatis.helper.ClassiMapping;
import com.cx.fluentmybatis.helper.ClassiWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.ClassiWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.ClassiWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * ClassiUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class ClassiUpdate extends BaseUpdate<ClassiEntity, ClassiUpdate, ClassiQuery> {
  /**
   * 默认设置器
   */
  private static final ClassiDefaults defaults = ClassiDefaults.INSTANCE;

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

  public ClassiUpdate() {
    this(defaults.table(), null);
  }

  public ClassiUpdate(Supplier<String> table, String alias) {
    super(table, alias, ClassiEntity.class, ClassiQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return ClassiMapping.MAPPING;
  }

  protected List<String> allFields() {
    return ClassiMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static ClassiUpdate updater() {
    return new ClassiUpdate();
  }

  public static ClassiUpdate updater(Supplier<String> table) {
    return new ClassiUpdate(table, null);
  }

  public static ClassiUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return ClassiMapping.Column2Mapping;
  }
}
