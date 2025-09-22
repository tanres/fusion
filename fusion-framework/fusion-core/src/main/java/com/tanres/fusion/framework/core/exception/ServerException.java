package com.tanres.fusion.framework.core.exception;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public final class ServerException extends RuntimeException {
    /**
     * 全局错误码
     *
     * @see ErrorCodeConstants
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String msg;

    public ServerException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServerException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ServerException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ServerException setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    
}
