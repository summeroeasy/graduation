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
 * KtbgMapping: Entity类字段和表结构映射
 *
 * @author powered by FluentMybatis
 */
public interface KtbgMapping extends IMapping {
  KtbgMapping MAPPING = new KtbgMapping(){};

  /**
   * 表名称
   */
  String Table_Name = "ktbg";

  /**
   * Entity名称
   */
  String Entity_Name = "KtbgEntity";

  /**
   * 实体属性 : 数据库字段 映射
   *  ktbgId : ktbg_id
   */
  FieldMapping ktbgId = new FieldMapping("ktbgId", "ktbg_id");

  /**
   * 实体属性 : 数据库字段 映射
   *  column1 : column1
   */
  FieldMapping column1 = new FieldMapping("column1", "column1");

  /**
   * 实体属性 : 数据库字段 映射
   *  column2 : column2
   */
  FieldMapping column2 = new FieldMapping("column2", "column2");

  /**
   * 实体属性 : 数据库字段 映射
   *  ktbgStatus : ktbg_status
   */
  FieldMapping ktbgStatus = new FieldMapping("ktbgStatus", "ktbg_status");

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
  		this.put(ktbgId.name, ktbgId.column);
  		this.put(column1.name, column1.column);
  		this.put(column2.name, column2.column);
  		this.put(ktbgStatus.name, ktbgStatus.column);
  		this.put(studentId.name, studentId.column);
    }
  };

  /**
   * 数据库字段对应的FieldMapping
   */
  Map<String, FieldMapping> Column2Mapping = new HashMap<String, FieldMapping>() {
    {
  		this.put(ktbgId.column, ktbgId);
  		this.put(column1.column, column1);
  		this.put(column2.column, column2);
  		this.put(ktbgStatus.column, ktbgStatus);
  		this.put(studentId.column, studentId);
    }
  };

  /**
   * 数据库所有字段列表
   */
  List<String> ALL_COLUMNS = Arrays.asList(
  		ktbgId.column,
  		column1.column,
  		column2.column,
  		ktbgStatus.column,
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
    		return ofNullable(ktbgId);
    	default:
    		return ofNullable(null);
    }
  }
}
