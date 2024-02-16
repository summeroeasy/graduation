package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.ClassiDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.ClassiEntity;
import com.cx.fluentmybatis.mapper.ClassiMapper;
import com.cx.fluentmybatis.wrapper.ClassiQuery;
import com.cx.fluentmybatis.wrapper.ClassiUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * ClassiBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class ClassiBaseDao extends BaseDao<ClassiEntity> {
  @Resource(
      name = "classiMapper"
  )
  protected ClassiMapper mapper;

  @Override
  public ClassiMapper mapper() {
    return mapper;
  }

  @Override
  protected ClassiQuery query() {
    return new ClassiQuery();
  }

  @Override
  protected ClassiQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected ClassiUpdate updater() {
    return new ClassiUpdate();
  }

  @Override
  protected ClassiUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
