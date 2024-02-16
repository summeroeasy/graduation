package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.QzxjMapping.*;

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
 * QzxjEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class QzxjEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((QzxjEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((QzxjEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(QzxjEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(qzxjId, entity.getQzxjId(), isNoN)
    	.put(studentId, entity.getStudentId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    QzxjEntity entity = new QzxjEntity();
    if (map.containsKey(qzxjId.name)) {
    	entity.setQzxjId((Integer) map.get(qzxjId.name));
    }
    if (map.containsKey(studentId.name)) {
    	entity.setStudentId((String) map.get(studentId.name));
    }
    return (E)entity;
  }

  @Override
  public QzxjEntity copy(IEntity iEntity) {
    QzxjEntity entity = (QzxjEntity) iEntity;
    QzxjEntity copy = new QzxjEntity();
    {
    	copy.setQzxjId(entity.getQzxjId());
    	copy.setStudentId(entity.getStudentId());
    }
    return copy;
  }
}
