package cn.tedu.store.service.impl;

import cn.tedu.store.entity.User;
import cn.tedu.store.entity.UserDetail;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserDetailService;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.*;
import cn.tedu.store.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 处理用户数据业务层接口的实现类
 */
//@Service注解，是spring框架提供的注解，该注解写在类上，其作用是
//自动创建一个该类的对象，放到框架的容器中。如果没有此注解，则下面的
//@Autowired注解无效。
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserDetailService userDetailService;

    @Override
    public void register(User user) {
        //从方法参数中获取注册的用户名
        String username = user.getUsername();
        //调用userMapper的findByUsername进行查询
        User result = userMapper.findByUsername(username);
        if (result != null) {
            //若查询结果不为null,则抛出UsernameDuplicateException
            throw new UsernameDuplicateException("注册失败，用户名已被占用!");
        }

        LocalDateTime now = LocalDateTime.now();//当前日期时间
        String password = user.getPassword();//用户输入的明文密码
        String md5Password = PasswordUtil.getMd5Password(password);//加密后的密码
        //补全用户注册的数据
        user.setPassword(md5Password);//将密码设置为Md5密码
        user.setType(0);     //普通学生用户
        user.setGmtCreate(now);     //创建日期时间
        user.setGmtModified(now);     //修改日期时间

        //调用userMapper的insert方法插入数据
        Integer rows = userMapper.insert(user);
        User userLast = userMapper.findByUsername(user.getUsername());

        //插入一条用户错题信息
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(userLast.getId());
        userDetail.setSolvedTotal(0);
        userDetail.setAcTotal(0);
        userDetail.setWoTotal(0);
        userDetail.setGmtModified(now);
        userDetail.setGmtCreate(now);
        userDetailService.addToUserDetail(userDetail);

        if (rows != 1) {
            //如果受影响的行数不为1，则抛出InsertException
            throw new InsertException("注册失败，请稍后重试！");
        }
    }

    @Override
    public User login(String username, String password) {
        //调用userMapper的findByUsername进行查询
        User result = userMapper.findByUsername(username);
        if (result == null) {
            //如果查询结果为null，则抛出UserNotFoundException
            throw new UserNotFoundException("用户名不存在");
        }


        String md5Password = PasswordUtil.getMd5Password(password);
        if (!result.getPassword().equals(md5Password)) {
            //如果密码不匹配，则抛出PasswordNotMatchException
            throw new PasswordNotMatchException("密码不正确");
        }

        //登录通过，整理将可以返回给控制器的用户数据，进行返回
        User user = new User();
        user.setId(result.getId());
        user.setUsername(result.getUsername());
        return user;
    }

    @Override
    public void changePassword(Integer id, String oldPassword, String newPassword) {
        //调用userMapper的findById查询用户数据
        User result = userMapper.findById(id);

        //若查询结果为null , 则抛出UserNotFoundException
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }


        //若原密码输入不正确，则抛出PasswordNotException
       // System.out.println(oldPassword);
        String md5OldPassword = PasswordUtil.getMd5Password(oldPassword);
        if (!result.getPassword().equals(md5OldPassword)) {
            throw new PasswordNotMatchException("原密码不正确");
        }

        //调用userMapper的UpdatePasswordById更新用户密码
        String md5NewPassword = PasswordUtil.getMd5Password(newPassword);
        Integer rows = userMapper.updatePassword(id, md5NewPassword, LocalDateTime.now());
        if (rows != 1) {
            //若受影响的行数不为1，则抛出UpdateException
            throw new UpdateException("服务器忙，请稍后重试");
        }

    }

    @Override
    public User getById(Integer id) {
        //调用userMapper的findById查询用户数据
        User result = userMapper.findById(id);
        if (result == null) {
            //若查询结果为null , 则抛出UserNotFoundException
            throw new UserNotFoundException("用户数据不存在");
        }

        // 对结果进行处理，只返回部分用户数据
        User user = new User();
        user.setUsername(result.getUsername());
        user.setGender(result.getGender());
        user.setEmail(result.getEmail());
        user.setPhone(result.getPhone());
        user.setId(result.getId());
        return user;
    }


    @Override
    public void changeInfoById(Integer id, User user) {
        //调用userMapper的findById查询用户数据
        User result = userMapper.findById(id);
        if (result == null) {
            //若查询结果为null , 则抛出UserNotFoundException
            throw new UserNotFoundException("用户数据不存在");
        }

        //补全用户资料
        user.setId(id);
        user.setGmtModified(LocalDateTime.now());
        Integer rows = userMapper.updateInfoById(user);
        if (rows != 1) {
            //若受影响的行数不为1，则抛出UpdateException
            throw new UpdateException("服务器忙，请稍候重试");
        }
    }

    @Override
    public Integer isAdminister(Integer id) {
        User user = userMapper.findById(id);
        Integer type = user.getType();
        if(type == 1) return 1;
        else return 0;
    }
    /**/
}
