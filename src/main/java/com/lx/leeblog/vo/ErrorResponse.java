package com.lx.leeblog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * create by @author lixing on 2020/2/5 19:39
 */
public class ErrorResponse {
    private String errorMsg;
    private Integer status;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ErrorResponse(Integer status, String errorMsg) {
        this.errorMsg = errorMsg;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
