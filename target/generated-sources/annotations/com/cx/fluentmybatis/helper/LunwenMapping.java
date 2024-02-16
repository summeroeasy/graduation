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
 * LunwenMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface LunwenMapping extends IMapping {
  LunwenMapping MAPPING = new LunwenMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "lunwen";

  /**
   * Entity名称
   */
  String Entity_Name = "LunwenEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  lunwenId : lunwen_id
   */
  FieldMapping lunwenId = new FieldMapping("lunwenId", "lunwen_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  lunwenDate : lunwen_date
   */
  FieldMapping lunwenDate = new FieldMapping("lunwenDate", "lunwen_date");

  /**
   * 实体属性 : 数据库字段 映射
   *  lunwenName : lunwen_name
   */
  FieldMapping lunwenName = new FieldMapping("lunwenName", "lunwen_name");

  /**
   * 实体属性 : 数据库字段 映射
   *  lunwenPath : lunwen_path
   */
  FieldMapping lunwenPath = new FieldMapping("lunwenPath", "lunwen_path");

  /**
   * 实体属性 : 数据库字段 映射
   *  lunwenStatus : lunwen_status
   */
  FieldMapping lunwenStatus = new FieldMapping("lunwenStatus", "lunwen_status");

  /**
   * 实体属性 : 数据库字段 映射
   *  studentId : student_id
   */
  FieldMapping studentId = new FieldMapping("studentId", "student_id");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(lunwenId.name, lunwenId.column);
  		this.put(lunwenDate.name, lunwenDate.column);
  		this.put(lunwenName.name, lunwenName.column);
  		this.put(lunwenPath.name, lunwenPath.column);
  		this.put(lunwenStatus.name, lunwenStatus.column);
  		this.put(studentId.name, studentId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(lunwenId.column, lunwenId);
  		this.put(lunwenDate.column, lunwenDate);
  		this.put(lunwenName.column, lunwenName);
  		this.put(lunwenPath.column, lunwenPath);
  		this.put(lunwenStatus.column, lunwenStatus);
  		this.put(studentId.column, studentId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		lunwenId.column,
  		lunwenDate.column,
  		lunwenName.column,
  		lunwenPath.column,
  		lunwenStatus.column,
  		studentId.column
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
    		return ofNullable(lunwenId);
    	default:
    		return ofNullable(null);
    }
  }
}
