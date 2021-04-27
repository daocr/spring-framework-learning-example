/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aspect
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1;

import com.huilong.chapter1.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 受限制的的上下文
 */
@Slf4j
public class AspectAppChapter1 {

    public static void main(String[] args) {

        //1、 class path  加载配置
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter1/application.xml");


        HelloService helloService = applicationContext.getBean(HelloService.class);

        helloService.SayHello("张三");

        // 关闭容器
        applicationContext.close();
    }


}