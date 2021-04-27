/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter4.service.impl;

import com.huilong.chapter4.service.HelloService4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 实现 bean初始化接口 、bean销毁接口
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class HelloService4Impl implements HelloService4, InitializingBean, DisposableBean {


    @Override
    public void SayHello(String name) {

    }

    /**
     * 等价写法
     * 1、使用 @PostConstruct 注解
     * 2、在 xml bean 标签 init-method="init" 属性中指定
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        log.info(" HelloService7  InitializingBean 销毁 ");
    }

    /**
     * 等价写法
     * 1、使用  @PreDestroy 注解
     * 2、在 xml bean 标签  destroy-method="destroy" 属性中指定
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(" HelloService7  DisposableBean 初始化");
    }
}
