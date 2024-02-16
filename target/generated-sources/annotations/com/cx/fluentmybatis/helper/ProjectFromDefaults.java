package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.ProjectFromMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.ProjectFromQuery;
import com.cx.fluentmybatis.wrapper.ProjectFromUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * ProjectFromDefaults
 *
 * @author powered by FluentMybatis
 */
public class ProjectFromDefaults implements IDefaultSetter, IDefaultGetter {
  public static final ProjectFromDefaults INSTANCE = new ProjectFromDefaults();

  private TableDynamic dynamic;

  private ProjectFromDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public ProjectFromQuery query() {
    return new ProjectFromQuery();
  }

  @Override
  public ProjectFromQuery defaultQuery() {
    ProjectFromQuery query = new ProjectFromQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public ProjectFromUpdate updater() {
    return new ProjectFromUpdate();
  }

  @Override
  public ProjectFromUpdate defaultUpdater() {
    ProjectFromUpdate updater = new ProjectFromUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public ProjectFromQuery aliasQuery() {
    Parameters parameters = new Parameters();
    ProjectFromQuery query = new ProjectFromQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public ProjectFromQuery aliasQuery(String alias) {
    ProjectFromQuery query = new ProjectFromQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public ProjectFromQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    ProjectFromQuery query = new ProjectFromQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public ProjectFromQuery aliasWith(String alias, BaseQuery fromQuery) {
    ProjectFromQuery query = new ProjectFromQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public ProjectFromDefaults setTableDynamic(TableDynamic dynamic) {
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
