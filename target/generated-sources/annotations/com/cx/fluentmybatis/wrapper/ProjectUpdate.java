package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.helper.ProjectDefaults;
import com.cx.fluentmybatis.helper.ProjectMapping;
import com.cx.fluentmybatis.helper.ProjectWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.ProjectWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.ProjectWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * ProjectUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class ProjectUpdate extends BaseUpdate<ProjectEntity, ProjectUpdate, ProjectQuery> {
  /**
   * 默认设置器
   */
  private static final ProjectDefaults defaults = ProjectDefaults.INSTANCE;

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

  public ProjectUpdate() {
    this(defaults.table(), null);
  }

  public ProjectUpdate(Supplier<String> table, String alias) {
    super(table, alias, ProjectEntity.class, ProjectQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return ProjectMapping.MAPPING;
  }

  protected List<String> allFields() {
    return ProjectMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static ProjectUpdate updater() {
    return new ProjectUpdate();
  }

  public static ProjectUpdate updater(Supplier<String> table) {
    return new ProjectUpdate(table, null);
  }

  public static ProjectUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return ProjectMapping.Column2Mapping;
  }
}
