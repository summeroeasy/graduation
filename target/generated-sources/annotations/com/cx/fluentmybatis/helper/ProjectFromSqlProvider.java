package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.ProjectFromMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.ProjectFromEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * ProjectFromSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class ProjectFromSqlProvider extends BaseSqlProvider<ProjectFromEntity> {
  /**
   * 默认设置器
   */
  private static final ProjectFromDefaults defaults = ProjectFromDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(ProjectFromEntity entity) {
    return entity.getProjectFromId() == null;
  }

  @Override
  public boolean primaryNotNull(ProjectFromEntity entity) {
    return entity.getProjectFromId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, ProjectFromEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, projectFromId, entity.getProjectFromId(), null);
    }
    inserts.add(prefix, projectFromName, entity.getProjectFromName(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, ProjectFromEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", projectFromId, entity.getProjectFromId(), null));
    }
    values.add(el("list[" + index + "].", projectFromName, entity.getProjectFromName(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    ProjectFromEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), projectFromName, entity.getProjectFromName(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(projectFromId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("project_from_id", "project_from_name");
    } else {
    	return Arrays.asList("project_from_name");
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
