package cn.tedu.store.service.ex;

/*
*订单显示信息异常类
 */
public class QuestionTypeNotFoundException extends ServiceException{
    public QuestionTypeNotFoundException() {
    }

    public QuestionTypeNotFoundException(String message) {
        super(message);
    }

    public QuestionTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionTypeNotFoundException(Throwable cause) {
        super(cause);
    }

    public QuestionTypeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
