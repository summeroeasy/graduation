package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.helper.SessionListDefaults;
import com.cx.fluentmybatis.helper.SessionListMapping;
import com.cx.fluentmybatis.helper.SessionListSqlProvider;
import com.cx.fluentmybatis.wrapper.SessionListQuery;
import com.cx.fluentmybatis.wrapper.SessionListUpdate;
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
 * SessionListMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("sessionListMapper")
public interface SessionListMapper extends IEntityMapper<SessionListEntity>, IRichMapper<SessionListEntity>, IWrapperMapper<SessionListEntity>, IMapper<SessionListEntity> {
  String ResultMap = "SessionListEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = SessionListSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "id",
      keyColumn = "id"
  )
  int insert(SessionListEntity entity);

  @Override
  @InsertProvider(
      type = SessionListSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(SessionListEntity entity);

  @Override
  @InsertProvider(
      type = SessionListSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "id",
      keyColumn = "id"
  )
  int insertBatch(@Param(Param_List) Collection<SessionListEntity> entities);

  @Override
  @InsertProvider(
      type = SessionListSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<SessionListEntity> entities);

  /**
   * @see SessionListSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = SessionListSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see SessionListSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see SessionListSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see SessionListSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see SessionListSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see SessionListSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see SessionListSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see SessionListSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see SessionListSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = SessionListSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = SessionListSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) SessionListEntity entity);

  /**
   *  {@link SessionListSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = SessionListSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "id", property = "id", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "list_name", property = "listName", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "to_user_id", property = "toUserId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "un_read_count", property = "unReadCount", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_id", property = "userId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  SessionListEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  SessionListEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<SessionListEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<SessionListEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<SessionListEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = SessionListSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default SessionListQuery query() {
    return new SessionListQuery();
  }

  default SessionListUpdate updater() {
    return new SessionListUpdate();
  }

  default SessionListQuery defaultQuery() {
    return SessionListDefaults.INSTANCE.defaultQuery();
  }

  default SessionListUpdate defaultUpdater() {
    return SessionListDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return SessionListMapping.id;
  }

  @Override
  default Class<SessionListEntity> entityClass() {
    return SessionListEntity.class;
  }
}
