package com.cx.fluentmybatis.dao.base;

import static com.cx.fluentmybatis.helper.MessageDefaults.INSTANCE;

import cn.org.atool.fluent.mybatis.base.dao.BaseDao;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.mapper.MessageMapper;
import com.cx.fluentmybatis.wrapper.MessageQuery;
import com.cx.fluentmybatis.wrapper.MessageUpdate;
import java.lang.Override;
import javax.annotation.Resource;

/**
 *
 * MessageBaseDao
 *
 * @author powered by FluentMybatis
 */
public abstract class MessageBaseDao extends BaseDao<MessageEntity> {
  @Resource(
      name = "messageMapper"
  )
  protected MessageMapper mapper;

  @Override
  public MessageMapper mapper() {
    return mapper;
  }

  @Override
  protected MessageQuery query() {
    return new MessageQuery();
  }

  @Override
  protected MessageQuery defaultQuery() {
    return INSTANCE.defaultQuery();
  }

  @Override
  protected MessageUpdate updater() {
    return new MessageUpdate();
  }

  @Override
  protected MessageUpdate defaultUpdater() {
    return INSTANCE.defaultUpdater();
  }
}
