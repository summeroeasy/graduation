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
 * QzxjMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface QzxjMapping extends IMapping {
  QzxjMapping MAPPING = new QzxjMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "qzxj";

  /**
   * Entity名称
   */
  String Entity_Name = "QzxjEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  qzxjId : qzxj_id
   */
  FieldMapping qzxjId = new FieldMapping("qzxjId", "qzxj_id");

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
  		this.put(qzxjId.name, qzxjId.column);
  		this.put(studentId.name, studentId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(qzxjId.column, qzxjId);
  		this.put(studentId.column, studentId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		qzxjId.column,
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
    		return ofNullable(qzxjId);
    	default:
    		return ofNullable(null);
    }
  }
}
