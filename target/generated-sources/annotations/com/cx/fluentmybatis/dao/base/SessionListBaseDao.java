package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.SessionListDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.mapper.SessionListMapper;
import com.cx.fluentmybatis.wrapper.SessionListQuery;
import com.cx.fluentmybatis.wrapper.SessionListUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * SessionListBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class SessionListBaseDao extends BaseDao<SessionListEntity> {
  @Resource(
      name = "sessionListMapper"
  )
  protected SessionListMapper mapper;

  @Override
  public SessionListMapper mapper() {
    return mapper;
  }

  @Override
  protected SessionListQuery query() {
    return new SessionListQuery();
  }

  @Override
  protected SessionListQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected SessionListUpdate updater() {
    return new SessionListUpdate();
  }

  @Override
  protected SessionListUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
