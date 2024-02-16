package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.PaperlibMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * PaperlibSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class PaperlibSqlProvider extends BaseSqlProvider<PaperlibEntity> {
  /**
   * 默认设置器
   */
  private static final PaperlibDefaults defaults = PaperlibDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(PaperlibEntity entity) {
    return entity.getId() == null;
  }

  @Override
  public boolean primaryNotNull(PaperlibEntity entity) {
    return entity.getId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, PaperlibEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, id, entity.getId(), null);
    }
    inserts.add(prefix, file, entity.getFile(), "");
    inserts.add(prefix, info, entity.getInfo(), "");
    inserts.add(prefix, name, entity.getName(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, PaperlibEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", id, entity.getId(), null));
    }
    values.add(el("list[" + index + "].", file, entity.getFile(), ""));
    values.add(el("list[" + index + "].", info, entity.getInfo(), ""));
    values.add(el("list[" + index + "].", name, entity.getName(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    PaperlibEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), file, entity.getFile(), "")
    	.add(this.dbType(), info, entity.getInfo(), "")
    	.add(this.dbType(), name, entity.getName(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(id.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("id", "file", "info", "name");
    } else {
    	return Arrays.asList("file", "info", "name");
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
