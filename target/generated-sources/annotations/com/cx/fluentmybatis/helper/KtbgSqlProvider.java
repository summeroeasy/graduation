package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.KtbgMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.KtbgEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * KtbgSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class KtbgSqlProvider extends BaseSqlProvider<KtbgEntity> {
  /**
   * 默认设置器
   */
  private static final KtbgDefaults defaults = KtbgDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(KtbgEntity entity) {
    return entity.getKtbgId() == null;
  }

  @Override
  public boolean primaryNotNull(KtbgEntity entity) {
    return entity.getKtbgId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, KtbgEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, ktbgId, entity.getKtbgId(), null);
    }
    inserts.add(prefix, column1, entity.getColumn1(), "");
    inserts.add(prefix, column2, entity.getColumn2(), "");
    inserts.add(prefix, ktbgStatus, entity.getKtbgStatus(), "");
    inserts.add(prefix, studentId, entity.getStudentId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, KtbgEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", ktbgId, entity.getKtbgId(), null));
    }
    values.add(el("list[" + index + "].", column1, entity.getColumn1(), ""));
    values.add(el("list[" + index + "].", column2, entity.getColumn2(), ""));
    values.add(el("list[" + index + "].", ktbgStatus, entity.getKtbgStatus(), ""));
    values.add(el("list[" + index + "].", studentId, entity.getStudentId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    KtbgEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), column1, entity.getColumn1(), "")
    	.add(this.dbType(), column2, entity.getColumn2(), "")
    	.add(this.dbType(), ktbgStatus, entity.getKtbgStatus(), "")
    	.add(this.dbType(), studentId, entity.getStudentId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(ktbgId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("ktbg_id", "column1", "column2", "ktbg_status", "student_id");
    } else {
    	return Arrays.asList("column1", "column2", "ktbg_status", "student_id");
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
