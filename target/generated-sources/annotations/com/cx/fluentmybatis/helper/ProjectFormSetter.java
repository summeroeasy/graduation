package com.cx.fluentmybatis.helper;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.assertNotNull;

import cn.org.atool.fluent.mybatis.base.crud.FormSetter;
import cn.org.atool.fluent.mybatis.functions.FormApply;
import cn.org.atool.fluent.mybatis.model.Form;
import cn.org.atool.fluent.mybatis.model.IFormApply;
import cn.org.atool.fluent.mybatis.utility.PoJoHelper;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.helper.ProjectWrapperHelper.ISegment;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * ProjectFormSetter: Form Column Setter
 *
 * @author powered by FluentMybatis
 */
public final class ProjectFormSetter extends FormSetter implements ISegment<IFormApply<ProjectEntity, ProjectFormSetter>> {
  private ProjectFormSetter(FormApply apply) {
    super.formApply = apply;
  }

  @Override
  public Class entityClass() {
    return ProjectEntity.class;
  }

  public static IFormApply<ProjectEntity, ProjectFormSetter> by(Object object, Form form) {
    assertNotNull("object", object);
    Map map = PoJoHelper.toMap(object);
    Function<FormApply, FormSetter> apply = ProjectFormSetter::new;
    return new FormApply<>(apply, map, form);
  }
}
