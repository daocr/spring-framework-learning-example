package com.huilong.chapter1.conf;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * 设置快速失败模式
 *
 * @author wangji
 */
@Configuration
public class HibernateValidatorConfig {

    @Bean
    @Primary
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setBeforeExistingAdvisors(true);
        postProcessor.setProxyTargetClass(true);
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    /**
     * 开启快速失败模式，一旦失败立即抛出异常
     *
     * @return
     */
    @Bean
    @Primary
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory().getValidator();
    }

    /**
     *
     * @return
     */
    @Bean
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }


}

