package com.tanres.fusion.framework.core.util;

import lombok.Data;

@Data
public class R<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
}
