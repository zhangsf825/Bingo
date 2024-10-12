package com.bingo.common.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "ResultBean")
public class ResultBean<T> implements Serializable {

    /**
     * 0表示成功，其他值表示失败
     */
    private int code = 0;
    /**
     * 消息内容
     */
    private String msg = "success";
    /**
     * 响应数据
     */
    private T data;

    public ResultBean success() {
        return this;
    }

    public ResultBean<T> success(T data) {
        this.data = data;
        return this;
    }

    public ResultBean<T> error() {
        this.code = 500;
        this.msg = "服务器内部异常";
        return this;
    }

    public ResultBean<T> error(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public ResultBean<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

}