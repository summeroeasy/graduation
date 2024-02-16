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
import com.cx.fluentmybatis.wrapper.ProjectFromQuery;
import com.cx.fluentmybatis.wrapper.ProjectFromUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * ProjectFromWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class ProjectFromWrapperHelper {
  /**
   * 默认设置器
   */
  private static final ProjectFromDefaults defaults = ProjectFromDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R projectFromId() {
      return this.set(ProjectFromMapping.projectFromId);
    }

    default R projectFromName() {
      return this.set(ProjectFromMapping.projectFromName);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, ProjectFromQuery> implements ISegment<Selector> {
    public Selector(ProjectFromQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector projectFromId(String _alias_) {
      return this.process(ProjectFromMapping.projectFromId, _alias_);
    }

    public Selector projectFromName(String _alias_) {
      return this.process(ProjectFromMapping.projectFromName, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, ProjectFromQuery, ProjectFromQuery> {
    public QueryWhere(ProjectFromQuery query) {
      super(query);
    }

    private QueryWhere(ProjectFromQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((ProjectFromQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((ProjectFromQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, ProjectFromQuery> projectFromId() {
      return this.set(ProjectFromMapping.projectFromId);
    }

    public StringWhere<QueryWhere, ProjectFromQuery> projectFromName() {
      return this.set(ProjectFromMapping.projectFromName);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, ProjectFromUpdate, ProjectFromQuery> {
    public UpdateWhere(ProjectFromUpdate updater) {
      super(updater);
    }

    private UpdateWhere(ProjectFromUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((ProjectFromUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((ProjectFromUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, ProjectFromQuery> projectFromId() {
      return this.set(ProjectFromMapping.projectFromId);
    }

    public StringWhere<UpdateWhere, ProjectFromQuery> projectFromName() {
      return this.set(ProjectFromMapping.projectFromName);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, ProjectFromQuery> implements ISegment<GroupBy> {
    public GroupBy(ProjectFromQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, ProjectFromQuery> implements ISegment<HavingOperator<Having>> {
    public Having(ProjectFromQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, ProjectFromQuery> implements ISegment<OrderByApply<QueryOrderBy, ProjectFromQuery>> {
    public QueryOrderBy(ProjectFromQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, ProjectFromUpdate> implements ISegment<OrderByApply<UpdateOrderBy, ProjectFromUpdate>> {
    public UpdateOrderBy(ProjectFromUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, ProjectFromUpdate> implements ISegment<UpdateApply<UpdateSetter, ProjectFromUpdate>> {
    public UpdateSetter(ProjectFromUpdate updater) {
      super(updater);
    }
  }
}
