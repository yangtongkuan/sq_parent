package com.yang.sq.config.exception;

import com.yang.sq.api.common.exception.BusinessException;
import com.yang.sq.api.common.result.EResultCode;
import com.yang.sq.api.common.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {


    // todo: 空指针异常
    @ExceptionHandler(value = NullPointerException.class)
    public R handleNullException(NullPointerException e) {
        log.error("系统空指针异常:", e);
        return R.fail(EResultCode.NOT_FOUND, "系统空指针异常");
    }

    // todo: 自定义业务异常
    @ExceptionHandler(value = BusinessException.class)
    public R handleResultException(BusinessException e) {
        log.error("系统业务异常~原因是:{}", e.getMessage());
        return R.fail(EResultCode.SYS_ERROR, e.getMessage());
    }

    // todo: 其他异常
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {
        log.error("系统业务异常~原因是:{}", e.getMessage());
        return R.fail(EResultCode.NOT_FOUND, e.getMessage());
    }

}
