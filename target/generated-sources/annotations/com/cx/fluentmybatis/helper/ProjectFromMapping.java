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
 * ProjectFromMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface ProjectFromMapping extends IMapping {
  ProjectFromMapping MAPPING = new ProjectFromMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "project_from";

  /**
   * Entity名称
   */
  String Entity_Name = "ProjectFromEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  projectFromId : project_from_id
   */
  FieldMapping projectFromId = new FieldMapping("projectFromId", "project_from_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectFromName : project_from_name
   */
  FieldMapping projectFromName = new FieldMapping("projectFromName", "project_from_name");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(projectFromId.name, projectFromId.column);
  		this.put(projectFromName.name, projectFromName.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(projectFromId.column, projectFromId);
  		this.put(projectFromName.column, projectFromName);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		projectFromId.column,
  		projectFromName.column
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
    		return ofNullable(projectFromId);
    	default:
    		return ofNullable(null);
    }
  }
}
