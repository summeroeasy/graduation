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
import com.cx.fluentmybatis.wrapper.MessageQuery;
import com.cx.fluentmybatis.wrapper.MessageUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * MessageWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class MessageWrapperHelper {
  /**
   * 默认设置器
   */
  private static final MessageDefaults defaults = MessageDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R messageId() {
      return this.set(MessageMapping.messageId);
    }

    default R createDate() {
      return this.set(MessageMapping.createDate);
    }

    default R messageBody() {
      return this.set(MessageMapping.messageBody);
    }

    default R messageType() {
      return this.set(MessageMapping.messageType);
    }

    default R state() {
      return this.set(MessageMapping.state);
    }

    default R toUserId() {
      return this.set(MessageMapping.toUserId);
    }

    default R userId() {
      return this.set(MessageMapping.userId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, MessageQuery> implements ISegment<Selector> {
    public Selector(MessageQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector messageId(String _alias_) {
      return this.process(MessageMapping.messageId, _alias_);
    }

    public Selector createDate(String _alias_) {
      return this.process(MessageMapping.createDate, _alias_);
    }

    public Selector messageBody(String _alias_) {
      return this.process(MessageMapping.messageBody, _alias_);
    }

    public Selector messageType(String _alias_) {
      return this.process(MessageMapping.messageType, _alias_);
    }

    public Selector state(String _alias_) {
      return this.process(MessageMapping.state, _alias_);
    }

    public Selector toUserId(String _alias_) {
      return this.process(MessageMapping.toUserId, _alias_);
    }

    public Selector userId(String _alias_) {
      return this.process(MessageMapping.userId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, MessageQuery, MessageQuery> {
    public QueryWhere(MessageQuery query) {
      super(query);
    }

    private QueryWhere(MessageQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((MessageQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((MessageQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, MessageQuery> messageId() {
      return this.set(MessageMapping.messageId);
    }

    public ObjectWhere<QueryWhere, MessageQuery> createDate() {
      return this.set(MessageMapping.createDate);
    }

    public StringWhere<QueryWhere, MessageQuery> messageBody() {
      return this.set(MessageMapping.messageBody);
    }

    public NumericWhere<QueryWhere, MessageQuery> messageType() {
      return this.set(MessageMapping.messageType);
    }

    public NumericWhere<QueryWhere, MessageQuery> state() {
      return this.set(MessageMapping.state);
    }

    public StringWhere<QueryWhere, MessageQuery> toUserId() {
      return this.set(MessageMapping.toUserId);
    }

    public StringWhere<QueryWhere, MessageQuery> userId() {
      return this.set(MessageMapping.userId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, MessageUpdate, MessageQuery> {
    public UpdateWhere(MessageUpdate updater) {
      super(updater);
    }

    private UpdateWhere(MessageUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((MessageUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((MessageUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, MessageQuery> messageId() {
      return this.set(MessageMapping.messageId);
    }

    public ObjectWhere<UpdateWhere, MessageQuery> createDate() {
      return this.set(MessageMapping.createDate);
    }

    public StringWhere<UpdateWhere, MessageQuery> messageBody() {
      return this.set(MessageMapping.messageBody);
    }

    public NumericWhere<UpdateWhere, MessageQuery> messageType() {
      return this.set(MessageMapping.messageType);
    }

    public NumericWhere<UpdateWhere, MessageQuery> state() {
      return this.set(MessageMapping.state);
    }

    public StringWhere<UpdateWhere, MessageQuery> toUserId() {
      return this.set(MessageMapping.toUserId);
    }

    public StringWhere<UpdateWhere, MessageQuery> userId() {
      return this.set(MessageMapping.userId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, MessageQuery> implements ISegment<GroupBy> {
    public GroupBy(MessageQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, MessageQuery> implements ISegment<HavingOperator<Having>> {
    public Having(MessageQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, MessageQuery> implements ISegment<OrderByApply<QueryOrderBy, MessageQuery>> {
    public QueryOrderBy(MessageQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, MessageUpdate> implements ISegment<OrderByApply<UpdateOrderBy, MessageUpdate>> {
    public UpdateOrderBy(MessageUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, MessageUpdate> implements ISegment<UpdateApply<UpdateSetter, MessageUpdate>> {
    public UpdateSetter(MessageUpdate updater) {
      super(updater);
    }
  }
}
