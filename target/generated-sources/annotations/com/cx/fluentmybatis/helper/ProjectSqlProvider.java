package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.ProjectMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.ProjectEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * ProjectSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class ProjectSqlProvider extends BaseSqlProvider<ProjectEntity> {
  /**
   * 默认设置器
   */
  private static final ProjectDefaults defaults = ProjectDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(ProjectEntity entity) {
    return entity.getProjectId() == null;
  }

  @Override
  public boolean primaryNotNull(ProjectEntity entity) {
    return entity.getProjectId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, ProjectEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, projectId, entity.getProjectId(), null);
    }
    inserts.add(prefix, projectDescribe, entity.getProjectDescribe(), "");
    inserts.add(prefix, projectFromId, entity.getProjectFromId(), "");
    inserts.add(prefix, projectName, entity.getProjectName(), "");
    inserts.add(prefix, projectState, entity.getProjectState(), "");
    inserts.add(prefix, studentId, entity.getStudentId(), "");
    inserts.add(prefix, teacherId, entity.getTeacherId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, ProjectEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", projectId, entity.getProjectId(), null));
    }
    values.add(el("list[" + index + "].", projectDescribe, entity.getProjectDescribe(), ""));
    values.add(el("list[" + index + "].", projectFromId, entity.getProjectFromId(), ""));
    values.add(el("list[" + index + "].", projectName, entity.getProjectName(), ""));
    values.add(el("list[" + index + "].", projectState, entity.getProjectState(), ""));
    values.add(el("list[" + index + "].", studentId, entity.getStudentId(), ""));
    values.add(el("list[" + index + "].", teacherId, entity.getTeacherId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    ProjectEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), projectDescribe, entity.getProjectDescribe(), "")
    	.add(this.dbType(), projectFromId, entity.getProjectFromId(), "")
    	.add(this.dbType(), projectName, entity.getProjectName(), "")
    	.add(this.dbType(), projectState, entity.getProjectState(), "")
    	.add(this.dbType(), studentId, entity.getStudentId(), "")
    	.add(this.dbType(), teacherId, entity.getTeacherId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(projectId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("project_id", "project_describe", "project_from_id", "project_name", "project_state", "student_id", "teacher_id");
    } else {
    	return Arrays.asList("project_describe", "project_from_id", "project_name", "project_state", "student_id", "teacher_id");
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
