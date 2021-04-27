/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aspect
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2;

import com.huilong.chapter2.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 受限制的的上下文
 */
@Slf4j
public class AspectAppChapter2 {

    public static void main(String[] args) {

        //1、 class path  加载配置

        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext("com.huilong.chapter2");

        HelloService helloService = applicationContext.getBean(HelloService.class);

        helloService.SayHello("张三");

        // 关闭容器
        applicationContext.close();
    }


}