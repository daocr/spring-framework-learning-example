package com.huilong.chapter1.validated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举约束
 *
 * @author miao
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumsConstraintValidator.class)
public @interface Enums {

    String message() default "不符合枚举要求 {enums}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 限定枚举
     *
     * @return
     */
    String[] enums() default {};
}