package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.SessionListMapping.*;

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
 * SessionListEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class SessionListEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((SessionListEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((SessionListEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(SessionListEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(id, entity.getId(), isNoN)
    	.put(listName, entity.getListName(), isNoN)
    	.put(toUserId, entity.getToUserId(), isNoN)
    	.put(unReadCount, entity.getUnReadCount(), isNoN)
    	.put(userId, entity.getUserId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    SessionListEntity entity = new SessionListEntity();
    if (map.containsKey(id.name)) {
    	entity.setId((Integer) map.get(id.name));
    }
    if (map.containsKey(listName.name)) {
    	entity.setListName((String) map.get(listName.name));
    }
    if (map.containsKey(toUserId.name)) {
    	entity.setToUserId((String) map.get(toUserId.name));
    }
    if (map.containsKey(unReadCount.name)) {
    	entity.setUnReadCount((Integer) map.get(unReadCount.name));
    }
    if (map.containsKey(userId.name)) {
    	entity.setUserId((String) map.get(userId.name));
    }
    return (E)entity;
  }

  @Override
  public SessionListEntity copy(IEntity iEntity) {
    SessionListEntity entity = (SessionListEntity) iEntity;
    SessionListEntity copy = new SessionListEntity();
    {
    	copy.setId(entity.getId());
    	copy.setListName(entity.getListName());
    	copy.setToUserId(entity.getToUserId());
    	copy.setUnReadCount(entity.getUnReadCount());
    	copy.setUserId(entity.getUserId());
    }
    return copy;
  }
}
