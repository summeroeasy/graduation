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
import com.cx.fluentmybatis.wrapper.ClassiQuery;
import com.cx.fluentmybatis.wrapper.ClassiUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * ClassiWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class ClassiWrapperHelper {
  /**
   * 默认设置器
   */
  private static final ClassiDefaults defaults = ClassiDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R classId() {
      return this.set(ClassiMapping.classId);
    }

    default R className() {
      return this.set(ClassiMapping.className);
    }

    default R subjectId() {
      return this.set(ClassiMapping.subjectId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, ClassiQuery> implements ISegment<Selector> {
    public Selector(ClassiQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector classId(String _alias_) {
      return this.process(ClassiMapping.classId, _alias_);
    }

    public Selector className(String _alias_) {
      return this.process(ClassiMapping.className, _alias_);
    }

    public Selector subjectId(String _alias_) {
      return this.process(ClassiMapping.subjectId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, ClassiQuery, ClassiQuery> {
    public QueryWhere(ClassiQuery query) {
      super(query);
    }

    private QueryWhere(ClassiQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((ClassiQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((ClassiQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, ClassiQuery> classId() {
      return this.set(ClassiMapping.classId);
    }

    public StringWhere<QueryWhere, ClassiQuery> className() {
      return this.set(ClassiMapping.className);
    }

    public NumericWhere<QueryWhere, ClassiQuery> subjectId() {
      return this.set(ClassiMapping.subjectId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, ClassiUpdate, ClassiQuery> {
    public UpdateWhere(ClassiUpdate updater) {
      super(updater);
    }

    private UpdateWhere(ClassiUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((ClassiUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((ClassiUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, ClassiQuery> classId() {
      return this.set(ClassiMapping.classId);
    }

    public StringWhere<UpdateWhere, ClassiQuery> className() {
      return this.set(ClassiMapping.className);
    }

    public NumericWhere<UpdateWhere, ClassiQuery> subjectId() {
      return this.set(ClassiMapping.subjectId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, ClassiQuery> implements ISegment<GroupBy> {
    public GroupBy(ClassiQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, ClassiQuery> implements ISegment<HavingOperator<Having>> {
    public Having(ClassiQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, ClassiQuery> implements ISegment<OrderByApply<QueryOrderBy, ClassiQuery>> {
    public QueryOrderBy(ClassiQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, ClassiUpdate> implements ISegment<OrderByApply<UpdateOrderBy, ClassiUpdate>> {
    public UpdateOrderBy(ClassiUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, ClassiUpdate> implements ISegment<UpdateApply<UpdateSetter, ClassiUpdate>> {
    public UpdateSetter(ClassiUpdate updater) {
      super(updater);
    }
  }
}
