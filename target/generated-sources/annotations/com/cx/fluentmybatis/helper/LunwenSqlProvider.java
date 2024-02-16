package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.base.model.InsertList.el;
import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;
import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.*;
import static cn.org.atool.fluent.mybatis.utility.SqlProviderUtils.*;
import static com.cx.fluentmybatis.helper.LunwenMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.InsertList;
import cn.org.atool.fluent.mybatis.base.model.UpdateDefault;
import cn.org.atool.fluent.mybatis.base.model.UpdateSet;
import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.LunwenEntity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * LunwenSqlProvider: 动态语句封装
 *
 * @author powered by FluentMybatis
 */
public class LunwenSqlProvider extends BaseSqlProvider<LunwenEntity> {
  /**
   * 默认设置器
   */
  private static final LunwenDefaults defaults = LunwenDefaults.INSTANCE;

  @Override
  public boolean primaryIsNull(LunwenEntity entity) {
    return entity.getLunwenId() == null;
  }

  @Override
  public boolean primaryNotNull(LunwenEntity entity) {
    return entity.getLunwenId() != null;
  }

  @Override
  protected void insertEntity(InsertList inserts, String prefix, LunwenEntity entity,
      boolean withPk) {
    if (withPk) {
    	inserts.add(prefix, lunwenId, entity.getLunwenId(), null);
    }
    inserts.add(prefix, lunwenDate, entity.getLunwenDate(), "");
    inserts.add(prefix, lunwenName, entity.getLunwenName(), "");
    inserts.add(prefix, lunwenPath, entity.getLunwenPath(), "");
    inserts.add(prefix, lunwenStatus, entity.getLunwenStatus(), "");
    inserts.add(prefix, studentId, entity.getStudentId(), "");
  }

  @Override
  protected List<String> insertBatchEntity(int index, LunwenEntity entity, boolean withPk) {
    List<String> values = new ArrayList<>();
    if (withPk) {
    	values.add(el("list[" + index + "].", lunwenId, entity.getLunwenId(), null));
    }
    values.add(el("list[" + index + "].", lunwenDate, entity.getLunwenDate(), ""));
    values.add(el("list[" + index + "].", lunwenName, entity.getLunwenName(), ""));
    values.add(el("list[" + index + "].", lunwenPath, entity.getLunwenPath(), ""));
    values.add(el("list[" + index + "].", lunwenStatus, entity.getLunwenStatus(), ""));
    values.add(el("list[" + index + "].", studentId, entity.getStudentId(), ""));
    return values;
  }

  public String updateById(Map<String, Object> map) {
    LunwenEntity entity = getParas(map, Param_ET);
    assertNotNull(Param_Entity, entity);
    MapperSql sql = new MapperSql();
    sql.UPDATE(this.tableName());
    UpdateSet updates = new UpdateSet()
    	.add(this.dbType(), lunwenDate, entity.getLunwenDate(), "")
    	.add(this.dbType(), lunwenName, entity.getLunwenName(), "")
    	.add(this.dbType(), lunwenPath, entity.getLunwenPath(), "")
    	.add(this.dbType(), lunwenStatus, entity.getLunwenStatus(), "")
    	.add(this.dbType(), studentId, entity.getStudentId(), "");
    sql.SET(updates.getUpdates());
    sql.WHERE(lunwenId.el(this.dbType(), Param_ET));
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
    	return Arrays.asList("lunwen_id", "lunwen_date", "lunwen_name", "lunwen_path", "lunwen_status", "student_id");
    } else {
    	return Arrays.asList("lunwen_date", "lunwen_name", "lunwen_path", "lunwen_status", "student_id");
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
