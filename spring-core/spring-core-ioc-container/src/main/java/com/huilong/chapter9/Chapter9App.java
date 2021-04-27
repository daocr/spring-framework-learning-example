/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter9;

import com.huilong.chapter9.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 环境隔离
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter9App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter9");

        annotationConfigApplicationContext.refresh();
        // 启动容器
        annotationConfigApplicationContext.start();

        // 触发自定义 事件
        annotationConfigApplicationContext.publishEvent(new CustomEvent(new Chapter9App(), "登录"));
        annotationConfigApplicationContext.publishEvent(new CustomEvent(new Chapter9App(), "黑名单"));

        //停止容器事件
        annotationConfigApplicationContext.stop();

        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
