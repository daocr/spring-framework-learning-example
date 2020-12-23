package com.huilong.chapter1;

import com.huilong.chapter1.dto.PersonDto;
import com.huilong.chapter1.service.HelloService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class ValidatorAppChapter1 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.huilong.chapter1");
        annotationConfigApplicationContext.refresh();

        PersonDto personDto = new PersonDto();

        HelloService1 bean = annotationConfigApplicationContext.getBean(HelloService1.class);

//      1、  手动 调用 验证
        ManualVerification(personDto);

        // 2、 aop 切面拦截
        bean.SayHello(null);

        // 关闭容器
        annotationConfigApplicationContext.close();

    }

    // 手动 调用 验证
    private static void ManualVerification(PersonDto personDto) {


        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<PersonDto>> set = validator.validate(personDto);
        for (ConstraintViolation<PersonDto> constraintViolation : set) {
            log.info("手动验证：{} {}", constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        }
    }


}