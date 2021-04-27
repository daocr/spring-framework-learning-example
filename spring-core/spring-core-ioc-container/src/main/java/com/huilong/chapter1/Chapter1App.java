/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1;

import com.huilong.chapter1.service.HelloService1;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化  spring  容器
 *
 * @author daocr
 * @date 2020/12/14
 */
public class Chapter1App {

    public static void main(String[] args) {

        //1、 class path  加载配置
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter1/application.xml");

        //2、 文件系统 加载
        //  ApplicationContext applicationContext =  new FileSystemXmlApplicationContext("classpath:chapter1/application.xml");

        // 获取 对象
        HelloService1 bean = applicationContext.getBean(HelloService1.class);

        bean.SayHello("张三");

        // 关闭容器
        applicationContext.close();


    }

}
