package com.kevin.mellow.base;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/4.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class BaseResponse<T> {
    private int code;
    private String message;
    private T content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
