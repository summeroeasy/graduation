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
 * PaperlibMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface PaperlibMapping extends IMapping {
  PaperlibMapping MAPPING = new PaperlibMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "paperlib";

  /**
   * Entity名称
   */
  String Entity_Name = "PaperlibEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  id : id
   */
  FieldMapping id = new FieldMapping("id", "id");

  /**
   * 实体属性 : 数据库字段 映射
   *  file : file
   */
  FieldMapping file = new FieldMapping("file", "file");

  /**
   * 实体属性 : 数据库字段 映射
   *  info : info
   */
  FieldMapping info = new FieldMapping("info", "info");

  /**
   * 实体属性 : 数据库字段 映射
   *  name : name
   */
  FieldMapping name = new FieldMapping("name", "name");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(id.name, id.column);
  		this.put(file.name, file.column);
  		this.put(info.name, info.column);
  		this.put(name.name, name.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(id.column, id);
  		this.put(file.column, file);
  		this.put(info.column, info);
  		this.put(name.column, name);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		id.column,
  		file.column,
  		info.column,
  		name.column
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
