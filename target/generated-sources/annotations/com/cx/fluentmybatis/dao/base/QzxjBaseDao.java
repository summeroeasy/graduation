package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.QzxjDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.fluentmybatis.mapper.QzxjMapper;
import com.cx.fluentmybatis.wrapper.QzxjQuery;
import com.cx.fluentmybatis.wrapper.QzxjUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * QzxjBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class QzxjBaseDao extends BaseDao<QzxjEntity> {
  @Resource(
      name = "qzxjMapper"
  )
  protected QzxjMapper mapper;

  @Override
  public QzxjMapper mapper() {
    return mapper;
  }

  @Override
  protected QzxjQuery query() {
    return new QzxjQuery();
  }

  @Override
  protected QzxjQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected QzxjUpdate updater() {
    return new QzxjUpdate();
  }

  @Override
  protected QzxjUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
