package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.ProjectFromEntity;
import com.cx.fluentmybatis.helper.ProjectFromDefaults;
import com.cx.fluentmybatis.helper.ProjectFromMapping;
import com.cx.fluentmybatis.helper.ProjectFromSqlProvider;
import com.cx.fluentmybatis.wrapper.ProjectFromQuery;
import com.cx.fluentmybatis.wrapper.ProjectFromUpdate;
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
 * ProjectFromMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("projectFromMapper")
public interface ProjectFromMapper extends IEntityMapper<ProjectFromEntity>, IRichMapper<ProjectFromEntity>, IWrapperMapper<ProjectFromEntity>, IMapper<ProjectFromEntity> {
  String ResultMap = "ProjectFromEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = ProjectFromSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "projectFromId",
      keyColumn = "project_from_id"
  )
  int insert(ProjectFromEntity entity);

  @Override
  @InsertProvider(
      type = ProjectFromSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(ProjectFromEntity entity);

  @Override
  @InsertProvider(
      type = ProjectFromSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "projectFromId",
      keyColumn = "project_from_id"
  )
  int insertBatch(@Param(Param_List) Collection<ProjectFromEntity> entities);

  @Override
  @InsertProvider(
      type = ProjectFromSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<ProjectFromEntity> entities);

  /**
   * @see ProjectFromSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = ProjectFromSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see ProjectFromSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see ProjectFromSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see ProjectFromSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see ProjectFromSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see ProjectFromSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see ProjectFromSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see ProjectFromSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see ProjectFromSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectFromSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = ProjectFromSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) ProjectFromEntity entity);

  /**
   *  {@link ProjectFromSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = ProjectFromSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "project_from_id", property = "projectFromId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_from_name", property = "projectFromName", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  ProjectFromEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  ProjectFromEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<ProjectFromEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<ProjectFromEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<ProjectFromEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectFromSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default ProjectFromQuery query() {
    return new ProjectFromQuery();
  }

  default ProjectFromUpdate updater() {
    return new ProjectFromUpdate();
  }

  default ProjectFromQuery defaultQuery() {
    return ProjectFromDefaults.INSTANCE.defaultQuery();
  }

  default ProjectFromUpdate defaultUpdater() {
    return ProjectFromDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return ProjectFromMapping.projectFromId;
  }

  @Override
  default Class<ProjectFromEntity> entityClass() {
    return ProjectFromEntity.class;
  }
}
