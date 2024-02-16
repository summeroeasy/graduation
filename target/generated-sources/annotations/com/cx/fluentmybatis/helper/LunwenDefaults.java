package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.LunwenMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.LunwenQuery;
import com.cx.fluentmybatis.wrapper.LunwenUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * LunwenDefaults
 *
 * @author powered by FluentMybatis
 */
public class LunwenDefaults implements IDefaultSetter, IDefaultGetter {
  public static final LunwenDefaults INSTANCE = new LunwenDefaults();

  private TableDynamic dynamic;

  private LunwenDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public LunwenQuery query() {
    return new LunwenQuery();
  }

  @Override
  public LunwenQuery defaultQuery() {
    LunwenQuery query = new LunwenQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public LunwenUpdate updater() {
    return new LunwenUpdate();
  }

  @Override
  public LunwenUpdate defaultUpdater() {
    LunwenUpdate updater = new LunwenUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public LunwenQuery aliasQuery() {
    Parameters parameters = new Parameters();
    LunwenQuery query = new LunwenQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public LunwenQuery aliasQuery(String alias) {
    LunwenQuery query = new LunwenQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public LunwenQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    LunwenQuery query = new LunwenQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public LunwenQuery aliasWith(String alias, BaseQuery fromQuery) {
    LunwenQuery query = new LunwenQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public LunwenDefaults setTableDynamic(TableDynamic dynamic) {
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
