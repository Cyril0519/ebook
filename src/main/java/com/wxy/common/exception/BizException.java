package com.wxy.common.exception;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private final int errCode;

    public BizException(int code, String message) {
        super(message);
        this.errCode = code;
    }

    public BizException(int errorCode, Throwable t) {
        super(t);
        this.errCode = errorCode;

    }


}
