package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * 获取  bean factory， 提供了查询 spring bean 的功能
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Component
public class MyBeanFactoryAware implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        log.info("获取 beanFactory  成功，提供 查询 spring bean 的功能 {}", beanFactory);
    }
}
