package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.fluentmybatis.helper.KtbgDefaults;
import com.cx.fluentmybatis.helper.KtbgMapping;
import com.cx.fluentmybatis.helper.KtbgSqlProvider;
import com.cx.fluentmybatis.wrapper.KtbgQuery;
import com.cx.fluentmybatis.wrapper.KtbgUpdate;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 *
 * KtbgMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("ktbgMapper")
public interface KtbgMapper extends IEntityMapper<KtbgEntity>, IRichMapper<KtbgEntity>, IWrapperMapper<KtbgEntity>, IMapper<KtbgEntity> {
  String ResultMap = "KtbgEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = KtbgSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "ktbgId",
      keyColumn = "ktbg_id"
  )
  int insert(KtbgEntity entity);

  @Override
  @InsertProvider(
      type = KtbgSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(KtbgEntity entity);

  @Override
  @InsertProvider(
      type = KtbgSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "ktbgId",
      keyColumn = "ktbg_id"
  )
  int insertBatch(@Param(Param_List) Collection<KtbgEntity> entities);

  @Override
  @InsertProvider(
      type = KtbgSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<KtbgEntity> entities);

  /**
   * @see KtbgSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = KtbgSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see KtbgSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see KtbgSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see KtbgSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see KtbgSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see KtbgSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see KtbgSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see KtbgSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see KtbgSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = KtbgSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = KtbgSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) KtbgEntity entity);

  /**
   *  {@link KtbgSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = KtbgSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "ktbg_id", property = "ktbgId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "column1", property = "column1", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "column2", property = "column2", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "ktbg_status", property = "ktbgStatus", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "student_id", property = "studentId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  KtbgEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  KtbgEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<KtbgEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<KtbgEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<KtbgEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = KtbgSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default KtbgQuery query() {
    return new KtbgQuery();
  }

  default KtbgUpdate updater() {
    return new KtbgUpdate();
  }

  default KtbgQuery defaultQuery() {
    return KtbgDefaults.INSTANCE.defaultQuery();
  }

  default KtbgUpdate defaultUpdater() {
    return KtbgDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return KtbgMapping.ktbgId;
  }

  @Override
  default Class<KtbgEntity> entityClass() {
    return KtbgEntity.class;
  }
}
