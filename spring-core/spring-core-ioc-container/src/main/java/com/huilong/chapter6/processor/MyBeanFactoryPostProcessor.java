package com.huilong.chapter6.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
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




        log.info("获取  管理 spring bean 的元数据信息 ConfigurableListableBeanFactory 成功 {}", beanFactory);
    }
}
