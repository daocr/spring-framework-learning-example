/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2;

import com.huilong.chapter2.service.HelloService2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化
 *
 * @author daocr
 * @date 2020/12/14
 */
public class Chapter2App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter2/application.xml");

        // 获取 对象
        HelloService2 bean = applicationContext.getBean("helloService3", HelloService2.class);

        bean.SayHello("张三");

        // 关闭容器
        applicationContext.close();

    }

}
