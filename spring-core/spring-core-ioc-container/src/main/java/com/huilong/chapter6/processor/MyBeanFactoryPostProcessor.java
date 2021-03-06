/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter6.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 管理 spring bean 的元数据信息
 *
 * @author daocr
 * @date 2020/12/14
 */
@Component
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();


        for (String beanDefinitionName : beanDefinitionNames) {

            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);

            log.info("beanDefinitionName {} beanDefinition {} ", beanDefinitionName, beanDefinition);
        }

        log.info("获取  管理 spring bean 的元数据信息 ConfigurableListableBeanFactory 成功 {}", beanFactory);
    }
}
