package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.ClassiMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.ClassiEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * ClassiSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class ClassiSqlProvider extends BaseSqlProvider<ClassiEntity> {
  /**
   * 默认设置器
   */
  private static final ClassiDefaults defaults = ClassiDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(ClassiEntity entity) {
    return entity.getClassId() == null;
  }

  @Override
  public boolean primaryNotNull(ClassiEntity entity) {
    return entity.getClassId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, ClassiEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, classId, entity.getClassId(), null);
    }
    inserts.add(prefix, className, entity.getClassName(), "");
    inserts.add(prefix, subjectId, entity.getSubjectId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, ClassiEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", classId, entity.getClassId(), null));
    }
    values.add(el("list[" + index + "].", className, entity.getClassName(), ""));
    values.add(el("list[" + index + "].", subjectId, entity.getSubjectId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    ClassiEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), className, entity.getClassName(), "")
    	.add(this.dbType(), subjectId, entity.getSubjectId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(classId.el(this.dbType(), Param_ET));
    return sql.toString();
  }

  @Override
  public List<String> updateDefaults(Map<String, String> updates, boolean ignoreLockVersion) {
    UpdateDefault defaults = new UpdateDefault(updates);
    return defaults.getUpdateDefaults();
  }

  @Override
  public String tableName() {
    return defaults.table().get();
  }

  @Override
  protected IMapping mapping() {
    return MAPPING;
  }

  @Override
  public List<String> allFields(boolean withPk) {
    if (withPk) {
    	return Arrays.asList("class_id", "class_name", "subject_id");
    } else {
    	return Arrays.asList("class_name", "subject_id");
    }
  }

  @Override
  protected void setEntityByDefault(IEntity entity) {
    defaults.setEntityByDefault(entity);
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  @Override
  protected boolean longTypeOfLogicDelete() {
    return false;
  }
}
