package com.cx.fluentmybatis.helper;

import static com.cx.fluentmybatis.helper.MessageMapping.Table_Name;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IDefaultSetter;
import cn.org.atool.fluent.mybatis.functions.TableDynamic;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.wrapper.MessageQuery;
import com.cx.fluentmybatis.wrapper.MessageUpdate;
import java.lang.Override;
import java.lang.String;
import java.util.function.Supplier;

/**
 *
 * MessageDefaults
 *
 * @author powered by FluentMybatis
 */
public class MessageDefaults implements IDefaultSetter, IDefaultGetter {
  public static final MessageDefaults INSTANCE = new MessageDefaults();

  private TableDynamic dynamic;

  private MessageDefaults() {
  }

  @Override
  public void setEntityByDefault(IEntity entity) {
    this.setInsertDefault(entity);
  }

  @Override
  public MessageQuery query() {
    return new MessageQuery();
  }

  @Override
  public MessageQuery defaultQuery() {
    MessageQuery query = new MessageQuery();
    this.setQueryDefault(query);
    return query;
  }

  @Override
  public MessageUpdate updater() {
    return new MessageUpdate();
  }

  @Override
  public MessageUpdate defaultUpdater() {
    MessageUpdate updater = new MessageUpdate();
    this.setUpdateDefault(updater);
    return updater;
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  @Override
  public MessageQuery aliasQuery() {
    Parameters parameters = new Parameters();
    MessageQuery query = new MessageQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  @Override
  public MessageQuery aliasQuery(String alias) {
    MessageQuery query = new MessageQuery(alias, new Parameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  @Override
  public MessageQuery aliasWith(BaseQuery fromQuery) {
    Parameters parameters = fromQuery.getWrapperData().getParameters();
    MessageQuery query = new MessageQuery(parameters.alias(), parameters);
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  @Override
  public MessageQuery aliasWith(String alias, BaseQuery fromQuery) {
    MessageQuery query = new MessageQuery(alias, fromQuery.getWrapperData().getParameters());
    this.setQueryDefault(query);
    return query;
  }

  /**
   * 设置表名动态设置
   */
  public MessageDefaults setTableDynamic(TableDynamic dynamic) {
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
