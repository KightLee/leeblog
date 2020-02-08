package com.lx.leeblog.util;
/**
 *  错误信息枚举
 */

import lombok.Data;

public enum ErrorCode {
    ERRORLOGIN_CODE(0, "请先登录再操作"),
    ERRORBLOG_CODE(1, "博客信息有误")
    ;
    private final Integer status;
    private final String msg;

    ErrorCode(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
