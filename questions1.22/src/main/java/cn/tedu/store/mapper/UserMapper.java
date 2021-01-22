package cn.tedu.store.mapper;

import cn.tedu.store.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;

/**
 * 处理用户数据的持久层接口
 */
//@Mapper注解属于MyBatis框架提供的注解，该注解要求写在接口上，其作用是：
//自动生成该接口的实现类，并重写接口中所有方法（方法要执行的增删改查可分别通过
// @Insert、@Delete、@Updata、@Select指定),并创建该实体类的对象，放在框架的容器中。
@Mapper
public interface UserMapper {
    /**
     * 插入记录
     *
     * @param user 用户数据
     * @return 受影响的行数
     */
    //#{username},#{password}表示分别取形参user对象中username、password属性的值
    @Insert("insert into " +
            "user(username, password, phone, email, gender, type, gmt_create, gmt_modified) " +
            "values" +
            "(#{username}, #{password}, #{phone}, #{email}, #{gender}, #{type}, #{gmtCreate}, #{gmtModified})")
    public abstract Integer insert(User user);

    /**
     * 修改密码
     *
     * @param id           用户id
     * @param password     密码
     * @param gmtModifided 修改时间
     * @return
     */
    Integer updatePassword(Integer id, String password, LocalDateTime gmtModifided);

    /**
     * 更新个人信息
     *
     * @param user 用户信息
     * @return 受影响的行数
     */
    Integer updateInfoById(User user);

    /**
     * 按id查询用户记录
     *
     * @param id 用户id
     * @return 用户数据（封装成User对象，若未找到，则返回null）
     */
    User findById(Integer id);

    /**
     * 按用户名查询
     *
     * @param username 用户名
     * @return 若找到 返回该用户数据(封装成User对象)；若未找到，返回null
     */
    //#{username} 表示取形参username的值
    //注意is_enabled 等取别名
    @Select("select id, username, password, phone, email, gender, type, gmt_create as gmtCreate, gmt_modified as gmtModified " +
            "from user where username=#{username}")
    public abstract User findByUsername(String username);


}
