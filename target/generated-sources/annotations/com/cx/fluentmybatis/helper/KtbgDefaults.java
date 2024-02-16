package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.KtbgMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.KtbgQuery;
import com.cx.fluentmybatis.wrapper.KtbgUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * KtbgDefaults
 *
 * @author powered by FluentMybatis
 */
public class KtbgDefaults implements IDefaultSetter, IDefaultGetter {
  public static final KtbgDefaults INSTANCE = new KtbgDefaults();

  private TableDynamic dynamic;

  private KtbgDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public KtbgQuery query() {
    return new KtbgQuery();
  }

  @Override
  public KtbgQuery defaultQuery() {
    KtbgQuery query = new KtbgQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public KtbgUpdate updater() {
    return new KtbgUpdate();
  }

  @Override
  public KtbgUpdate defaultUpdater() {
    KtbgUpdate updater = new KtbgUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public KtbgQuery aliasQuery() {
    Parameters parameters = new Parameters();
    KtbgQuery query = new KtbgQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public KtbgQuery aliasQuery(String alias) {
    KtbgQuery query = new KtbgQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public KtbgQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    KtbgQuery query = new KtbgQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public KtbgQuery aliasWith(String alias, BaseQuery fromQuery) {
    KtbgQuery query = new KtbgQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public KtbgDefaults setTableDynamic(TableDynamic dynamic) {
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
