package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.KtbgDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.fluentmybatis.mapper.KtbgMapper;
import com.cx.fluentmybatis.wrapper.KtbgQuery;
import com.cx.fluentmybatis.wrapper.KtbgUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * KtbgBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class KtbgBaseDao extends BaseDao<KtbgEntity> {
  @Resource(
      name = "ktbgMapper"
  )
  protected KtbgMapper mapper;

  @Override
  public KtbgMapper mapper() {
    return mapper;
  }

  @Override
  protected KtbgQuery query() {
    return new KtbgQuery();
  }

  @Override
  protected KtbgQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected KtbgUpdate updater() {
    return new KtbgUpdate();
  }

  @Override
  protected KtbgUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
