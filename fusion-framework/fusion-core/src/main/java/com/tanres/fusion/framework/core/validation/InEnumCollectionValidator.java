package com.tanres.fusion.framework.core.validation;

import cn.hutool.core.collection.CollUtil;
import com.tanres.fusion.framework.core.util.ArrayValuable;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InEnumCollectionValidator implements ConstraintValidator<InEnum, Collection<?>> {

    private List<?> values;

    @Override
    public void initialize(InEnum annotation) {
        ArrayValuable<?>[] constants = annotation.value().getEnumConstants();
        if (constants.length == 0) {
            values = Collections.emptyList();
        } else {
            values = Arrays.asList(constants[0].array());
        }
    }

    @Override
    public boolean isValid(Collection<?> list, ConstraintValidatorContext context) {
        if (null == list) {
            return true;
        }

        // 校验通过
        if (CollUtil.containsAll(values, list)) {
            return true;
        }

        // 校验不通过，自定义提示语句
        context.disableDefaultConstraintViolation(); // 禁用默认的 message 的值
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()
                .replaceAll("\\{value}", CollUtil.join(list, ","))).addConstraintViolation(); // 重新添加错误提示语句
        return false;
    }
}
