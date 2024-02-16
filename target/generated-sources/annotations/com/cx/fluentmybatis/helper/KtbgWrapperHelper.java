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
import com.cx.fluentmybatis.wrapper.KtbgQuery;
import com.cx.fluentmybatis.wrapper.KtbgUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * KtbgWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class KtbgWrapperHelper {
  /**
   * 默认设置器
   */
  private static final KtbgDefaults defaults = KtbgDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R ktbgId() {
      return this.set(KtbgMapping.ktbgId);
    }

    default R column1() {
      return this.set(KtbgMapping.column1);
    }

    default R column2() {
      return this.set(KtbgMapping.column2);
    }

    default R ktbgStatus() {
      return this.set(KtbgMapping.ktbgStatus);
    }

    default R studentId() {
      return this.set(KtbgMapping.studentId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, KtbgQuery> implements ISegment<Selector> {
    public Selector(KtbgQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector ktbgId(String _alias_) {
      return this.process(KtbgMapping.ktbgId, _alias_);
    }

    public Selector column1(String _alias_) {
      return this.process(KtbgMapping.column1, _alias_);
    }

    public Selector column2(String _alias_) {
      return this.process(KtbgMapping.column2, _alias_);
    }

    public Selector ktbgStatus(String _alias_) {
      return this.process(KtbgMapping.ktbgStatus, _alias_);
    }

    public Selector studentId(String _alias_) {
      return this.process(KtbgMapping.studentId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, KtbgQuery, KtbgQuery> {
    public QueryWhere(KtbgQuery query) {
      super(query);
    }

    private QueryWhere(KtbgQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((KtbgQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((KtbgQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, KtbgQuery> ktbgId() {
      return this.set(KtbgMapping.ktbgId);
    }

    public StringWhere<QueryWhere, KtbgQuery> column1() {
      return this.set(KtbgMapping.column1);
    }

    public StringWhere<QueryWhere, KtbgQuery> column2() {
      return this.set(KtbgMapping.column2);
    }

    public NumericWhere<QueryWhere, KtbgQuery> ktbgStatus() {
      return this.set(KtbgMapping.ktbgStatus);
    }

    public StringWhere<QueryWhere, KtbgQuery> studentId() {
      return this.set(KtbgMapping.studentId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, KtbgUpdate, KtbgQuery> {
    public UpdateWhere(KtbgUpdate updater) {
      super(updater);
    }

    private UpdateWhere(KtbgUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((KtbgUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((KtbgUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, KtbgQuery> ktbgId() {
      return this.set(KtbgMapping.ktbgId);
    }

    public StringWhere<UpdateWhere, KtbgQuery> column1() {
      return this.set(KtbgMapping.column1);
    }

    public StringWhere<UpdateWhere, KtbgQuery> column2() {
      return this.set(KtbgMapping.column2);
    }

    public NumericWhere<UpdateWhere, KtbgQuery> ktbgStatus() {
      return this.set(KtbgMapping.ktbgStatus);
    }

    public StringWhere<UpdateWhere, KtbgQuery> studentId() {
      return this.set(KtbgMapping.studentId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, KtbgQuery> implements ISegment<GroupBy> {
    public GroupBy(KtbgQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, KtbgQuery> implements ISegment<HavingOperator<Having>> {
    public Having(KtbgQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, KtbgQuery> implements ISegment<OrderByApply<QueryOrderBy, KtbgQuery>> {
    public QueryOrderBy(KtbgQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, KtbgUpdate> implements ISegment<OrderByApply<UpdateOrderBy, KtbgUpdate>> {
    public UpdateOrderBy(KtbgUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, KtbgUpdate> implements ISegment<UpdateApply<UpdateSetter, KtbgUpdate>> {
    public UpdateSetter(KtbgUpdate updater) {
      super(updater);
    }
  }
}
