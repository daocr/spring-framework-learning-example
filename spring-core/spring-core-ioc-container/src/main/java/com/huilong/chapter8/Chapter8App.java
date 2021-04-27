/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * 环境隔离
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter8App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.scan("com.huilong.chapter8");

        /**
         * 激活环境
         * 1、代码激活
         * 2、命令行参数激活 -Dspring.profiles.active="profile1,profile2"
         */

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        environment.addActiveProfile("dev");


        // 1、获取激活环境
        String[] activeProfiles = environment.getActiveProfiles();
        log.info("目前激活的环境有：{}", activeProfiles);


        applicationContext.refresh();

        // 关闭容器
        applicationContext.close();

    }

}
