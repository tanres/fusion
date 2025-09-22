package com.tanres.fusion.framework.core.exception;

import lombok.Data;
import lombok.Getter;

/**
 * 业务逻辑异常
 */
@Data
@Getter
public final class ServiceException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String msg;

    public ServiceException() {
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServiceException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ServiceException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
