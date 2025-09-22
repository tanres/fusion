package com.tanres.fusion.framework.core.enums;

import com.tanres.fusion.framework.core.util.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum StatusEnum implements ArrayValuable<Integer> {
    DISABLE(0, "禁用"),
    ENABLE(1, "启用"),
    ;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(StatusEnum::getStatus).toArray(Integer[]::new);

    /**
     * 状态值
     */
    private final Integer status;

    /**
     * 状态名称
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isEnable(Integer status) {
        return StatusEnum.ENABLE.getStatus().equals(status);
    }

    public static boolean isDisable(Integer status) {
        return StatusEnum.DISABLE.getStatus().equals(status);
    }
}
