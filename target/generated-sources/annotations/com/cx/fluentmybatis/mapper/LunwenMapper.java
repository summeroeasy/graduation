package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.fluentmybatis.helper.LunwenDefaults;
import com.cx.fluentmybatis.helper.LunwenMapping;
import com.cx.fluentmybatis.helper.LunwenSqlProvider;
import com.cx.fluentmybatis.wrapper.LunwenQuery;
import com.cx.fluentmybatis.wrapper.LunwenUpdate;
import java.io.Serializable;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
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
 * LunwenMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("lunwenMapper")
public interface LunwenMapper extends IEntityMapper<LunwenEntity>, IRichMapper<LunwenEntity>, IWrapperMapper<LunwenEntity>, IMapper<LunwenEntity> {
  String ResultMap = "LunwenEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = LunwenSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "lunwenId",
      keyColumn = "lunwen_id"
  )
  int insert(LunwenEntity entity);

  @Override
  @InsertProvider(
      type = LunwenSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(LunwenEntity entity);

  @Override
  @InsertProvider(
      type = LunwenSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "lunwenId",
      keyColumn = "lunwen_id"
  )
  int insertBatch(@Param(Param_List) Collection<LunwenEntity> entities);

  @Override
  @InsertProvider(
      type = LunwenSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<LunwenEntity> entities);

  /**
   * @see LunwenSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = LunwenSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see LunwenSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see LunwenSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see LunwenSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see LunwenSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see LunwenSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see LunwenSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see LunwenSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see LunwenSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = LunwenSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = LunwenSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) LunwenEntity entity);

  /**
   *  {@link LunwenSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = LunwenSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "lunwen_id", property = "lunwenId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "lunwen_date", property = "lunwenDate", javaType = Date.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "lunwen_name", property = "lunwenName", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "lunwen_path", property = "lunwenPath", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "lunwen_status", property = "lunwenStatus", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "student_id", property = "studentId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  LunwenEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  LunwenEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<LunwenEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<LunwenEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<LunwenEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = LunwenSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default LunwenQuery query() {
    return new LunwenQuery();
  }

  default LunwenUpdate updater() {
    return new LunwenUpdate();
  }

  default LunwenQuery defaultQuery() {
    return LunwenDefaults.INSTANCE.defaultQuery();
  }

  default LunwenUpdate defaultUpdater() {
    return LunwenDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return LunwenMapping.lunwenId;
  }

  @Override
  default Class<LunwenEntity> entityClass() {
    return LunwenEntity.class;
  }
}
