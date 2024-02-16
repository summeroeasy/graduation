package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.fluentmybatis.helper.PaperlibDefaults;
import com.cx.fluentmybatis.helper.PaperlibMapping;
import com.cx.fluentmybatis.helper.PaperlibWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.PaperlibWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.PaperlibWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * PaperlibUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class PaperlibUpdate extends BaseUpdate<PaperlibEntity, PaperlibUpdate, PaperlibQuery> {
  /**
   * 默认设置器
   */
  private static final PaperlibDefaults defaults = PaperlibDefaults.INSTANCE;

  /**
   * same as {@link #update}
   */
  public final UpdateSetter set = new UpdateSetter(this);

  /**
   * replaced by {@link #set}
   */
  @Deprecated
  public final UpdateSetter update = set;

  public final UpdateWhere where = new UpdateWhere(this);

  public final UpdateOrderBy orderBy = new UpdateOrderBy(this);

  public PaperlibUpdate() {
    this(defaults.table(), null);
  }

  public PaperlibUpdate(Supplier<String> table, String alias) {
    super(table, alias, PaperlibEntity.class, PaperlibQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return PaperlibMapping.MAPPING;
  }

  protected List<String> allFields() {
    return PaperlibMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static PaperlibUpdate updater() {
    return new PaperlibUpdate();
  }

  public static PaperlibUpdate updater(Supplier<String> table) {
    return new PaperlibUpdate(table, null);
  }

  public static PaperlibUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return PaperlibMapping.Column2Mapping;
  }
}
