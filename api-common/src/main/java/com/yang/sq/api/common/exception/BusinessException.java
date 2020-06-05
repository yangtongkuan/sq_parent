package com.yang.sq.api.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Jahnke【1029777564@qq.com】
 * @ClassName BusinessException
 * @Description: 金优返回的错误数据格式
 * @date 2019/11/18 11:14
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private String message;
    private String code;
    private String type;

    public BusinessException(String msg) {
        this.message = msg;
    }

    public BusinessException(String msg, String code) {
        this.message = msg;
        this.code = code;
    }
    
}
