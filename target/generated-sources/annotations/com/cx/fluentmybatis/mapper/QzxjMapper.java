package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.fluentmybatis.helper.QzxjDefaults;
import com.cx.fluentmybatis.helper.QzxjMapping;
import com.cx.fluentmybatis.helper.QzxjSqlProvider;
import com.cx.fluentmybatis.wrapper.QzxjQuery;
import com.cx.fluentmybatis.wrapper.QzxjUpdate;
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
 * QzxjMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("qzxjMapper")
public interface QzxjMapper extends IEntityMapper<QzxjEntity>, IRichMapper<QzxjEntity>, IWrapperMapper<QzxjEntity>, IMapper<QzxjEntity> {
  String ResultMap = "QzxjEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = QzxjSqlProvider.class,
      method = "insert"
  )
  @SelectKey(
      resultType = Integer.class,
      keyProperty = "qzxjId",
      keyColumn = "qzxj_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insert(QzxjEntity entity);

  @Override
  @InsertProvider(
      type = QzxjSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(QzxjEntity entity);

  @Override
  @InsertProvider(
      type = QzxjSqlProvider.class,
      method = "insertBatch"
  )
  @SelectKey(
      resultType = Integer.class,
      keyProperty = "qzxjId",
      keyColumn = "qzxj_id",
      before = false,
      statement = "SELECT LAST_INSERT_ID() AS ID"
  )
  int insertBatch(@Param(Param_List) Collection<QzxjEntity> entities);

  @Override
  @InsertProvider(
      type = QzxjSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<QzxjEntity> entities);

  /**
   * @see QzxjSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = QzxjSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see QzxjSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see QzxjSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see QzxjSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see QzxjSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see QzxjSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see QzxjSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see QzxjSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see QzxjSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = QzxjSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = QzxjSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) QzxjEntity entity);

  /**
   *  {@link QzxjSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = QzxjSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "qzxj_id", property = "qzxjId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "student_id", property = "studentId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  QzxjEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  QzxjEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<QzxjEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<QzxjEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<QzxjEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = QzxjSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default QzxjQuery query() {
    return new QzxjQuery();
  }

  default QzxjUpdate updater() {
    return new QzxjUpdate();
  }

  default QzxjQuery defaultQuery() {
    return QzxjDefaults.INSTANCE.defaultQuery();
  }

  default QzxjUpdate defaultUpdater() {
    return QzxjDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return QzxjMapping.qzxjId;
  }

  @Override
  default Class<QzxjEntity> entityClass() {
    return QzxjEntity.class;
  }
}
