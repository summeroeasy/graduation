package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;
import static cn.org.atool.fluent.mybatis.mapper.StrConstant.EMPTY;

import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.helper.MessageDefaults;
import com.cx.fluentmybatis.helper.MessageMapping;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.GroupBy;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.Having;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.QueryOrderBy;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.QueryWhere;
import com.cx.fluentmybatis.helper.MessageWrapperHelper.Selector;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * MessageQuery: 查询构造
 *
 * @author powered by FluentMybatis
 */
public class MessageQuery extends BaseQuery<MessageEntity, MessageQuery> {
  /**
   * 默认设置器
   */
  private static final MessageDefaults defaults = MessageDefaults.INSTANCE;

  /**
   * 指定查询字段, 默认无需设置
   */
  public final Selector select = new Selector(this);

  /**
   * 分组：GROUP BY 字段, ...
   * 例: groupBy('id', 'name')
   */
  public final GroupBy groupBy = new GroupBy(this);

  /**
   * 分组条件设置 having...
   */
  public final Having having = new Having(this);

  /**
   * 排序设置 order by ...
   */
  public final QueryOrderBy orderBy = new QueryOrderBy(this);

  /**
   * 查询条件 where ...
   */
  public final QueryWhere where = new QueryWhere(this);

  public MessageQuery() {
    this(defaults.table(), null);
  }

  public MessageQuery(String alias) {
    this(defaults.table(), alias);
  }

  public MessageQuery(Supplier<String> table, String alias) {
    super(table, alias, MessageEntity.class, MessageQuery.class);
  }

  public MessageQuery(String alias, Parameters parameters) {
    this(alias);
    this.sharedParameter(parameters);
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return MessageMapping.Column2Mapping;
  }

  @Override
  public QueryWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return MessageMapping.MAPPING;
  }

  @Override
  public List<String> allFields() {
    return MessageMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static MessageQuery query() {
    return new MessageQuery();
  }

  public static MessageQuery query(String alias) {
    return new MessageQuery(alias);
  }

  public static MessageQuery query(Supplier<String> table) {
    return new MessageQuery(table, null);
  }

  public static MessageQuery query(Supplier<String> table, String alias) {
    return new MessageQuery(table, alias);
  }

  public static MessageQuery defaultQuery() {
    return defaults.defaultQuery();
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  public static MessageQuery aliasQuery() {
    return defaults.aliasQuery();
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  public static MessageQuery aliasQuery(String alias) {
    return defaults.aliasQuery(alias);
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  public static MessageQuery aliasWith(BaseQuery fromQuery) {
    return defaults.aliasWith(fromQuery);
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  public static MessageQuery aliasWith(String alias, BaseQuery fromQuery) {
    return defaults.aliasWith(alias, fromQuery);
  }
}
