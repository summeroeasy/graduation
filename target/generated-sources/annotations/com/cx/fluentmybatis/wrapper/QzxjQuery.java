package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;
import static cn.org.atool.fluent.mybatis.mapper.StrConstant.EMPTY;

import cn.org.atool.fluent.mybatis.base.crud.BaseQuery;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import cn.org.atool.fluent.mybatis.segment.model.Parameters;
import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.fluentmybatis.helper.QzxjDefaults;
import com.cx.fluentmybatis.helper.QzxjMapping;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.GroupBy;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.Having;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.QueryOrderBy;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.QueryWhere;
import com.cx.fluentmybatis.helper.QzxjWrapperHelper.Selector;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * QzxjQuery: 查询构造
 *
 * @author powered by FluentMybatis
 */
public class QzxjQuery extends BaseQuery<QzxjEntity, QzxjQuery> {
  /**
   * 默认设置器
   */
  private static final QzxjDefaults defaults = QzxjDefaults.INSTANCE;

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

  public QzxjQuery() {
    this(defaults.table(), null);
  }

  public QzxjQuery(String alias) {
    this(defaults.table(), alias);
  }

  public QzxjQuery(Supplier<String> table, String alias) {
    super(table, alias, QzxjEntity.class, QzxjQuery.class);
  }

  public QzxjQuery(String alias, Parameters parameters) {
    this(alias);
    this.sharedParameter(parameters);
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return QzxjMapping.Column2Mapping;
  }

  @Override
  public QueryWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return QzxjMapping.MAPPING;
  }

  @Override
  public List<String> allFields() {
    return QzxjMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static QzxjQuery query() {
    return new QzxjQuery();
  }

  public static QzxjQuery query(String alias) {
    return new QzxjQuery(alias);
  }

  public static QzxjQuery query(Supplier<String> table) {
    return new QzxjQuery(table, null);
  }

  public static QzxjQuery query(Supplier<String> table, String alias) {
    return new QzxjQuery(table, alias);
  }

  public static QzxjQuery defaultQuery() {
    return defaults.defaultQuery();
  }

  /**
   * 自动分配表别名查询构造器(join查询的时候需要定义表别名)
   * 如果要自定义别名, 使用方法 {@link #aliasQuery(String)}
   */
  public static QzxjQuery aliasQuery() {
    return defaults.aliasQuery();
  }

  /**
   * 显式指定表别名(join查询的时候需要定义表别名)
   */
  public static QzxjQuery aliasQuery(String alias) {
    return defaults.aliasQuery(alias);
  }

  /**
   * 关联查询, 根据fromQuery自动设置别名和关联?参数
   * 如果要自定义别名, 使用方法 {@link #aliasWith(String, BaseQuery)}
   */
  public static QzxjQuery aliasWith(BaseQuery fromQuery) {
    return defaults.aliasWith(fromQuery);
  }

  /**
   * 关联查询, 显式设置别名, 根据fromQuery自动关联?参数
   */
  public static QzxjQuery aliasWith(String alias, BaseQuery fromQuery) {
    return defaults.aliasWith(alias, fromQuery);
  }
}
