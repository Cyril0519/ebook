package com.wxy.common.pojo;

import com.wxy.common.constant.StateCode;
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
        return new Resp(StateCode.SUCCESS, "成功");
    }

    public static Resp success(Object data) {
        return new Resp(StateCode.SUCCESS, "成功", data);
    }

    public static Resp fail() {
        return new Resp(StateCode.FAIL, "失败");
    }

    public static Resp fail(int code, String msg) {
        return new Resp(code, msg);
    }

    public static Resp fail(String msg) {
        return new Resp(StateCode.FAIL, msg);
    }

    // 未认证
    public static Resp unauthorized() {
        return new Resp(StateCode.UNAUTHORIZED, "未认证");
    }

    // 未授权
    public static Resp forbidden() {
        return new Resp(StateCode.FORBIDDEN, "未授权");
    }

    // 未找到
    public static Resp notFound() {
        return new Resp(StateCode.NOT_FOUND, "未找到");
    }

}
