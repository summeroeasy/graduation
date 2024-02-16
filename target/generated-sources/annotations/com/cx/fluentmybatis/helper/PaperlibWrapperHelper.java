package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.functions.IAggregate;
import cn.org.atool.fluent.mybatis.segment.GroupByBase;
import cn.org.atool.fluent.mybatis.segment.HavingBase;
import cn.org.atool.fluent.mybatis.segment.HavingOperator;
import cn.org.atool.fluent.mybatis.segment.OrderByApply;
import cn.org.atool.fluent.mybatis.segment.OrderByBase;
import cn.org.atool.fluent.mybatis.segment.SelectorBase;
import cn.org.atool.fluent.mybatis.segment.UpdateApply;
import cn.org.atool.fluent.mybatis.segment.UpdateBase;
import cn.org.atool.fluent.mybatis.segment.WhereBase;
import cn.org.atool.fluent.mybatis.segment.where.NumericWhere;
import cn.org.atool.fluent.mybatis.segment.where.StringWhere;
import com.cx.fluentmybatis.wrapper.PaperlibQuery;
import com.cx.fluentmybatis.wrapper.PaperlibUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * PaperlibWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class PaperlibWrapperHelper {
  /**
   * 默认设置器
   */
  private static final PaperlibDefaults defaults = PaperlibDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R id() {
      return this.set(PaperlibMapping.id);
    }

    default R file() {
      return this.set(PaperlibMapping.file);
    }

    default R info() {
      return this.set(PaperlibMapping.info);
    }

    default R name() {
      return this.set(PaperlibMapping.name);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, PaperlibQuery> implements ISegment<Selector> {
    public Selector(PaperlibQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector id(String _alias_) {
      return this.process(PaperlibMapping.id, _alias_);
    }

    public Selector file(String _alias_) {
      return this.process(PaperlibMapping.file, _alias_);
    }

    public Selector info(String _alias_) {
      return this.process(PaperlibMapping.info, _alias_);
    }

    public Selector name(String _alias_) {
      return this.process(PaperlibMapping.name, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, PaperlibQuery, PaperlibQuery> {
    public QueryWhere(PaperlibQuery query) {
      super(query);
    }

    private QueryWhere(PaperlibQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((PaperlibQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((PaperlibQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, PaperlibQuery> id() {
      return this.set(PaperlibMapping.id);
    }

    public StringWhere<QueryWhere, PaperlibQuery> file() {
      return this.set(PaperlibMapping.file);
    }

    public StringWhere<QueryWhere, PaperlibQuery> info() {
      return this.set(PaperlibMapping.info);
    }

    public StringWhere<QueryWhere, PaperlibQuery> name() {
      return this.set(PaperlibMapping.name);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, PaperlibUpdate, PaperlibQuery> {
    public UpdateWhere(PaperlibUpdate updater) {
      super(updater);
    }

    private UpdateWhere(PaperlibUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((PaperlibUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((PaperlibUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, PaperlibQuery> id() {
      return this.set(PaperlibMapping.id);
    }

    public StringWhere<UpdateWhere, PaperlibQuery> file() {
      return this.set(PaperlibMapping.file);
    }

    public StringWhere<UpdateWhere, PaperlibQuery> info() {
      return this.set(PaperlibMapping.info);
    }

    public StringWhere<UpdateWhere, PaperlibQuery> name() {
      return this.set(PaperlibMapping.name);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, PaperlibQuery> implements ISegment<GroupBy> {
    public GroupBy(PaperlibQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, PaperlibQuery> implements ISegment<HavingOperator<Having>> {
    public Having(PaperlibQuery query) {
      super(query);
    }

    protected Having(Having having, IAggregate aggregate) {
      super(having, aggregate);
    }

    @Override
    protected Having aggregateSegment(IAggregate aggregate) {
      return new Having(this, aggregate);
    }
  }

  /**
   * Query OrderBy设置
   */
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, PaperlibQuery> implements ISegment<OrderByApply<QueryOrderBy, PaperlibQuery>> {
    public QueryOrderBy(PaperlibQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, PaperlibUpdate> implements ISegment<OrderByApply<UpdateOrderBy, PaperlibUpdate>> {
    public UpdateOrderBy(PaperlibUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, PaperlibUpdate> implements ISegment<UpdateApply<UpdateSetter, PaperlibUpdate>> {
    public UpdateSetter(PaperlibUpdate updater) {
      super(updater);
    }
  }
}
