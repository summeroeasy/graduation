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
import cn.org.atool.fluent.mybatis.segment.where.ObjectWhere;
import cn.org.atool.fluent.mybatis.segment.where.StringWhere;
import com.cx.fluentmybatis.wrapper.LunwenQuery;
import com.cx.fluentmybatis.wrapper.LunwenUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * LunwenWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class LunwenWrapperHelper {
  /**
   * 默认设置器
   */
  private static final LunwenDefaults defaults = LunwenDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R lunwenId() {
      return this.set(LunwenMapping.lunwenId);
    }

    default R lunwenDate() {
      return this.set(LunwenMapping.lunwenDate);
    }

    default R lunwenName() {
      return this.set(LunwenMapping.lunwenName);
    }

    default R lunwenPath() {
      return this.set(LunwenMapping.lunwenPath);
    }

    default R lunwenStatus() {
      return this.set(LunwenMapping.lunwenStatus);
    }

    default R studentId() {
      return this.set(LunwenMapping.studentId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, LunwenQuery> implements ISegment<Selector> {
    public Selector(LunwenQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector lunwenId(String _alias_) {
      return this.process(LunwenMapping.lunwenId, _alias_);
    }

    public Selector lunwenDate(String _alias_) {
      return this.process(LunwenMapping.lunwenDate, _alias_);
    }

    public Selector lunwenName(String _alias_) {
      return this.process(LunwenMapping.lunwenName, _alias_);
    }

    public Selector lunwenPath(String _alias_) {
      return this.process(LunwenMapping.lunwenPath, _alias_);
    }

    public Selector lunwenStatus(String _alias_) {
      return this.process(LunwenMapping.lunwenStatus, _alias_);
    }

    public Selector studentId(String _alias_) {
      return this.process(LunwenMapping.studentId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, LunwenQuery, LunwenQuery> {
    public QueryWhere(LunwenQuery query) {
      super(query);
    }

    private QueryWhere(LunwenQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((LunwenQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((LunwenQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, LunwenQuery> lunwenId() {
      return this.set(LunwenMapping.lunwenId);
    }

    public ObjectWhere<QueryWhere, LunwenQuery> lunwenDate() {
      return this.set(LunwenMapping.lunwenDate);
    }

    public StringWhere<QueryWhere, LunwenQuery> lunwenName() {
      return this.set(LunwenMapping.lunwenName);
    }

    public StringWhere<QueryWhere, LunwenQuery> lunwenPath() {
      return this.set(LunwenMapping.lunwenPath);
    }

    public NumericWhere<QueryWhere, LunwenQuery> lunwenStatus() {
      return this.set(LunwenMapping.lunwenStatus);
    }

    public StringWhere<QueryWhere, LunwenQuery> studentId() {
      return this.set(LunwenMapping.studentId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, LunwenUpdate, LunwenQuery> {
    public UpdateWhere(LunwenUpdate updater) {
      super(updater);
    }

    private UpdateWhere(LunwenUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((LunwenUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((LunwenUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, LunwenQuery> lunwenId() {
      return this.set(LunwenMapping.lunwenId);
    }

    public ObjectWhere<UpdateWhere, LunwenQuery> lunwenDate() {
      return this.set(LunwenMapping.lunwenDate);
    }

    public StringWhere<UpdateWhere, LunwenQuery> lunwenName() {
      return this.set(LunwenMapping.lunwenName);
    }

    public StringWhere<UpdateWhere, LunwenQuery> lunwenPath() {
      return this.set(LunwenMapping.lunwenPath);
    }

    public NumericWhere<UpdateWhere, LunwenQuery> lunwenStatus() {
      return this.set(LunwenMapping.lunwenStatus);
    }

    public StringWhere<UpdateWhere, LunwenQuery> studentId() {
      return this.set(LunwenMapping.studentId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, LunwenQuery> implements ISegment<GroupBy> {
    public GroupBy(LunwenQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, LunwenQuery> implements ISegment<HavingOperator<Having>> {
    public Having(LunwenQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, LunwenQuery> implements ISegment<OrderByApply<QueryOrderBy, LunwenQuery>> {
    public QueryOrderBy(LunwenQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, LunwenUpdate> implements ISegment<OrderByApply<UpdateOrderBy, LunwenUpdate>> {
    public UpdateOrderBy(LunwenUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, LunwenUpdate> implements ISegment<UpdateApply<UpdateSetter, LunwenUpdate>> {
    public UpdateSetter(LunwenUpdate updater) {
      super(updater);
    }
  }
}
