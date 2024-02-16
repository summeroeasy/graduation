package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.PaperlibDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.fluentmybatis.mapper.PaperlibMapper;
import com.cx.fluentmybatis.wrapper.PaperlibQuery;
import com.cx.fluentmybatis.wrapper.PaperlibUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * PaperlibBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class PaperlibBaseDao extends BaseDao<PaperlibEntity> {
  @Resource(
      name = "paperlibMapper"
  )
  protected PaperlibMapper mapper;

  @Override
  public PaperlibMapper mapper() {
    return mapper;
  }

  @Override
  protected PaperlibQuery query() {
    return new PaperlibQuery();
  }

  @Override
  protected PaperlibQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected PaperlibUpdate updater() {
    return new PaperlibUpdate();
  }

  @Override
  protected PaperlibUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
