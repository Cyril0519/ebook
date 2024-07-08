package com.wxy.common.intercept;

import com.wxy.common.pojo.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class ErrorIntercept {

    @ExceptionHandler(Exception.class)
    public Resp handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Resp.fail(e.getMessage());
    }

}
