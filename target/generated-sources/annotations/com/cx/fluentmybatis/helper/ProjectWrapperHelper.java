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
import com.cx.fluentmybatis.wrapper.ProjectQuery;
import com.cx.fluentmybatis.wrapper.ProjectUpdate;
import java.lang.Override;
import java.lang.String;

/**
 *
 * ProjectWrapperHelper
 *
 * @author powered by FluentMybatis
 */
public class ProjectWrapperHelper {
  /**
   * 默认设置器
   */
  private static final ProjectDefaults defaults = ProjectDefaults.INSTANCE;

  public interface ISegment<R> {
    R set(FieldMapping fieldMapping);

    default R projectId() {
      return this.set(ProjectMapping.projectId);
    }

    default R projectDescribe() {
      return this.set(ProjectMapping.projectDescribe);
    }

    default R projectFromId() {
      return this.set(ProjectMapping.projectFromId);
    }

    default R projectName() {
      return this.set(ProjectMapping.projectName);
    }

    default R projectState() {
      return this.set(ProjectMapping.projectState);
    }

    default R studentId() {
      return this.set(ProjectMapping.studentId);
    }

    default R teacherId() {
      return this.set(ProjectMapping.teacherId);
    }
  }

  /**
   * select字段设置
   */
  public static final class Selector extends SelectorBase<Selector, ProjectQuery> implements ISegment<Selector> {
    public Selector(ProjectQuery query) {
      super(query);
    }

    protected Selector(Selector selector, IAggregate aggregate) {
      super(selector, aggregate);
    }

    @Override
    protected Selector aggregateSegment(IAggregate aggregate) {
      return new Selector(this, aggregate);
    }

    public Selector projectId(String _alias_) {
      return this.process(ProjectMapping.projectId, _alias_);
    }

    public Selector projectDescribe(String _alias_) {
      return this.process(ProjectMapping.projectDescribe, _alias_);
    }

    public Selector projectFromId(String _alias_) {
      return this.process(ProjectMapping.projectFromId, _alias_);
    }

    public Selector projectName(String _alias_) {
      return this.process(ProjectMapping.projectName, _alias_);
    }

    public Selector projectState(String _alias_) {
      return this.process(ProjectMapping.projectState, _alias_);
    }

    public Selector studentId(String _alias_) {
      return this.process(ProjectMapping.studentId, _alias_);
    }

    public Selector teacherId(String _alias_) {
      return this.process(ProjectMapping.teacherId, _alias_);
    }
  }

  /**
   * query where条件设置
   */
  public static class QueryWhere extends WhereBase<QueryWhere, ProjectQuery, ProjectQuery> {
    public QueryWhere(ProjectQuery query) {
      super(query);
    }

    private QueryWhere(ProjectQuery query, QueryWhere where) {
      super(query, where);
    }

    @Override
    protected QueryWhere buildOr(QueryWhere and) {
      return new QueryWhere((ProjectQuery) this.wrapper, and);
    }

    @Override
    public QueryWhere defaults() {
      defaults.setQueryDefault((ProjectQuery) super.wrapper);
      return super.and;
    }

    public NumericWhere<QueryWhere, ProjectQuery> projectId() {
      return this.set(ProjectMapping.projectId);
    }

    public StringWhere<QueryWhere, ProjectQuery> projectDescribe() {
      return this.set(ProjectMapping.projectDescribe);
    }

    public NumericWhere<QueryWhere, ProjectQuery> projectFromId() {
      return this.set(ProjectMapping.projectFromId);
    }

    public StringWhere<QueryWhere, ProjectQuery> projectName() {
      return this.set(ProjectMapping.projectName);
    }

    public NumericWhere<QueryWhere, ProjectQuery> projectState() {
      return this.set(ProjectMapping.projectState);
    }

    public StringWhere<QueryWhere, ProjectQuery> studentId() {
      return this.set(ProjectMapping.studentId);
    }

    public StringWhere<QueryWhere, ProjectQuery> teacherId() {
      return this.set(ProjectMapping.teacherId);
    }
  }

  /**
   * update where条件设置
   */
  public static class UpdateWhere extends WhereBase<UpdateWhere, ProjectUpdate, ProjectQuery> {
    public UpdateWhere(ProjectUpdate updater) {
      super(updater);
    }

    private UpdateWhere(ProjectUpdate updater, UpdateWhere where) {
      super(updater, where);
    }

    @Override
    protected UpdateWhere buildOr(UpdateWhere and) {
      return new UpdateWhere((ProjectUpdate) this.wrapper, and);
    }

    @Override
    public UpdateWhere defaults() {
      defaults.setUpdateDefault((ProjectUpdate) super.wrapper);
      return super.and;
    }

    public NumericWhere<UpdateWhere, ProjectQuery> projectId() {
      return this.set(ProjectMapping.projectId);
    }

    public StringWhere<UpdateWhere, ProjectQuery> projectDescribe() {
      return this.set(ProjectMapping.projectDescribe);
    }

    public NumericWhere<UpdateWhere, ProjectQuery> projectFromId() {
      return this.set(ProjectMapping.projectFromId);
    }

    public StringWhere<UpdateWhere, ProjectQuery> projectName() {
      return this.set(ProjectMapping.projectName);
    }

    public NumericWhere<UpdateWhere, ProjectQuery> projectState() {
      return this.set(ProjectMapping.projectState);
    }

    public StringWhere<UpdateWhere, ProjectQuery> studentId() {
      return this.set(ProjectMapping.studentId);
    }

    public StringWhere<UpdateWhere, ProjectQuery> teacherId() {
      return this.set(ProjectMapping.teacherId);
    }
  }

  /**
   * 分组设置
   */
  public static final class GroupBy extends GroupByBase<GroupBy, ProjectQuery> implements ISegment<GroupBy> {
    public GroupBy(ProjectQuery query) {
      super(query);
    }
  }

  /**
   * 分组Having条件设置
   */
  public static final class Having extends HavingBase<Having, ProjectQuery> implements ISegment<HavingOperator<Having>> {
    public Having(ProjectQuery query) {
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
  public static final class QueryOrderBy extends OrderByBase<QueryOrderBy, ProjectQuery> implements ISegment<OrderByApply<QueryOrderBy, ProjectQuery>> {
    public QueryOrderBy(ProjectQuery query) {
      super(query);
    }
  }

  /**
   * Update OrderBy设置
   */
  public static final class UpdateOrderBy extends OrderByBase<UpdateOrderBy, ProjectUpdate> implements ISegment<OrderByApply<UpdateOrderBy, ProjectUpdate>> {
    public UpdateOrderBy(ProjectUpdate updater) {
      super(updater);
    }
  }

  /**
   * Update set 设置
   */
  public static final class UpdateSetter extends UpdateBase<UpdateSetter, ProjectUpdate> implements ISegment<UpdateApply<UpdateSetter, ProjectUpdate>> {
    public UpdateSetter(ProjectUpdate updater) {
      super(updater);
    }
  }
}
