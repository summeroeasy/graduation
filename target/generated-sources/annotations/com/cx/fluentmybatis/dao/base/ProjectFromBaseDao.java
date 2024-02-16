package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.ProjectFromDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.ProjectFromEntity;
import com.cx.fluentmybatis.mapper.ProjectFromMapper;
import com.cx.fluentmybatis.wrapper.ProjectFromQuery;
import com.cx.fluentmybatis.wrapper.ProjectFromUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * ProjectFromBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class ProjectFromBaseDao extends BaseDao<ProjectFromEntity> {
  @Resource(
      name = "projectFromMapper"
  )
  protected ProjectFromMapper mapper;

  @Override
  public ProjectFromMapper mapper() {
    return mapper;
  }

  @Override
  protected ProjectFromQuery query() {
    return new ProjectFromQuery();
  }

  @Override
  protected ProjectFromQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected ProjectFromUpdate updater() {
    return new ProjectFromUpdate();
  }

  @Override
  protected ProjectFromUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
