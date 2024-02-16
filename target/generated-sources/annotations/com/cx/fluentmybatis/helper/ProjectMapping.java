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
 * ProjectMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface ProjectMapping extends IMapping {
  ProjectMapping MAPPING = new ProjectMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "project";

  /**
   * Entity名称
   */
  String Entity_Name = "ProjectEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  projectId : project_id
   */
  FieldMapping projectId = new FieldMapping("projectId", "project_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectDescribe : project_describe
   */
  FieldMapping projectDescribe = new FieldMapping("projectDescribe", "project_describe");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectFromId : project_from_id
   */
  FieldMapping projectFromId = new FieldMapping("projectFromId", "project_from_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectName : project_name
   */
  FieldMapping projectName = new FieldMapping("projectName", "project_name");

  /**
   * 实体属性 : 数据库字段 映射
   *  projectState : project_state
   */
  FieldMapping projectState = new FieldMapping("projectState", "project_state");

  /**
   * 实体属性 : 数据库字段 映射
   *  studentId : student_id
   */
  FieldMapping studentId = new FieldMapping("studentId", "student_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  teacherId : teacher_id
   */
  FieldMapping teacherId = new FieldMapping("teacherId", "teacher_id");

  /**
   * 实例属性和数据库字段对应表
   */
  Map<String, String> Property2Column = new HashMap<String, String>() {
    {
  		this.put(projectId.name, projectId.column);
  		this.put(projectDescribe.name, projectDescribe.column);
  		this.put(projectFromId.name, projectFromId.column);
  		this.put(projectName.name, projectName.column);
  		this.put(projectState.name, projectState.column);
  		this.put(studentId.name, studentId.column);
  		this.put(teacherId.name, teacherId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(projectId.column, projectId);
  		this.put(projectDescribe.column, projectDescribe);
  		this.put(projectFromId.column, projectFromId);
  		this.put(projectName.column, projectName);
  		this.put(projectState.column, projectState);
  		this.put(studentId.column, studentId);
  		this.put(teacherId.column, teacherId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		projectId.column,
  		projectDescribe.column,
  		projectFromId.column,
  		projectName.column,
  		projectState.column,
  		studentId.column,
  		teacherId.column
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
    		return ofNullable(projectId);
    	default:
    		return ofNullable(null);
    }
  }
}
