package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.ClassiEntity;
import com.cx.fluentmybatis.helper.ClassiDefaults;
import com.cx.fluentmybatis.helper.ClassiMapping;
import com.cx.fluentmybatis.helper.ClassiSqlProvider;
import com.cx.fluentmybatis.wrapper.ClassiQuery;
import com.cx.fluentmybatis.wrapper.ClassiUpdate;
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
 * ClassiMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("classiMapper")
public interface ClassiMapper extends IEntityMapper<ClassiEntity>, IRichMapper<ClassiEntity>, IWrapperMapper<ClassiEntity>, IMapper<ClassiEntity> {
  String ResultMap = "ClassiEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = ClassiSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = Integer.class,
      keyProperty = "classId",
      keyColumn = "class_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(ClassiEntity entity);

  @Override
  @InsertProvider(
      type = ClassiSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(ClassiEntity entity);

  @Override
  @InsertProvider(
      type = ClassiSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = Integer.class,
      keyProperty = "classId",
      keyColumn = "class_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<ClassiEntity> entities);

  @Override
  @InsertProvider(
      type = ClassiSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<ClassiEntity> entities);

  /**
   * @see ClassiSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = ClassiSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see ClassiSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see ClassiSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see ClassiSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see ClassiSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see ClassiSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see ClassiSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see ClassiSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see ClassiSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = ClassiSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = ClassiSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) ClassiEntity entity);

  /**
   *  {@link ClassiSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = ClassiSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "class_id", property = "classId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "class_name", property = "className", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "subject_id", property = "subjectId", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  ClassiEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  ClassiEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<ClassiEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<ClassiEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<ClassiEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ClassiSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default ClassiQuery query() {
    return new ClassiQuery();
  }

  default ClassiUpdate updater() {
    return new ClassiUpdate();
  }

  default ClassiQuery defaultQuery() {
    return ClassiDefaults.INSTANCE.defaultQuery();
  }

  default ClassiUpdate defaultUpdater() {
    return ClassiDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return ClassiMapping.classId;
  }

  @Override
  default Class<ClassiEntity> entityClass() {
    return ClassiEntity.class;
  }
}
