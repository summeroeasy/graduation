package cn.org.atool.fluent.mybatis.refs;

import cn.org.atool.fluent.mybatis.base.IEntity;
import cn.org.atool.fluent.mybatis.base.mapper.IRichMapper;
import cn.org.atool.fluent.mybatis.spring.MapperFactory;
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
import com.cx.fluentmybatis.mapper.AdminMapper;
import com.cx.fluentmybatis.mapper.ClassiMapper;
import com.cx.fluentmybatis.mapper.DeptMapper;
import com.cx.fluentmybatis.mapper.DownMapper;
import com.cx.fluentmybatis.mapper.InformMapper;
import com.cx.fluentmybatis.mapper.KtbgMapper;
import com.cx.fluentmybatis.mapper.LunwenMapper;
import com.cx.fluentmybatis.mapper.MessageMapper;
import com.cx.fluentmybatis.mapper.PaperlibMapper;
import com.cx.fluentmybatis.mapper.ProjectFromMapper;
import com.cx.fluentmybatis.mapper.ProjectMapper;
import com.cx.fluentmybatis.mapper.QzxjMapper;
import com.cx.fluentmybatis.mapper.RolesMapper;
import com.cx.fluentmybatis.mapper.SessionListMapper;
import com.cx.fluentmybatis.mapper.StudentMapper;
import com.cx.fluentmybatis.mapper.TeacherMapper;
import com.cx.fluentmybatis.mapper.UserMapper;
import java.lang.Class;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * MapperRef: 应用所有Mapper Bean引用
 *
 * @author powered by FluentMybatis
 */
public class MapperRef {
  private static final Map<Class<? extends IEntity>, IRichMapper> allMappers = new HashMap<>();

  private static final Set<Class<? extends IEntity>> allEntityClass = new HashSet<>();

  private static MapperRef instance;

  public final AdminMapper adminMapper;

  public final ClassiMapper classiMapper;

  public final DeptMapper deptMapper;

  public final DownMapper downMapper;

  public final InformMapper informMapper;

  public final KtbgMapper ktbgMapper;

  public final LunwenMapper lunwenMapper;

  public final MessageMapper messageMapper;

  public final PaperlibMapper paperlibMapper;

  public final ProjectMapper projectMapper;

  public final ProjectFromMapper projectFromMapper;

  public final QzxjMapper qzxjMapper;

  public final RolesMapper rolesMapper;

  public final SessionListMapper sessionListMapper;

  public final StudentMapper studentMapper;

  public final TeacherMapper teacherMapper;

  public final UserMapper userMapper;

  private MapperRef(MapperFactory factory) {
    this.adminMapper = factory.getBean(AdminMapper.class);
    this.classiMapper = factory.getBean(ClassiMapper.class);
    this.deptMapper = factory.getBean(DeptMapper.class);
    this.downMapper = factory.getBean(DownMapper.class);
    this.informMapper = factory.getBean(InformMapper.class);
    this.ktbgMapper = factory.getBean(KtbgMapper.class);
    this.lunwenMapper = factory.getBean(LunwenMapper.class);
    this.messageMapper = factory.getBean(MessageMapper.class);
    this.paperlibMapper = factory.getBean(PaperlibMapper.class);
    this.projectMapper = factory.getBean(ProjectMapper.class);
    this.projectFromMapper = factory.getBean(ProjectFromMapper.class);
    this.qzxjMapper = factory.getBean(QzxjMapper.class);
    this.rolesMapper = factory.getBean(RolesMapper.class);
    this.sessionListMapper = factory.getBean(SessionListMapper.class);
    this.studentMapper = factory.getBean(StudentMapper.class);
    this.teacherMapper = factory.getBean(TeacherMapper.class);
    this.userMapper = factory.getBean(UserMapper.class);
    allMappers.put(AdminEntity.class, this.adminMapper);
    allMappers.put(ClassiEntity.class, this.classiMapper);
    allMappers.put(DeptEntity.class, this.deptMapper);
    allMappers.put(DownEntity.class, this.downMapper);
    allMappers.put(InformEntity.class, this.informMapper);
    allMappers.put(KtbgEntity.class, this.ktbgMapper);
    allMappers.put(LunwenEntity.class, this.lunwenMapper);
    allMappers.put(MessageEntity.class, this.messageMapper);
    allMappers.put(PaperlibEntity.class, this.paperlibMapper);
    allMappers.put(ProjectEntity.class, this.projectMapper);
    allMappers.put(ProjectFromEntity.class, this.projectFromMapper);
    allMappers.put(QzxjEntity.class, this.qzxjMapper);
    allMappers.put(RolesEntity.class, this.rolesMapper);
    allMappers.put(SessionListEntity.class, this.sessionListMapper);
    allMappers.put(StudentEntity.class, this.studentMapper);
    allMappers.put(TeacherEntity.class, this.teacherMapper);
    allMappers.put(UserEntity.class, this.userMapper);
    allEntityClass.addAll(allMappers.keySet());
  }

  public static final synchronized MapperRef instance(MapperFactory factory) {
    if (instance == null) {
      instance = new MapperRef(factory);
    }
    return instance;
  }

  public static final IRichMapper mapper(Class<? extends IEntity> entityClass) {
    return allMappers.get(entityClass);
  }

  public static final Set<Class<? extends IEntity>> allEntityClass() {
    return allEntityClass;
  }
}
