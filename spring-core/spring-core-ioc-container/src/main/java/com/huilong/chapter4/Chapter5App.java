/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter4;

import com.huilong.chapter4.service.HelloService4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 生命周期
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter5App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter4/application.xml");

        // 获取 对象
        HelloService4 helloService = applicationContext.getBean(HelloService4.class);
        helloService.SayHello("张三");


        // 关闭容器
        applicationContext.close();

    }

}
