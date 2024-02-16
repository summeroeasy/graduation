package com.cx.fluentmybatis.wrapper;

import static cn.org.atool.fluent.mybatis.If.notBlank;

import cn.org.atool.fluent.mybatis.base.crud.BaseUpdate;
import cn.org.atool.fluent.mybatis.base.entity.IMapping;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import cn.org.atool.fluent.mybatis.metadata.DbType;
import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.fluentmybatis.helper.KtbgDefaults;
import com.cx.fluentmybatis.helper.KtbgMapping;
import com.cx.fluentmybatis.helper.KtbgWrapperHelper.UpdateOrderBy;
import com.cx.fluentmybatis.helper.KtbgWrapperHelper.UpdateSetter;
import com.cx.fluentmybatis.helper.KtbgWrapperHelper.UpdateWhere;
import java.lang.Deprecated;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * KtbgUpdate: 更新构造
 *
 * @author powered by FluentMybatis
 */
public class KtbgUpdate extends BaseUpdate<KtbgEntity, KtbgUpdate, KtbgQuery> {
  /**
   * 默认设置器
   */
  private static final KtbgDefaults defaults = KtbgDefaults.INSTANCE;

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

  public KtbgUpdate() {
    this(defaults.table(), null);
  }

  public KtbgUpdate(Supplier<String> table, String alias) {
    super(table, alias, KtbgEntity.class, KtbgQuery.class);
  }

  @Override
  public UpdateWhere where() {
    return this.where;
  }

  @Override
  protected IMapping mapping() {
    return KtbgMapping.MAPPING;
  }

  protected List<String> allFields() {
    return KtbgMapping.ALL_COLUMNS;
  }

  @Override
  public DbType dbType() {
    return DbType.MYSQL;
  }

  public static KtbgUpdate updater() {
    return new KtbgUpdate();
  }

  public static KtbgUpdate updater(Supplier<String> table) {
    return new KtbgUpdate(table, null);
  }

  public static KtbgUpdate defaultUpdater() {
    return defaults.defaultUpdater();
  }

  @Override
  protected Map<String, FieldMapping> column2mapping() {
    return KtbgMapping.Column2Mapping;
  }
}
