package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.MessageMapping.*;

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
 * MessageEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class MessageEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((MessageEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((MessageEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(MessageEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(messageId, entity.getMessageId(), isNoN)
    	.put(createDate, entity.getCreateDate(), isNoN)
    	.put(messageBody, entity.getMessageBody(), isNoN)
    	.put(messageType, entity.getMessageType(), isNoN)
    	.put(state, entity.getState(), isNoN)
    	.put(toUserId, entity.getToUserId(), isNoN)
    	.put(userId, entity.getUserId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    MessageEntity entity = new MessageEntity();
    if (map.containsKey(messageId.name)) {
    	entity.setMessageId((Integer) map.get(messageId.name));
    }
    if (map.containsKey(createDate.name)) {
    	entity.setCreateDate((Date) map.get(createDate.name));
    }
    if (map.containsKey(messageBody.name)) {
    	entity.setMessageBody((String) map.get(messageBody.name));
    }
    if (map.containsKey(messageType.name)) {
    	entity.setMessageType((Integer) map.get(messageType.name));
    }
    if (map.containsKey(state.name)) {
    	entity.setState((Integer) map.get(state.name));
    }
    if (map.containsKey(toUserId.name)) {
    	entity.setToUserId((String) map.get(toUserId.name));
    }
    if (map.containsKey(userId.name)) {
    	entity.setUserId((String) map.get(userId.name));
    }
    return (E)entity;
  }

  @Override
  public MessageEntity copy(IEntity iEntity) {
    MessageEntity entity = (MessageEntity) iEntity;
    MessageEntity copy = new MessageEntity();
    {
    	copy.setMessageId(entity.getMessageId());
    	copy.setCreateDate(entity.getCreateDate());
    	copy.setMessageBody(entity.getMessageBody());
    	copy.setMessageType(entity.getMessageType());
    	copy.setState(entity.getState());
    	copy.setToUserId(entity.getToUserId());
    	copy.setUserId(entity.getUserId());
    }
    return copy;
  }
}
