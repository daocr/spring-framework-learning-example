/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 获取 bean 的名称
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
@Component
public class MyBeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        log.info("BeanNameAware 获取 bean 名称 {}", name);
    }
}
