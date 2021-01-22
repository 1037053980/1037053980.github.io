package cn.tedu.store.controller;

import cn.tedu.store.service.ex.*;
import cn.tedu.store.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice：该注解写在类上，作用是给所有Controller控制器添加统一的操作或处理。
// 与类中标有@ExceptionHandler注解的方法一起，可起到统一处理异常的作用。
@RestControllerAdvice //相当于@ControllerAdvice+@ResponseBody
public class GlobalExceptionHandler {

    //@ExceptionHandler：该注解写在方法上，用来说明该方法是一个统一    
    // 处理异常的方法。默认情况下，该方法能处理的异常类型由方法的参数类型决定
    @ExceptionHandler
    public R<Void> handleException(ServiceException e){
        if(e instanceof UsernameDuplicateException){
            return new R<>(4020,e);
        }else if (e instanceof UserNotFoundException){
            return new R<>(4030,e);
        }else if(e instanceof AccessDeniedException){
            return new R<>(4040,e);
        }else if(e instanceof PasswordNotMatchException){
            return new R<>(4050,e);
        }else if (e instanceof InsertException) {
            return new R<>(5000,e);
        }else if (e instanceof UpdateException) {
            return new R<>(5010,e);
        }else if (e instanceof UserDetailNotFoundException){
            return new R<>(5020,e);
        }else if (e instanceof QuestionTypeDuplicateException){
            return new R<>(5030,e);
        }else if (e instanceof QuestionTypeNotFoundException){
            return new R<>(5040,e);
        }else if (e instanceof QuestionNotFoundException){
            return new R<>(5050,e);
        }
        else{
            e.printStackTrace();//在控制台打印出错跟踪信息
            return new R<>(-999999, "未知错误请稍后重试");
        }
    }
}
