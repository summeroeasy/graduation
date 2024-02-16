package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.fluentmybatis.helper.PaperlibDefaults;
import com.cx.fluentmybatis.helper.PaperlibMapping;
import com.cx.fluentmybatis.helper.PaperlibSqlProvider;
import com.cx.fluentmybatis.wrapper.PaperlibQuery;
import com.cx.fluentmybatis.wrapper.PaperlibUpdate;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 *
 * PaperlibMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("paperlibMapper")
public interface PaperlibMapper extends IEntityMapper<PaperlibEntity>, IRichMapper<PaperlibEntity>, IWrapperMapper<PaperlibEntity>, IMapper<PaperlibEntity> {
  String ResultMap = "PaperlibEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = PaperlibSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = Long.class,
      keyProperty = "id",
      keyColumn = "id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(PaperlibEntity entity);

  @Override
  @InsertProvider(
      type = PaperlibSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(PaperlibEntity entity);

  @Override
  @InsertProvider(
      type = PaperlibSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = Long.class,
      keyProperty = "id",
      keyColumn = "id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<PaperlibEntity> entities);

  @Override
  @InsertProvider(
      type = PaperlibSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<PaperlibEntity> entities);

  /**
   * @see PaperlibSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = PaperlibSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see PaperlibSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see PaperlibSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see PaperlibSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see PaperlibSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see PaperlibSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see PaperlibSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see PaperlibSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see PaperlibSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = PaperlibSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = PaperlibSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) PaperlibEntity entity);

  /**
   *  {@link PaperlibSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = PaperlibSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "id", property = "id", javaType = Long.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "file", property = "file", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "info", property = "info", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "name", property = "name", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  PaperlibEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  PaperlibEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<PaperlibEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<PaperlibEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<PaperlibEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = PaperlibSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default PaperlibQuery query() {
    return new PaperlibQuery();
  }

  default PaperlibUpdate updater() {
    return new PaperlibUpdate();
  }

  default PaperlibQuery defaultQuery() {
    return PaperlibDefaults.INSTANCE.defaultQuery();
  }

  default PaperlibUpdate defaultUpdater() {
    return PaperlibDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return PaperlibMapping.id;
  }

  @Override
  default Class<PaperlibEntity> entityClass() {
    return PaperlibEntity.class;
  }
}
