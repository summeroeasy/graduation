package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.crud.FormSetter;
import cn.org.atool.fluent.mybatis.functions.FormApply;
import cn.org.atool.fluent.mybatis.model.Form;
import cn.org.atool.fluent.mybatis.model.IFormApply;
import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.helper.SessionListWrapperHelper.ISegment;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * SessionListFormSetter: Form Column Setter
 *
 * @author powered by FluentMybatis
 */
public final class SessionListFormSetter extends FormSetter implements ISegment<IFormApply<SessionListEntity, SessionListFormSetter>> {
  private SessionListFormSetter(FormApply apply) {
    super.formApply = apply;
  }

  @Override
  public Class entityClass() {
    return SessionListEntity.class;
  }

  public static IFormApply<SessionListEntity, SessionListFormSetter> by(Object object, Form form) {
    assertNotNull("object", object);
    Map map = PoJoHelper.toMap(object);
    Function<FormApply, FormSetter> apply = SessionListFormSetter::new;
    return new FormApply<>(apply, map, form);
  }
}
