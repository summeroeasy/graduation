package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.ProjectMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.ProjectQuery;
import com.cx.fluentmybatis.wrapper.ProjectUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * ProjectDefaults
 *
 * @author powered by FluentMybatis
 */
public class ProjectDefaults implements IDefaultSetter, IDefaultGetter {
  public static final ProjectDefaults INSTANCE = new ProjectDefaults();

  private TableDynamic dynamic;

  private ProjectDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public ProjectQuery query() {
    return new ProjectQuery();
  }

  @Override
  public ProjectQuery defaultQuery() {
    ProjectQuery query = new ProjectQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public ProjectUpdate updater() {
    return new ProjectUpdate();
  }

  @Override
  public ProjectUpdate defaultUpdater() {
    ProjectUpdate updater = new ProjectUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public ProjectQuery aliasQuery() {
    Parameters parameters = new Parameters();
    ProjectQuery query = new ProjectQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public ProjectQuery aliasQuery(String alias) {
    ProjectQuery query = new ProjectQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public ProjectQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    ProjectQuery query = new ProjectQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public ProjectQuery aliasWith(String alias, BaseQuery fromQuery) {
    ProjectQuery query = new ProjectQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public ProjectDefaults setTableDynamic(TableDynamic dynamic) {
    this.dynamic = dynamic;
    return this;
  }

  /**
   * 获取表名
   */
  public Supplier<String> table() {
    return dynamic == null ? () -> Table_Name : () -> dynamic.get(Table_Name);
  }
}
