package cn.tedu.store.util;

import cn.tedu.store.entity.User;

/**
 * 响应数据格式类
 */
public class R<T> { //T代表泛型，在创建R对象时，要指定具体的类型
    private Integer state;  //状态码
    private String message; //与状态码相关的描述信息
    private T data; //携带的数据

    public R() {
    }

    public R(Integer state) {
        this.state = state;
    }

    public R(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public R(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public R(Integer state,Throwable e){
        this.state = state ;
        this.message = e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
