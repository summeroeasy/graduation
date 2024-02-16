package cn.org.atool.fluent.mybatis.refs;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.notFluentMybatisException;

import cn.org.atool.fluent.mybatis.functions.FormFunction;
import com.cx.fluentmybatis.entity.AdminEntity;
import com.cx.fluentmybatis.entity.ClassiEntity;
import com.cx.fluentmybatis.entity.DeptEntity;
import com.cx.fluentmybatis.entity.DownEntity;
import com.cx.fluentmybatis.entity.InformEntity;
import com.cx.fluentmybatis.entity.KtbgEntity;
import com.cx.fluentmybatis.entity.LunwenEntity;
import com.cx.fluentmybatis.entity.MessageEntity;
import com.cx.fluentmybatis.entity.PaperlibEntity;
import com.cx.fluentmybatis.entity.ProjectEntity;
import com.cx.fluentmybatis.entity.ProjectFromEntity;
import com.cx.fluentmybatis.entity.QzxjEntity;
import com.cx.fluentmybatis.entity.RolesEntity;
import com.cx.fluentmybatis.entity.SessionListEntity;
import com.cx.fluentmybatis.entity.StudentEntity;
import com.cx.fluentmybatis.entity.TeacherEntity;
import com.cx.fluentmybatis.entity.UserEntity;
import com.cx.fluentmybatis.helper.AdminFormSetter;
import com.cx.fluentmybatis.helper.ClassiFormSetter;
import com.cx.fluentmybatis.helper.DeptFormSetter;
import com.cx.fluentmybatis.helper.DownFormSetter;
import com.cx.fluentmybatis.helper.InformFormSetter;
import com.cx.fluentmybatis.helper.KtbgFormSetter;
import com.cx.fluentmybatis.helper.LunwenFormSetter;
import com.cx.fluentmybatis.helper.MessageFormSetter;
import com.cx.fluentmybatis.helper.PaperlibFormSetter;
import com.cx.fluentmybatis.helper.ProjectFormSetter;
import com.cx.fluentmybatis.helper.ProjectFromFormSetter;
import com.cx.fluentmybatis.helper.QzxjFormSetter;
import com.cx.fluentmybatis.helper.RolesFormSetter;
import com.cx.fluentmybatis.helper.SessionListFormSetter;
import com.cx.fluentmybatis.helper.StudentFormSetter;
import com.cx.fluentmybatis.helper.TeacherFormSetter;
import com.cx.fluentmybatis.helper.UserFormSetter;

/**
 *
 * FormRef: 所有Entity Form Setter引用
 *
 * @author powered by FluentMybatis
 */
public interface FormRef {
  FormFunction<AdminEntity, AdminFormSetter> admin = (obj, form) -> AdminFormSetter.by(obj, form);

  FormFunction<ClassiEntity, ClassiFormSetter> classi = (obj, form) -> ClassiFormSetter.by(obj, form);

  FormFunction<DeptEntity, DeptFormSetter> dept = (obj, form) -> DeptFormSetter.by(obj, form);

  FormFunction<DownEntity, DownFormSetter> down = (obj, form) -> DownFormSetter.by(obj, form);

  FormFunction<InformEntity, InformFormSetter> inform = (obj, form) -> InformFormSetter.by(obj, form);

  FormFunction<KtbgEntity, KtbgFormSetter> ktbg = (obj, form) -> KtbgFormSetter.by(obj, form);

  FormFunction<LunwenEntity, LunwenFormSetter> lunwen = (obj, form) -> LunwenFormSetter.by(obj, form);

  FormFunction<MessageEntity, MessageFormSetter> message = (obj, form) -> MessageFormSetter.by(obj, form);

  FormFunction<PaperlibEntity, PaperlibFormSetter> paperlib = (obj, form) -> PaperlibFormSetter.by(obj, form);

  FormFunction<ProjectEntity, ProjectFormSetter> project = (obj, form) -> ProjectFormSetter.by(obj, form);

  FormFunction<ProjectFromEntity, ProjectFromFormSetter> projectFrom = (obj, form) -> ProjectFromFormSetter.by(obj, form);

  FormFunction<QzxjEntity, QzxjFormSetter> qzxj = (obj, form) -> QzxjFormSetter.by(obj, form);

  FormFunction<RolesEntity, RolesFormSetter> roles = (obj, form) -> RolesFormSetter.by(obj, form);

  FormFunction<SessionListEntity, SessionListFormSetter> sessionList = (obj, form) -> SessionListFormSetter.by(obj, form);

  FormFunction<StudentEntity, StudentFormSetter> student = (obj, form) -> StudentFormSetter.by(obj, form);

  FormFunction<TeacherEntity, TeacherFormSetter> teacher = (obj, form) -> TeacherFormSetter.by(obj, form);

  FormFunction<UserEntity, UserFormSetter> user = (obj, form) -> UserFormSetter.by(obj, form);
}
