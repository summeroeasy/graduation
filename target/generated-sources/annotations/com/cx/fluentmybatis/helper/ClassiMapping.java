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
 * ClassiMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface ClassiMapping extends IMapping {
  ClassiMapping MAPPING = new ClassiMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "classi";

  /**
   * Entity名称
   */
  String Entity_Name = "ClassiEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  classId : class_id
   */
  FieldMapping classId = new FieldMapping("classId", "class_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  className : class_name
   */
  FieldMapping className = new FieldMapping("className", "class_name");

  /**
   * 实体属性 : 数据库字段 映射
   *  subjectId : subject_id
   */
  FieldMapping subjectId = new FieldMapping("subjectId", "subject_id");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(classId.name, classId.column);
  		this.put(className.name, className.column);
  		this.put(subjectId.name, subjectId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(classId.column, classId);
  		this.put(className.column, className);
  		this.put(subjectId.column, subjectId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		classId.column,
  		className.column,
  		subjectId.column
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
    		return ofNullable(classId);
    	default:
    		return ofNullable(null);
    }
  }
}
