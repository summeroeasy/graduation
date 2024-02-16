package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.fluentmybatis.helper.LunwenDefaults;
import com.cx.fluentmybatis.helper.LunwenMapping;
import com.cx.fluentmybatis.helper.LunwenWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.LunwenWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.LunwenWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * LunwenUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class LunwenUpdate extends BaseUpdate<LunwenEntity, LunwenUpdate, LunwenQuery> {
  /**
   * 默认设置器
   */
  private static final LunwenDefaults defaults = LunwenDefaults.INSTANCE;

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

  public LunwenUpdate() {
    this(defaults.table(), null);
  }

  public LunwenUpdate(Supplier<String> table, String alias) {
    super(table, alias, LunwenEntity.class, LunwenQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return LunwenMapping.MAPPING;
  }

  protected List<String> allFields() {
    return LunwenMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static LunwenUpdate updater() {
    return new LunwenUpdate();
  }

  public static LunwenUpdate updater(Supplier<String> table) {
    return new LunwenUpdate(table, null);
  }

  public static LunwenUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return LunwenMapping.Column2Mapping;
  }
}
