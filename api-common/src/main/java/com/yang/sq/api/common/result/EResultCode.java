package com.yang.sq.api.common.result;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/26
 * @To change this template use File | Settings | File Templates.
 * @desc 返回状态
 */
public enum EResultCode {
    SUCCESS(200, "请求操作成功"),
    NOT_FOUND(404, "请求操作成功"),
    SYS_ERROR(500, "系统错误");


    private int code;
    private String message;

    private EResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public EResultCode setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public EResultCode setMessage(String message) {
        this.message = message;
        return this;
    }
}
