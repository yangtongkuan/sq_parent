package com.yang.sq.api.common.asserts;

import com.yang.sq.api.common.exception.BusinessException;

public class AssertUtils {
    public static void isNull(Object obj, String msg) {
        if (obj == null || "".equals(obj)) {
            throw new BusinessException(msg);
        }
    }

    public static void isNull(Object obj) {
        isNull(obj, "[Assertion failed] - the object argument must be null");
    }

}
