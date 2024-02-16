package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.LunwenMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Date;
import java.util.Map;

/**
 *
 * LunwenEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class LunwenEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((LunwenEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((LunwenEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(LunwenEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(lunwenId, entity.getLunwenId(), isNoN)
    	.put(lunwenDate, entity.getLunwenDate(), isNoN)
    	.put(lunwenName, entity.getLunwenName(), isNoN)
    	.put(lunwenPath, entity.getLunwenPath(), isNoN)
    	.put(lunwenStatus, entity.getLunwenStatus(), isNoN)
    	.put(studentId, entity.getStudentId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    LunwenEntity entity = new LunwenEntity();
    if (map.containsKey(lunwenId.name)) {
    	entity.setLunwenId((Integer) map.get(lunwenId.name));
    }
    if (map.containsKey(lunwenDate.name)) {
    	entity.setLunwenDate((Date) map.get(lunwenDate.name));
    }
    if (map.containsKey(lunwenName.name)) {
    	entity.setLunwenName((String) map.get(lunwenName.name));
    }
    if (map.containsKey(lunwenPath.name)) {
    	entity.setLunwenPath((String) map.get(lunwenPath.name));
    }
    if (map.containsKey(lunwenStatus.name)) {
    	entity.setLunwenStatus((Integer) map.get(lunwenStatus.name));
    }
    if (map.containsKey(studentId.name)) {
    	entity.setStudentId((String) map.get(studentId.name));
    }
    return (E)entity;
  }

  @Override
  public LunwenEntity copy(IEntity iEntity) {
    LunwenEntity entity = (LunwenEntity) iEntity;
    LunwenEntity copy = new LunwenEntity();
    {
    	copy.setLunwenId(entity.getLunwenId());
    	copy.setLunwenDate(entity.getLunwenDate());
    	copy.setLunwenName(entity.getLunwenName());
    	copy.setLunwenPath(entity.getLunwenPath());
    	copy.setLunwenStatus(entity.getLunwenStatus());
    	copy.setStudentId(entity.getStudentId());
    }
    return copy;
  }
}
