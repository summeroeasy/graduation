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
import com.cx.fluentmybatis.wrapper.QzxjQuery;
import com.cx.fluentmybatis.wrapper.QzxjUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * QzxjWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class QzxjWrapperHelper {
  /**
   * 默认设置器
   */
  private static final QzxjDefaults defaults = QzxjDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R qzxjId() {
      return this.set(QzxjMapping.qzxjId);
    }

    default R studentId() {
      return this.set(QzxjMapping.studentId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, QzxjQuery> implements ISegment<Selector> {
    public Selector(QzxjQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector qzxjId(String _alias_) {
      return this.process(QzxjMapping.qzxjId, _alias_);
    }

    public Selector studentId(String _alias_) {
      return this.process(QzxjMapping.studentId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, QzxjQuery, QzxjQuery> {
    public QueryWhere(QzxjQuery query) {
      super(query);
    }

    private QueryWhere(QzxjQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((QzxjQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((QzxjQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, QzxjQuery> qzxjId() {
      return this.set(QzxjMapping.qzxjId);
    }

    public StringWhere<QueryWhere, QzxjQuery> studentId() {
      return this.set(QzxjMapping.studentId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, QzxjUpdate, QzxjQuery> {
    public UpdateWhere(QzxjUpdate updater) {
      super(updater);
    }

    private UpdateWhere(QzxjUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((QzxjUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((QzxjUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, QzxjQuery> qzxjId() {
      return this.set(QzxjMapping.qzxjId);
    }

    public StringWhere<UpdateWhere, QzxjQuery> studentId() {
      return this.set(QzxjMapping.studentId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, QzxjQuery> implements ISegment<GroupBy> {
    public GroupBy(QzxjQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, QzxjQuery> implements ISegment<HavingOperator<Having>> {
    public Having(QzxjQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, QzxjQuery> implements ISegment<OrderByApply<QueryOrderBy, QzxjQuery>> {
    public QueryOrderBy(QzxjQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, QzxjUpdate> implements ISegment<OrderByApply<UpdateOrderBy, QzxjUpdate>> {
    public UpdateOrderBy(QzxjUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, QzxjUpdate> implements ISegment<UpdateApply<UpdateSetter, QzxjUpdate>> {
    public UpdateSetter(QzxjUpdate updater) {
      super(updater);
    }
  }
}
