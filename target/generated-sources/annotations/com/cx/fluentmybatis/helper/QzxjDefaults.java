package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.QzxjMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.QzxjQuery;
import com.cx.fluentmybatis.wrapper.QzxjUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * QzxjDefaults
 *
 * @author powered by FluentMybatis
 */
public class QzxjDefaults implements IDefaultSetter, IDefaultGetter {
  public static final QzxjDefaults INSTANCE = new QzxjDefaults();

  private TableDynamic dynamic;

  private QzxjDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public QzxjQuery query() {
    return new QzxjQuery();
  }

  @Override
  public QzxjQuery defaultQuery() {
    QzxjQuery query = new QzxjQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public QzxjUpdate updater() {
    return new QzxjUpdate();
  }

  @Override
  public QzxjUpdate defaultUpdater() {
    QzxjUpdate updater = new QzxjUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public QzxjQuery aliasQuery() {
    Parameters parameters = new Parameters();
    QzxjQuery query = new QzxjQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public QzxjQuery aliasQuery(String alias) {
    QzxjQuery query = new QzxjQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public QzxjQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    QzxjQuery query = new QzxjQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public QzxjQuery aliasWith(String alias, BaseQuery fromQuery) {
    QzxjQuery query = new QzxjQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public QzxjDefaults setTableDynamic(TableDynamic dynamic) {
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
