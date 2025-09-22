package com.tanres.fusion.framework.core.exception;

public class ServiceExceptionUtil {
    public static ServiceException exception(ErrorCode code) {
        return new ServiceException(code.getCode(), code.getMsg());
    }
}
