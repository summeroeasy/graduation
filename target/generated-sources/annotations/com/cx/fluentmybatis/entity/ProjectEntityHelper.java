package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.ProjectMapping.*;

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
 * ProjectEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class ProjectEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((ProjectEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((ProjectEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(ProjectEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(projectId, entity.getProjectId(), isNoN)
    	.put(projectDescribe, entity.getProjectDescribe(), isNoN)
    	.put(projectFromId, entity.getProjectFromId(), isNoN)
    	.put(projectName, entity.getProjectName(), isNoN)
    	.put(projectState, entity.getProjectState(), isNoN)
    	.put(studentId, entity.getStudentId(), isNoN)
    	.put(teacherId, entity.getTeacherId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    ProjectEntity entity = new ProjectEntity();
    if (map.containsKey(projectId.name)) {
    	entity.setProjectId((Integer) map.get(projectId.name));
    }
    if (map.containsKey(projectDescribe.name)) {
    	entity.setProjectDescribe((String) map.get(projectDescribe.name));
    }
    if (map.containsKey(projectFromId.name)) {
    	entity.setProjectFromId((Integer) map.get(projectFromId.name));
    }
    if (map.containsKey(projectName.name)) {
    	entity.setProjectName((String) map.get(projectName.name));
    }
    if (map.containsKey(projectState.name)) {
    	entity.setProjectState((Integer) map.get(projectState.name));
    }
    if (map.containsKey(studentId.name)) {
    	entity.setStudentId((String) map.get(studentId.name));
    }
    if (map.containsKey(teacherId.name)) {
    	entity.setTeacherId((String) map.get(teacherId.name));
    }
    return (E)entity;
  }

  @Override
  public ProjectEntity copy(IEntity iEntity) {
    ProjectEntity entity = (ProjectEntity) iEntity;
    ProjectEntity copy = new ProjectEntity();
    {
    	copy.setProjectId(entity.getProjectId());
    	copy.setProjectDescribe(entity.getProjectDescribe());
    	copy.setProjectFromId(entity.getProjectFromId());
    	copy.setProjectName(entity.getProjectName());
    	copy.setProjectState(entity.getProjectState());
    	copy.setStudentId(entity.getStudentId());
    	copy.setTeacherId(entity.getTeacherId());
    }
    return copy;
  }
}
