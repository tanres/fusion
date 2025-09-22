package com.tanres.fusion.framework.core.exception;

/**
 * 全局错误码枚举
 * 0-999 系统异常编码保留
 */
public interface ErrorCodeConstants {

    // 成功
    ErrorCode SUCCESS = new ErrorCode(0, "成功");

    // 客户端错误
    ErrorCode BAD_REQUEST = new ErrorCode(400, "请求参数错误");
    ErrorCode UNAUTHORIZED = new ErrorCode(401, "账号未登录");
    ErrorCode FORBIDDEN = new ErrorCode(403, "没有该操作权限");
    ErrorCode NOT_FOUND = new ErrorCode(404, "请求未找到");
    ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(405, "请求方法不正确");

    // 服务器错误
    ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(500, "系统异常");

    // 自定义错误
    ErrorCode UNKNOWN = new ErrorCode(999, "未知错误");

}
