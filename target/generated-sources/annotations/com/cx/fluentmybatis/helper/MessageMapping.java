package com.cx.fluentmybatis.helper;

import static java.util.Optional.ofNullable;

import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldType;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * MessageMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface MessageMapping extends IMapping {
  MessageMapping MAPPING = new MessageMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "message";

  /**
   * Entity名称
   */
  String Entity_Name = "MessageEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  messageId : message_id
   */
  FieldMapping messageId = new FieldMapping("messageId", "message_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  createDate : create_date
   */
  FieldMapping createDate = new FieldMapping("createDate", "create_date");

  /**
   * 实体属性 : 数据库字段 映射
   *  messageBody : message_body
   */
  FieldMapping messageBody = new FieldMapping("messageBody", "message_body");

  /**
   * 实体属性 : 数据库字段 映射
   *  messageType : message_type
   */
  FieldMapping messageType = new FieldMapping("messageType", "message_type");

  /**
   * 实体属性 : 数据库字段 映射
   *  state : state
   */
  FieldMapping state = new FieldMapping("state", "state");

  /**
   * 实体属性 : 数据库字段 映射
   *  toUserId : to_user_id
   */
  FieldMapping toUserId = new FieldMapping("toUserId", "to_user_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  userId : user_id
   */
  FieldMapping userId = new FieldMapping("userId", "user_id");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(messageId.name, messageId.column);
  		this.put(createDate.name, createDate.column);
  		this.put(messageBody.name, messageBody.column);
  		this.put(messageType.name, messageType.column);
  		this.put(state.name, state.column);
  		this.put(toUserId.name, toUserId.column);
  		this.put(userId.name, userId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(messageId.column, messageId);
  		this.put(createDate.column, createDate);
  		this.put(messageBody.column, messageBody);
  		this.put(messageType.column, messageType);
  		this.put(state.column, state);
  		this.put(toUserId.column, toUserId);
  		this.put(userId.column, userId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		messageId.column,
  		createDate.column,
  		messageBody.column,
  		messageType.column,
  		state.column,
  		toUserId.column,
  		userId.column
  );

  /**
   * 数据库所有字段列表用逗号分隔
   */
  String ALL_JOIN_COLUMNS = String.join(", ", ALL_COLUMNS);

  @Override
  default String findColumnByField(String field) {
    return Property2Column.get(field);
  }

  @Override
  default Optional<FieldMapping> findField(FieldType type) {
    switch (type) {
    	case PRIMARY_ID:
    		return ofNullable(messageId);
    	default:
    		return ofNullable(null);
    }
  }
}
