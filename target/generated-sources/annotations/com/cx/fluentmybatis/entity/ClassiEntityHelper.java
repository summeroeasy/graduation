package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.ClassiMapping.*;

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
 * ClassiEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class ClassiEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((ClassiEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((ClassiEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(ClassiEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(classId, entity.getClassId(), isNoN)
    	.put(className, entity.getClassName(), isNoN)
    	.put(subjectId, entity.getSubjectId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    ClassiEntity entity = new ClassiEntity();
    if (map.containsKey(classId.name)) {
    	entity.setClassId((Integer) map.get(classId.name));
    }
    if (map.containsKey(className.name)) {
    	entity.setClassName((String) map.get(className.name));
    }
    if (map.containsKey(subjectId.name)) {
    	entity.setSubjectId((Integer) map.get(subjectId.name));
    }
    return (E)entity;
  }

  @Override
  public ClassiEntity copy(IEntity iEntity) {
    ClassiEntity entity = (ClassiEntity) iEntity;
    ClassiEntity copy = new ClassiEntity();
    {
    	copy.setClassId(entity.getClassId());
    	copy.setClassName(entity.getClassName());
    	copy.setSubjectId(entity.getSubjectId());
    }
    return copy;
  }
}
