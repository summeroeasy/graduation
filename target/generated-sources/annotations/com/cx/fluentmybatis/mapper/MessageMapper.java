package com.cx.fluentmybatis.mapper;

import static cn.org.atool.fluent.mybatis.mapper.FluentConst.*;

import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
import cn.org.atool.fluent.mybatis.base.mapper.IEntityMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.base.mapper.IWrapperMapper;
import cn.org.atool.fluent.mybatis.base.model.FieldMapping;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.helper.MessageDefaults;
import com.cx.fluentmybatis.helper.MessageMapping;
import com.cx.fluentmybatis.helper.MessageSqlProvider;
import com.cx.fluentmybatis.wrapper.MessageQuery;
import com.cx.fluentmybatis.wrapper.MessageUpdate;
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
 * MessageMapper: Mapper接口
 *
 * @author powered by FluentMybatis
 */
@Mapper
@Component("messageMapper")
public interface MessageMapper extends IEntityMapper<MessageEntity>, IRichMapper<MessageEntity>, IWrapperMapper<MessageEntity>, IMapper<MessageEntity> {
  String ResultMap = "MessageEntityResultMap";

  /**
   * {@link cn.org.atool.fluent.mybatis.base.crud.BaseSqlProvider#insert(cn.org.atool.fluent.mybatis.base.IEntity)}
   */
  @Override
  @InsertProvider(
      type = MessageSqlProvider.class,
      method = "insert"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "messageId",
      keyColumn = "message_id"
  )
  int insert(MessageEntity entity);

  @Override
  @InsertProvider(
      type = MessageSqlProvider.class,
      method = "insertWithPk"
  )
  int insertWithPk(MessageEntity entity);

  @Override
  @InsertProvider(
      type = MessageSqlProvider.class,
      method = "insertBatch"
  )
  @Options(
      useGeneratedKeys = true,
      keyProperty = "messageId",
      keyColumn = "message_id"
  )
  int insertBatch(@Param(Param_List) Collection<MessageEntity> entities);

  @Override
  @InsertProvider(
      type = MessageSqlProvider.class,
      method = "insertBatchWithPk"
  )
  int insertBatchWithPk(@Param(Param_List) Collection<MessageEntity> entities);

  /**
   * @see MessageSqlProvider#insertSelect(Map)
   */
  @Override
  @InsertProvider(
      type = MessageSqlProvider.class,
      method = "insertSelect"
  )
  int insertSelect(@Param(Param_Fields) String[] fields, @Param(Param_EW) IQuery ew);

  /**
   * @see MessageSqlProvider#deleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "deleteById"
  )
  int deleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see MessageSqlProvider#logicDeleteById(Serializable[])
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "logicDeleteById"
  )
  int logicDeleteById(@Param(Param_List) Serializable... ids);

  /**
   * @see MessageSqlProvider#deleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "deleteByIds"
  )
  int deleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see MessageSqlProvider#logicDeleteByIds(Map)
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "logicDeleteByIds"
  )
  int logicDeleteByIds(@Param(Param_List) Collection<? extends Serializable> idList);

  /**
   * @see MessageSqlProvider#deleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "deleteByMap"
  )
  int deleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see MessageSqlProvider#logicDeleteByMap(Map)
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "logicDeleteByMap"
  )
  int logicDeleteByMap(@Param(Param_CM) Map<String, Object> cm);

  /**
   * @see MessageSqlProvider#delete(Map)
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "delete"
  )
  int delete(@Param(Param_EW) IQuery wrapper);

  /**
   * @see MessageSqlProvider#logicDelete(Map)
   */
  @Override
  @DeleteProvider(
      type = MessageSqlProvider.class,
      method = "logicDelete"
  )
  int logicDelete(@Param(Param_EW) IQuery wrapper);

  @Override
  @UpdateProvider(
      type = MessageSqlProvider.class,
      method = "updateById"
  )
  int updateById(@Param(Param_ET) MessageEntity entity);

  /**
   *  {@link MessageSqlProvider#updateBy(Map)}
   */
  @Override
  @UpdateProvider(
      type = MessageSqlProvider.class,
      method = "updateBy"
  )
  int updateBy(@Param(Param_EW) IUpdate... updates);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "findById"
  )
  @Results(
      id = ResultMap,
      value = {
          @Result(column = "message_id", property = "messageId", javaType = Integer.class, id = true, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "create_date", property = "createDate", javaType = Date.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "message_body", property = "messageBody", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "message_type", property = "messageType", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "state", property = "state", javaType = Integer.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "to_user_id", property = "toUserId", javaType = String.class, jdbcType = JdbcType.UNDEFINED),
          @Result(column = "user_id", property = "userId", javaType = String.class, jdbcType = JdbcType.UNDEFINED)
          }
  )
  MessageEntity findById(Serializable id);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "findOne"
  )
  @ResultMap(ResultMap)
  MessageEntity findOne(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "listByIds"
  )
  @ResultMap(ResultMap)
  List<MessageEntity> listByIds(@Param(Param_List) Collection ids);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "listByMap"
  )
  @ResultMap(ResultMap)
  List<MessageEntity> listByMap(@Param(Param_CM) Map<String, Object> columnMap);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "listEntity"
  )
  @ResultMap(ResultMap)
  List<MessageEntity> listEntity(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "listMaps"
  )
  @ResultType(Map.class)
  List<Map<String, Object>> listMaps(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "listObjs"
  )
  <O> List<O> listObjs(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "count"
  )
  Integer count(@Param(Param_EW) IQuery query);

  @Override
  @SelectProvider(
      type = MessageSqlProvider.class,
      method = "countNoLimit"
  )
  Integer countNoLimit(@Param(Param_EW) IQuery query);

  default MessageQuery query() {
    return new MessageQuery();
  }

  default MessageUpdate updater() {
    return new MessageUpdate();
  }

  default MessageQuery defaultQuery() {
    return MessageDefaults.INSTANCE.defaultQuery();
  }

  default MessageUpdate defaultUpdater() {
    return MessageDefaults.INSTANCE.defaultUpdater();
  }

  @Override
  default FieldMapping primaryField() {
    return MessageMapping.messageId;
  }

  @Override
  default Class<MessageEntity> entityClass() {
    return MessageEntity.class;
  }
}
