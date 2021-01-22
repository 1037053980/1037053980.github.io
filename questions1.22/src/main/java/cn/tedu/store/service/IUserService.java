package cn.tedu.store.service;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserService {
    /**
     * 用户注册
     *
     * @param user 用户
     */
    public abstract void register(User user);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户数据
     */
    public abstract User login(String username, String password);

    /**
     * 修改用户密码
     *
     * @param id          用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Integer id, String oldPassword, String newPassword);

    /**
     * 获取个人信息
     *
     * @param id 用户id
     * @return 个人信息
     */
    User getById(Integer id);

    /**
     * 修改用户资料
     *
     * @param id   用户id
     * @param user 用户数据（封装更新的数据）
     */
    void changeInfoById(Integer id, User user);

    Integer isAdminister(Integer id);
}
