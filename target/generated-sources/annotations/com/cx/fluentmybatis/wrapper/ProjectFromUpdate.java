package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.ProjectFromEntity;
import com.cx.fluentmybatis.helper.ProjectFromDefaults;
import com.cx.fluentmybatis.helper.ProjectFromMapping;
import com.cx.fluentmybatis.helper.ProjectFromWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.ProjectFromWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.ProjectFromWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * ProjectFromUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class ProjectFromUpdate extends BaseUpdate<ProjectFromEntity, ProjectFromUpdate, ProjectFromQuery> {
  /**
   * 默认设置器
   */
  private static final ProjectFromDefaults defaults = ProjectFromDefaults.INSTANCE;

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

  public ProjectFromUpdate() {
    this(defaults.table(), null);
  }

  public ProjectFromUpdate(Supplier<String> table, String alias) {
    super(table, alias, ProjectFromEntity.class, ProjectFromQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return ProjectFromMapping.MAPPING;
  }

  protected List<String> allFields() {
    return ProjectFromMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static ProjectFromUpdate updater() {
    return new ProjectFromUpdate();
  }

  public static ProjectFromUpdate updater(Supplier<String> table) {
    return new ProjectFromUpdate(table, null);
  }

  public static ProjectFromUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return ProjectFromMapping.Column2Mapping;
  }
}
