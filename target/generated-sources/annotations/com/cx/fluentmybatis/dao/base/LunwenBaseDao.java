package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.LunwenDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.fluentmybatis.mapper.LunwenMapper;
import com.cx.fluentmybatis.wrapper.LunwenQuery;
import com.cx.fluentmybatis.wrapper.LunwenUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * LunwenBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class LunwenBaseDao extends BaseDao<LunwenEntity> {
  @Resource(
      name = "lunwenMapper"
  )
  protected LunwenMapper mapper;

  @Override
  public LunwenMapper mapper() {
    return mapper;
  }

  @Override
  protected LunwenQuery query() {
    return new LunwenQuery();
  }

  @Override
  protected LunwenQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected LunwenUpdate updater() {
    return new LunwenUpdate();
  }

  @Override
  protected LunwenUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
