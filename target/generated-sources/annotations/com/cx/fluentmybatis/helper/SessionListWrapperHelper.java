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
import com.cx.fluentmybatis.wrapper.SessionListQuery;
import com.cx.fluentmybatis.wrapper.SessionListUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * SessionListWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class SessionListWrapperHelper {
  /**
   * 默认设置器
   */
  private static final SessionListDefaults defaults = SessionListDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R id() {
      return this.set(SessionListMapping.id);
    }

    default R listName() {
      return this.set(SessionListMapping.listName);
    }

    default R toUserId() {
      return this.set(SessionListMapping.toUserId);
    }

    default R unReadCount() {
      return this.set(SessionListMapping.unReadCount);
    }

    default R userId() {
      return this.set(SessionListMapping.userId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, SessionListQuery> implements ISegment<Selector> {
    public Selector(SessionListQuery query) {
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
      return this.process(SessionListMapping.id, _alias_);
    }

    public Selector listName(String _alias_) {
      return this.process(SessionListMapping.listName, _alias_);
    }

    public Selector toUserId(String _alias_) {
      return this.process(SessionListMapping.toUserId, _alias_);
    }

    public Selector unReadCount(String _alias_) {
      return this.process(SessionListMapping.unReadCount, _alias_);
    }

    public Selector userId(String _alias_) {
      return this.process(SessionListMapping.userId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, SessionListQuery, SessionListQuery> {
    public QueryWhere(SessionListQuery query) {
      super(query);
    }

    private QueryWhere(SessionListQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((SessionListQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((SessionListQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, SessionListQuery> id() {
      return this.set(SessionListMapping.id);
    }

    public StringWhere<QueryWhere, SessionListQuery> listName() {
      return this.set(SessionListMapping.listName);
    }

    public StringWhere<QueryWhere, SessionListQuery> toUserId() {
      return this.set(SessionListMapping.toUserId);
    }

    public NumericWhere<QueryWhere, SessionListQuery> unReadCount() {
      return this.set(SessionListMapping.unReadCount);
    }

    public StringWhere<QueryWhere, SessionListQuery> userId() {
      return this.set(SessionListMapping.userId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, SessionListUpdate, SessionListQuery> {
    public UpdateWhere(SessionListUpdate updater) {
      super(updater);
    }

    private UpdateWhere(SessionListUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((SessionListUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((SessionListUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, SessionListQuery> id() {
      return this.set(SessionListMapping.id);
    }

    public StringWhere<UpdateWhere, SessionListQuery> listName() {
      return this.set(SessionListMapping.listName);
    }

    public StringWhere<UpdateWhere, SessionListQuery> toUserId() {
      return this.set(SessionListMapping.toUserId);
    }

    public NumericWhere<UpdateWhere, SessionListQuery> unReadCount() {
      return this.set(SessionListMapping.unReadCount);
    }

    public StringWhere<UpdateWhere, SessionListQuery> userId() {
      return this.set(SessionListMapping.userId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, SessionListQuery> implements ISegment<GroupBy> {
    public GroupBy(SessionListQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, SessionListQuery> implements ISegment<HavingOperator<Having>> {
    public Having(SessionListQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, SessionListQuery> implements ISegment<OrderByApply<QueryOrderBy, SessionListQuery>> {
    public QueryOrderBy(SessionListQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, SessionListUpdate> implements ISegment<OrderByApply<UpdateOrderBy, SessionListUpdate>> {
    public UpdateOrderBy(SessionListUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, SessionListUpdate> implements ISegment<UpdateApply<UpdateSetter, SessionListUpdate>> {
    public UpdateSetter(SessionListUpdate updater) {
      super(updater);
    }
  }
}
