package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.helper.ProjectDefaults;
import com.cx.fluentmybatis.helper.ProjectMapping;
import com.cx.fluentmybatis.helper.ProjectSqlProvider;
import com.cx.fluentmybatis.wrapper.ProjectQuery;
import com.cx.fluentmybatis.wrapper.ProjectUpdate;
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
 * ProjectMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("projectMapper")
public interface ProjectMapper extends IEntityMapper<ProjectEntity>, IRichMapper<ProjectEntity>, IWrapperMapper<ProjectEntity>, IMapper<ProjectEntity> {
  String ResultMap = "ProjectEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = ProjectSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "projectId",
      keyColumn = "project_id"
  )
  int insert(ProjectEntity entity);

  @Override
  @InsertProvider(
      type = ProjectSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(ProjectEntity entity);

  @Override
  @InsertProvider(
      type = ProjectSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "projectId",
      keyColumn = "project_id"
  )
  int insertBatch(@Param(Param_List) Collection<ProjectEntity> entities);

  @Override
  @InsertProvider(
      type = ProjectSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<ProjectEntity> entities);

  /**
   * @see ProjectSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = ProjectSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see ProjectSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see ProjectSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see ProjectSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see ProjectSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see ProjectSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see ProjectSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see ProjectSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see ProjectSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = ProjectSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = ProjectSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) ProjectEntity entity);

  /**
   *  {@link ProjectSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = ProjectSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "project_id", property = "projectId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_describe", property = "projectDescribe", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_from_id", property = "projectFromId", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_name", property = "projectName", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "project_state", property = "projectState", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "student_id", property = "studentId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "teacher_id", property = "teacherId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  ProjectEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  ProjectEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<ProjectEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<ProjectEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<ProjectEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = ProjectSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default ProjectQuery query() {
    return new ProjectQuery();
  }

  default ProjectUpdate updater() {
    return new ProjectUpdate();
  }

  default ProjectQuery defaultQuery() {
    return ProjectDefaults.INSTANCE.defaultQuery();
  }

  default ProjectUpdate defaultUpdater() {
    return ProjectDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return ProjectMapping.projectId;
  }

  @Override
  default Class<ProjectEntity> entityClass() {
    return ProjectEntity.class;
  }
}
