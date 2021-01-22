package cn.tedu.store.service.ex;

/**
 * 用户名重复异常
 */
public class QuestionTypeDuplicateException extends ServiceException {
    public QuestionTypeDuplicateException() {
    }

    public QuestionTypeDuplicateException(String message) {
        super(message);
    }

    public QuestionTypeDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionTypeDuplicateException(Throwable cause) {
        super(cause);
    }

    public QuestionTypeDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
