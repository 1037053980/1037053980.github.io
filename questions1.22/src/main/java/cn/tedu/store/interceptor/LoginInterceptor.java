package cn.tedu.store.interceptor;

import cn.tedu.store.service.ex.AccessDeniedException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /*重写preHandle方法，该方法将在请求处理之前会被自动调用执行
    * 约定：若执行完该方法后，返回true，表示通过了检查，请求会被放行，继续处理
    * 若返回false，表示请求被拦截，到此结束。
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
//        if(session.getAttribute("uid") == null){
////            //若请求是一个AJAX请求
////            //利用jQuery框架发送AJAX时，请求头会携带一个参数名为X-Requested-With，
////            //参数值为XMLHttpRequest的参数对
////            if( "XMLHttpRequest" .equals( request.getHeader("X-Requested-With")) ){
////                throw new AccessDeniedException("请先登录再操作！");
////            }
//
//            //若未登录
//            //sendRedirect:向浏览器发送一个重定向,建议浏览器去访问/web/login.html
//            response.sendRedirect("/index.html");
//            return false;
//        }
        return true;
    }
}
