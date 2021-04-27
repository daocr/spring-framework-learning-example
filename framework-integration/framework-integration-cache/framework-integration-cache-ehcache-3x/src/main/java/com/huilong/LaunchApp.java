/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-cache-ehcache-3x
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong;

import com.huilong.ehcache3.service.HelloService;
import com.huilong.ext.model.param.StaffParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 */
@Slf4j
public class LaunchApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong");
        applicationContext.refresh();

        HelloService helloService = applicationContext.getBean(HelloService.class);
        StaffParam staffParam = new StaffParam();
        staffParam.setName("张三");

        for (int i = 0; i < 10; i++) {
            log.info("第 {} 次调用", i + 1);
            helloService.findStaff(staffParam);
        }


        // 关闭容器
        applicationContext.close();

    }

}
