package cn.tedu.store.service.ex;

import cn.tedu.store.service.ex.ServiceException;

/**
 * 用户名重复异常
 */
public class UsernameDuplicateException extends ServiceException {
    public UsernameDuplicateException() {
    }

    public UsernameDuplicateException(String message) {
        super(message);
    }

    public UsernameDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDuplicateException(Throwable cause) {
        super(cause);
    }

    public UsernameDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
