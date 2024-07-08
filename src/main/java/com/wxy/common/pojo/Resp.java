package com.wxy.common.pojo;

import lombok.Data;

// 通用返回对象
@Data
public class Resp {
    private int code;
    private String msg;
    private Object data;

    public Resp() {
    }

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Resp(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Resp success() {
        return new Resp(200, "成功");
    }

    public static Resp success(Object data) {
        return new Resp(200, "成功", data);
    }

    public static Resp fail() {
        return new Resp(500, "失败");
    }

    public static Resp fail(String msg) {
        return new Resp(500, msg);
    }

    // 未认证
    public static Resp unauthorized() {
        return new Resp(401, "未认证");
    }

    // 未授权
    public static Resp forbidden() {
        return new Resp(403, "未授权");
    }

    // 未找到
    public static Resp notFound() {
        return new Resp(404, "未找到");
    }

}
