package com.example.demo.common;

import java.io.Serializable;

public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Object data;

    // --- 静态构造方法 ---

    public static Result success() {
        return success(200, "操作成功", null);
    }

    public static Result success(Object data) {
        return success(200, "操作成功", data);
    }

    public static Result success(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public static Result error() {
        return error(400, "操作失败", null);
    }

    public static Result error(String msg) {
        return error(400, msg, null);
    }

    public static Result error(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    // --- Getter 和 Setter (已修正语法错误) ---

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}