package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

/**
 * 所有控制器类的基类
 */
public abstract class BaseController {
    protected static final Integer OK = 2000; //常量
    /**
     * 获取登录用户的id
     * @param session 会话对象
     * @return 登录用户id
     */
    public Integer getUidFromSession(HttpSession session){
        //session.getAttribute取出的结果是Object类型，toString是将其转换成字符串
        //Integer.valueOf(s)：将s字符串转换为数值
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

}
