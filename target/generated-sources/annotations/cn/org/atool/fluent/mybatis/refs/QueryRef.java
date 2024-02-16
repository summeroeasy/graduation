package cn.org.atool.fluent.mybatis.refs;

import static cn.org.atool.fluent.mybatis.utility.MybatisUtil.notFluentMybatisException;

import cn.org.atool.fluent.mybatis.base.crud.IDefaultGetter;
import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.IUpdate;
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
import com.cx.fluentmybatis.helper.AdminDefaults;
import com.cx.fluentmybatis.helper.ClassiDefaults;
import com.cx.fluentmybatis.helper.DeptDefaults;
import com.cx.fluentmybatis.helper.DownDefaults;
import com.cx.fluentmybatis.helper.InformDefaults;
import com.cx.fluentmybatis.helper.KtbgDefaults;
import com.cx.fluentmybatis.helper.LunwenDefaults;
import com.cx.fluentmybatis.helper.MessageDefaults;
import com.cx.fluentmybatis.helper.PaperlibDefaults;
import com.cx.fluentmybatis.helper.ProjectDefaults;
import com.cx.fluentmybatis.helper.ProjectFromDefaults;
import com.cx.fluentmybatis.helper.QzxjDefaults;
import com.cx.fluentmybatis.helper.RolesDefaults;
import com.cx.fluentmybatis.helper.SessionListDefaults;
import com.cx.fluentmybatis.helper.StudentDefaults;
import com.cx.fluentmybatis.helper.TeacherDefaults;
import com.cx.fluentmybatis.helper.UserDefaults;
import java.lang.Class;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * QueryRef: 构造Entity对应的default query
 * 更新器工厂类单例引用
 *
 * @author powered by FluentMybatis
 */
public class QueryRef {
  public static final AdminDefaults admin = AdminDefaults.INSTANCE;

  public static final ClassiDefaults classi = ClassiDefaults.INSTANCE;

  public static final DeptDefaults dept = DeptDefaults.INSTANCE;

  public static final DownDefaults down = DownDefaults.INSTANCE;

  public static final InformDefaults inform = InformDefaults.INSTANCE;

  public static final KtbgDefaults ktbg = KtbgDefaults.INSTANCE;

  public static final LunwenDefaults lunwen = LunwenDefaults.INSTANCE;

  public static final MessageDefaults message = MessageDefaults.INSTANCE;

  public static final PaperlibDefaults paperlib = PaperlibDefaults.INSTANCE;

  public static final ProjectDefaults project = ProjectDefaults.INSTANCE;

  public static final ProjectFromDefaults projectFrom = ProjectFromDefaults.INSTANCE;

  public static final QzxjDefaults qzxj = QzxjDefaults.INSTANCE;

  public static final RolesDefaults roles = RolesDefaults.INSTANCE;

  public static final SessionListDefaults sessionList = SessionListDefaults.INSTANCE;

  public static final StudentDefaults student = StudentDefaults.INSTANCE;

  public static final TeacherDefaults teacher = TeacherDefaults.INSTANCE;

  public static final UserDefaults user = UserDefaults.INSTANCE;

  private static final Map<Class, IDefaultGetter> Supplier = new HashMap<>();

  static {
    Supplier.put(AdminEntity.class, admin);
    Supplier.put(ClassiEntity.class, classi);
    Supplier.put(DeptEntity.class, dept);
    Supplier.put(DownEntity.class, down);
    Supplier.put(InformEntity.class, inform);
    Supplier.put(KtbgEntity.class, ktbg);
    Supplier.put(LunwenEntity.class, lunwen);
    Supplier.put(MessageEntity.class, message);
    Supplier.put(PaperlibEntity.class, paperlib);
    Supplier.put(ProjectEntity.class, project);
    Supplier.put(ProjectFromEntity.class, projectFrom);
    Supplier.put(QzxjEntity.class, qzxj);
    Supplier.put(RolesEntity.class, roles);
    Supplier.put(SessionListEntity.class, sessionList);
    Supplier.put(StudentEntity.class, student);
    Supplier.put(TeacherEntity.class, teacher);
    Supplier.put(UserEntity.class, user);
  }

  /**
   * 返回clazz实体对应的默认Query实例
   */
  public static final IQuery defaultQuery(Class clazz) {
    	return findDefault(clazz).defaultQuery();
  }

  /**
   * 返回clazz实体对应的空Query实例
   */
  public static final IQuery emptyQuery(Class clazz) {
    	return findDefault(clazz).query();
  }

  /**
   * 返回clazz实体对应的默认Updater实例
   */
  public static final IUpdate defaultUpdater(Class clazz) {
    	return findDefault(clazz).defaultUpdater();
  }

  /**
   * 返回clazz实体对应的空Updater实例
   */
  public static final IUpdate emptyUpdater(Class clazz) {
    	return findDefault(clazz).updater();
  }

  public static final IDefaultGetter findDefault(Class clazz) {
    if (Supplier.containsKey(clazz)) {
    	return Supplier.get(clazz);
    }
    throw notFluentMybatisException(clazz);
  }
}
