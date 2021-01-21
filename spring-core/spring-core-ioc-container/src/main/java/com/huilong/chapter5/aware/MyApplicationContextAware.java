package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 获取 spring 上下午
 * <p>
 * 包含 BeanFactoryAware、 ApplicationEventPublisherAware 等提供的功能
 * <p>
 * 加载原理
 * <p>
 * {@link AbstractApplicationContext#refresh()}
 * <p>
 * {@link AbstractApplicationContext#prepareBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)}
 * <p>
 * {@link  org.springframework.context.support.ApplicationContextAwareProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)}
 * <p>
 * {@link ConfigurableBeanFactory#addBeanPostProcessor(org.springframework.beans.factory.config.BeanPostProcessor)}
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Component
public class MyApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

        log.info("获取 spring 上下文 成功, 提供了 bean查询、事件管理、环境变量、国际化、资源文件管理 等功能 {}  ", applicationContext);
    }
}
