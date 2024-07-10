package com.wxy.common.intercept;

import cn.dev33.satoken.exception.NotLoginException;
import com.wxy.common.exception.BizException;
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

    /**
     * 处理业务异常
     * @param e 异常
     * @return 通用返回对象
     */
    @ExceptionHandler(BizException.class)
    public Resp handleBizException(BizException e) {
        log.error("错误码:{}", e.getErrCode());
        log.error(e.getMessage(), e);
        return Resp.fail(e.getErrCode(), e.getMessage());
    }

    /**
     * 处理未登录异常
     * @param e 异常
     * @return 通用返回对象
     */
    @ExceptionHandler(NotLoginException.class)
    public Resp handleNotLoginException(NotLoginException e) {
        log.error(e.getMessage(), e);
        return Resp.unauthorized();
    }

    @ExceptionHandler(Exception.class)
    public Resp handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Resp.fail(e.getMessage());
    }

}
