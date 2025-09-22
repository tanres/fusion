package com.tanres.fusion.framework.core.exception;

import lombok.Data;

/**
 * 错误码
 */
@Data
public class ErrorCode {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String msg;

    public ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

