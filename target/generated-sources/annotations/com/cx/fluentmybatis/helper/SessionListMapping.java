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
 * SessionListMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface SessionListMapping extends IMapping {
  SessionListMapping MAPPING = new SessionListMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "sessionList";

  /**
   * Entity名称
   */
  String Entity_Name = "SessionListEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  id : id
   */
  FieldMapping id = new FieldMapping("id", "id");

  /**
   * 实体属性 : 数据库字段 映射
   *  listName : list_name
   */
  FieldMapping listName = new FieldMapping("listName", "list_name");

  /**
   * 实体属性 : 数据库字段 映射
   *  toUserId : to_user_id
   */
  FieldMapping toUserId = new FieldMapping("toUserId", "to_user_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  unReadCount : un_read_count
   */
  FieldMapping unReadCount = new FieldMapping("unReadCount", "un_read_count");

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
  		this.put(id.name, id.column);
  		this.put(listName.name, listName.column);
  		this.put(toUserId.name, toUserId.column);
  		this.put(unReadCount.name, unReadCount.column);
  		this.put(userId.name, userId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(id.column, id);
  		this.put(listName.column, listName);
  		this.put(toUserId.column, toUserId);
  		this.put(unReadCount.column, unReadCount);
  		this.put(userId.column, userId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		id.column,
  		listName.column,
  		toUserId.column,
  		unReadCount.column,
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
    		return ofNullable(id);
    	default:
    		return ofNullable(null);
    }
  }
}
