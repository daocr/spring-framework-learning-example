/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aop
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2;

import com.huilong.chapter2.config.BeanConfig;
import com.huilong.chapter2.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动创建代理 {@link BeanConfig}
 *
 * @author daocr
 * @date 2021/1/8
 */
public class BeanNameAutoProxyCreatorApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong.chapter2");
        applicationContext.refresh();

        HelloService helloService = applicationContext.getBean(HelloService.class);

        helloService.SayHello("张三");

        // 关闭容器
        applicationContext.close();

    }
}
