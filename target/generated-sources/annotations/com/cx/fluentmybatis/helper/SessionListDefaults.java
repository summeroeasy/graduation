package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.SessionListMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.SessionListQuery;
import com.cx.fluentmybatis.wrapper.SessionListUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * SessionListDefaults
 *
 * @author powered by FluentMybatis
 */
public class SessionListDefaults implements IDefaultSetter, IDefaultGetter {
  public static final SessionListDefaults INSTANCE = new SessionListDefaults();

  private TableDynamic dynamic;

  private SessionListDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public SessionListQuery query() {
    return new SessionListQuery();
  }

  @Override
  public SessionListQuery defaultQuery() {
    SessionListQuery query = new SessionListQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public SessionListUpdate updater() {
    return new SessionListUpdate();
  }

  @Override
  public SessionListUpdate defaultUpdater() {
    SessionListUpdate updater = new SessionListUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public SessionListQuery aliasQuery() {
    Parameters parameters = new Parameters();
    SessionListQuery query = new SessionListQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public SessionListQuery aliasQuery(String alias) {
    SessionListQuery query = new SessionListQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public SessionListQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    SessionListQuery query = new SessionListQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public SessionListQuery aliasWith(String alias, BaseQuery fromQuery) {
    SessionListQuery query = new SessionListQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public SessionListDefaults setTableDynamic(TableDynamic dynamic) {
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
