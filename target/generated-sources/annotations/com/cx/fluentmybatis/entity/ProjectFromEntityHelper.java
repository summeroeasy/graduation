package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.ProjectFromMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 *
 * ProjectFromEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class ProjectFromEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((ProjectFromEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((ProjectFromEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(ProjectFromEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(projectFromId, entity.getProjectFromId(), isNoN)
    	.put(projectFromName, entity.getProjectFromName(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    ProjectFromEntity entity = new ProjectFromEntity();
    if (map.containsKey(projectFromId.name)) {
    	entity.setProjectFromId((Integer) map.get(projectFromId.name));
    }
    if (map.containsKey(projectFromName.name)) {
    	entity.setProjectFromName((String) map.get(projectFromName.name));
    }
    return (E)entity;
  }

  @Override
  public ProjectFromEntity copy(IEntity iEntity) {
    ProjectFromEntity entity = (ProjectFromEntity) iEntity;
    ProjectFromEntity copy = new ProjectFromEntity();
    {
    	copy.setProjectFromId(entity.getProjectFromId());
    	copy.setProjectFromName(entity.getProjectFromName());
    }
    return copy;
  }
}
