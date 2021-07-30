package com.huilong.chapter1.validated;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义  验证约束
 *
 * @author : miao
 * date : 2021-07-28
 */
public class EnumsConstraintValidator implements ConstraintValidator<Enums, Object> {

    private Enums enums;

    @Override
    public void initialize(Enums constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.enums = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {


        final List<String> enumsList = Arrays.asList(enums.enums());

        if (value instanceof String) {
            for (String anEnum : enumsList) {
                if (anEnum.equals(value.toString())) {
                    return Boolean.TRUE;
                }
            }
        }

        if (value instanceof List) {
            List<String> list = (List<String>) value;

            for (String em : list) {
                final boolean contains = enumsList.contains(em);
                if (!contains) {
                    return Boolean.FALSE;
                }
            }

            return Boolean.TRUE;
        }


        return Boolean.FALSE;
    }
}
