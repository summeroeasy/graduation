package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.PaperlibMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 *
 * PaperlibEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class PaperlibEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((PaperlibEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((PaperlibEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(PaperlibEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(id, entity.getId(), isNoN)
    	.put(file, entity.getFile(), isNoN)
    	.put(info, entity.getInfo(), isNoN)
    	.put(name, entity.getName(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    PaperlibEntity entity = new PaperlibEntity();
    if (map.containsKey(id.name)) {
    	entity.setId((Long) map.get(id.name));
    }
    if (map.containsKey(file.name)) {
    	entity.setFile((String) map.get(file.name));
    }
    if (map.containsKey(info.name)) {
    	entity.setInfo((String) map.get(info.name));
    }
    if (map.containsKey(name.name)) {
    	entity.setName((String) map.get(name.name));
    }
    return (E)entity;
  }

  @Override
  public PaperlibEntity copy(IEntity iEntity) {
    PaperlibEntity entity = (PaperlibEntity) iEntity;
    PaperlibEntity copy = new PaperlibEntity();
    {
    	copy.setId(entity.getId());
    	copy.setFile(entity.getFile());
    	copy.setInfo(entity.getInfo());
    	copy.setName(entity.getName());
    }
    return copy;
  }
}
