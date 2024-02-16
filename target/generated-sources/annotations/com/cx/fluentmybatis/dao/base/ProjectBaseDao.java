package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.ProjectDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.mapper.ProjectMapper;
import com.cx.fluentmybatis.wrapper.ProjectQuery;
import com.cx.fluentmybatis.wrapper.ProjectUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * ProjectBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class ProjectBaseDao extends BaseDao<ProjectEntity> {
  @Resource(
      name = "projectMapper"
  )
  protected ProjectMapper mapper;

  @Override
  public ProjectMapper mapper() {
    return mapper;
  }

  @Override
  protected ProjectQuery query() {
    return new ProjectQuery();
  }

  @Override
  protected ProjectQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected ProjectUpdate updater() {
    return new ProjectUpdate();
  }

  @Override
  protected ProjectUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
