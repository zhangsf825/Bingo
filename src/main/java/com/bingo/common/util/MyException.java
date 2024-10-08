package com.bingo.common.util;

/**
 * 自定义异常
 */
public class MyException extends RuntimeException {

    private int code;
    private String msg;

    public MyException(int code, String params) {
        this.code = code;
        this.msg = params;
    }
    public MyException(String msg, Throwable e) {
        super(e);
        this.code = 500;
        this.msg = msg;
    }

    public MyException(int code, Throwable e, String params) {
        super(e);
        this.code = code;
        this.msg = params;
    }

    public MyException(String msg) {
        super(msg);
        this.code = 500;
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}