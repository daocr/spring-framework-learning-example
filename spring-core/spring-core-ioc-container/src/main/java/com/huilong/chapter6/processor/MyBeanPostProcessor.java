package com.huilong.chapter6.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 可以用来加强 加强bean 的功能
 * 查看相关实现类
 *
 * @author daocr
 * @date 2020/12/14
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 * @see org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization bean ：{} beanName ：{}", bean, beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInitialization bean ：{} beanName ：{}", bean, beanName);
        return bean;
    }


}
