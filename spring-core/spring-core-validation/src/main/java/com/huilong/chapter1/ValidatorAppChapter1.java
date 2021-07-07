/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-validation
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1;

import com.huilong.chapter1.dto.PersonDto;
import com.huilong.chapter1.group.Insert;
import com.huilong.chapter1.group.Update;
import com.huilong.chapter1.service.HelloService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class ValidatorAppChapter1 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.huilong.chapter1");
        context.refresh();

        PersonDto personDto = new PersonDto();

        // 1、  手动 调用 验证
        manualVerification(personDto);

//        // 3、使用 spring LocalValidatorFactoryBean
//        springValidator(context, personDto);
//
//        // 2、 aop 切面拦截
//        HelloService1 bean = context.getBean(HelloService1.class);
//        bean.SayHello(null);


        // 关闭容器
        context.close();

    }


    private static void springValidator(AnnotationConfigApplicationContext context, PersonDto personDto) {

        LocalValidatorFactoryBean localValidatorFactoryBean = context.getBean(LocalValidatorFactoryBean.class);

        Validator validator = localValidatorFactoryBean.getValidator();

        Set<ConstraintViolation<PersonDto>> validate = validator.validate(personDto);

        for (ConstraintViolation<PersonDto> constraintViolation : validate) {
            log.info("localValidatorFactoryBean 验证：{} {}", constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        }
    }

    // 手动 调用 验证
    private static void manualVerification(PersonDto personDto) {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<PersonDto>> set = validator.validate(personDto, Update.class);
        for (ConstraintViolation<PersonDto> constraintViolation : set) {
            log.info("手动验证：{} {}", constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        }
    }


}