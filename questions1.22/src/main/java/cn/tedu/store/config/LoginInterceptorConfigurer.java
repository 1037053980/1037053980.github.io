package cn.tedu.store.config;

import cn.tedu.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录拦截器配置类
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    //addInterceptors: 添加自定义拦截器的配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        //白名单
        List<String> patterns = new ArrayList<>();
        patterns.add("/index.html");
        patterns.add("/register.html");
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/user/login");
        patterns.add("/user/register");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")//所有请求都要走指定的拦截器
                .excludePathPatterns(patterns);
    }
}
