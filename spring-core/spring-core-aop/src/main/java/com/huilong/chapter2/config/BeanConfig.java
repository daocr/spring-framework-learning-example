/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aop
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2.config;

import com.huilong.chapter2.advice.MyAfterReturningAdvice;
import com.huilong.chapter2.advice.MyAroundAdvice;
import com.huilong.chapter2.advice.MyMethodBeforeAdvice;
import com.huilong.chapter2.advice.MyThrowsAdvice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过bean 名称 自动创建拦截器
 *
 * @author daocr
 * @date 2021/1/8
 */
@Configuration
public class BeanConfig {

    @Bean
    public BeanNameAutoProxyCreator getBeanNameAutoProxyCreator() {

        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();

        // 多个用 "," 隔开
        beanNameAutoProxyCreator.setBeanNames("*helloService*");
        // 设置拦截器
        beanNameAutoProxyCreator.setInterceptorNames("myAfterReturningAdvice", "MyAroundAdvice", "MyMethodBeforeAdvice", "MyThrowsAdvice");

        return beanNameAutoProxyCreator;
    }


    @Bean("myAfterReturningAdvice")
    public MyAfterReturningAdvice getMyAfterReturningAdvice() {
        return new MyAfterReturningAdvice();
    }


    @Bean("MyAroundAdvice")
    public MyAroundAdvice getMyAroundAdvice() {
        return new MyAroundAdvice();
    }


    @Bean("MyMethodBeforeAdvice")
    public MyMethodBeforeAdvice getMyMethodBeforeAdvice() {
        return new MyMethodBeforeAdvice();
    }


    @Bean("MyThrowsAdvice")
    public MyThrowsAdvice getMyThrowsAdvice() {
        return new MyThrowsAdvice();
    }
}
