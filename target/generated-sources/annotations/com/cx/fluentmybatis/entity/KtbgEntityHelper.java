package com.cx.fluentmybatis.entity;

import static com.cx.fluentmybatis.helper.KtbgMapping.*;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.entity.IEntityHelper;
import cn.org.atool.fluent.mybatis.base.model.EntityToMap;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 *
 * KtbgEntityHelper: Entity帮助类
 *
 * @author powered by FluentMybatis
 */
public class KtbgEntityHelper implements IEntityHelper {
  @Override
  public Map<String, Object> toColumnMap(IEntity entity, boolean isNoN) {
    return this.toMap((KtbgEntity)entity, false, isNoN);
  }

  @Override
  public Map<String, Object> toEntityMap(IEntity entity, boolean isNoN) {
    return this.toMap((KtbgEntity)entity, true, isNoN);
  }

  public Map<String, Object> toMap(KtbgEntity entity, boolean isProperty, boolean isNoN) {
    return new EntityToMap(isProperty)
    	.put(ktbgId, entity.getKtbgId(), isNoN)
    	.put(column1, entity.getColumn1(), isNoN)
    	.put(column2, entity.getColumn2(), isNoN)
    	.put(ktbgStatus, entity.getKtbgStatus(), isNoN)
    	.put(studentId, entity.getStudentId(), isNoN)
    	.getMap();
  }

  @Override
  public <E extends IEntity> E toEntity(Map<String, Object> map) {
    KtbgEntity entity = new KtbgEntity();
    if (map.containsKey(ktbgId.name)) {
    	entity.setKtbgId((Integer) map.get(ktbgId.name));
    }
    if (map.containsKey(column1.name)) {
    	entity.setColumn1((String) map.get(column1.name));
    }
    if (map.containsKey(column2.name)) {
    	entity.setColumn2((String) map.get(column2.name));
    }
    if (map.containsKey(ktbgStatus.name)) {
    	entity.setKtbgStatus((Integer) map.get(ktbgStatus.name));
    }
    if (map.containsKey(studentId.name)) {
    	entity.setStudentId((String) map.get(studentId.name));
    }
    return (E)entity;
  }

  @Override
  public KtbgEntity copy(IEntity iEntity) {
    KtbgEntity entity = (KtbgEntity) iEntity;
    KtbgEntity copy = new KtbgEntity();
    {
    	copy.setKtbgId(entity.getKtbgId());
    	copy.setColumn1(entity.getColumn1());
    	copy.setColumn2(entity.getColumn2());
    	copy.setKtbgStatus(entity.getKtbgStatus());
    	copy.setStudentId(entity.getStudentId());
    }
    return copy;
  }
}
