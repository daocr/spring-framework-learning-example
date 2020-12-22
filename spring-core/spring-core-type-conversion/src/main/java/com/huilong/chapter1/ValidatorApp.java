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
public class ValidatorApp {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter1");

        annotationConfigApplicationContext.refresh();

        PersonDto personDto = new PersonDto();

        Validator validator = annotationConfigApplicationContext.getBean(Validator.class);

        Set<ConstraintViolation<PersonDto>> validate = validator.validate(personDto);

        for (ConstraintViolation<PersonDto> personDtoConstraintViolation : validate) {
            log.info(personDtoConstraintViolation.getMessage());
        }

        HelloService1 bean = annotationConfigApplicationContext.getBean(HelloService1.class);

//        手动 调用 验证
        ManualVerification(personDto);


        bean.SayHello(null);

        // 关闭容器
        annotationConfigApplicationContext.close();


        // 手动校验


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