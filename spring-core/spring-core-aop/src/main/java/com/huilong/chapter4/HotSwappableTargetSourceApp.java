/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aop
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter4;

import com.huilong.chapter4.config.Config;
import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 动态切换代理对象
 * 查看 配置 {@link Config}
 *
 * @author daocr
 * @date 2021/1/8
 */
@Slf4j
public class HotSwappableTargetSourceApp {


    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong.chapter4");
        applicationContext.refresh();


        new Thread(() -> {
            try {
                log.info("---------5秒后切换-------------");
                Thread.sleep(5000);
                HotSwappableTargetSource bean = applicationContext.getBean(HotSwappableTargetSource.class);
                HelloService helloServiceV2 = applicationContext.getBean("helloServiceV2", HelloService.class);
                // 切换实现类
                bean.swap(helloServiceV2);
                log.info("\n\n-----------切换成功----------\n\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        for (int i = 0; i < 100; i++) {
            ProxyFactory proxyFactory = applicationContext.getBean("myProxyFactory", ProxyFactory.class);
            HelloService helloService = (HelloService) proxyFactory.getProxy();
            helloService.SayHello("张三");
            Thread.sleep(1000);
        }


        // 关闭容器
        applicationContext.close();


    }
}
