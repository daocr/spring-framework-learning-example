/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * aware 相关接口实现
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter5App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.scan("com.huilong.chapter5");

        applicationContext.refresh();

        // 关闭容器
        applicationContext.close();

    }

}
