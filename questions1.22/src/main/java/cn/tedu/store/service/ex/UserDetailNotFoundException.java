package cn.tedu.store.service.ex;

/*
 * 未找到指定商品异常
 */
public class UserDetailNotFoundException extends ServiceException{
    public UserDetailNotFoundException() {
    }

    public UserDetailNotFoundException(String message) {
        super(message);
    }

    public UserDetailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDetailNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserDetailNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
