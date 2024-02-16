package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.PaperlibMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.PaperlibQuery;
import com.cx.fluentmybatis.wrapper.PaperlibUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * PaperlibDefaults
 *
 * @author powered by FluentMybatis
 */
public class PaperlibDefaults implements IDefaultSetter, IDefaultGetter {
  public static final PaperlibDefaults INSTANCE = new PaperlibDefaults();

  private TableDynamic dynamic;

  private PaperlibDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public PaperlibQuery query() {
    return new PaperlibQuery();
  }

  @Override
  public PaperlibQuery defaultQuery() {
    PaperlibQuery query = new PaperlibQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public PaperlibUpdate updater() {
    return new PaperlibUpdate();
  }

  @Override
  public PaperlibUpdate defaultUpdater() {
    PaperlibUpdate updater = new PaperlibUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public PaperlibQuery aliasQuery() {
    Parameters parameters = new Parameters();
    PaperlibQuery query = new PaperlibQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public PaperlibQuery aliasQuery(String alias) {
    PaperlibQuery query = new PaperlibQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public PaperlibQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    PaperlibQuery query = new PaperlibQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public PaperlibQuery aliasWith(String alias, BaseQuery fromQuery) {
    PaperlibQuery query = new PaperlibQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public PaperlibDefaults setTableDynamic(TableDynamic dynamic) {
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
