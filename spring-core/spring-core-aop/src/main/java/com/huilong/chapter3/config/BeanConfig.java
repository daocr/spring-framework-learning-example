/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aop
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter3.config;

import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
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


    /**
     * 通过 BeanFactory 获取 Advisor 的实现类，
     *
     * <pre class=code>
     *
     * 实现原理
     *
     *  通过 org.springframework.beans.factory.config.BeanPostProcessor#postProcessAfterInitialization(java.lang.Object, java.lang.String) 返回代理对象
     *
     * {@link AbstractAutoProxyCreator#postProcessAfterInitialization(java.lang.Object, java.lang.String)}
     *
     * ↓↓↓
     *
     * {@link AbstractAutoProxyCreator#wrapIfNecessary(java.lang.Object, java.lang.String, java.lang.Object)}
     *
     * 扫描出 org.springframework.aop.Advisor 的实现类，并且分析bean 是否符合 pointcut
     * {@link AbstractAutoProxyCreator#getAdvicesAndAdvisorsForBean(java.lang.Class, java.lang.String, org.springframework.aop.TargetSource)}
     *
     * ↓↓↓ 创建代理
     *
     * {@link AbstractAutoProxyCreator#createProxy(java.lang.Class, java.lang.String, java.lang.Object[], org.springframework.aop.TargetSource)}
     *
     * </pre>
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

    @Bean
    public DefaultPointcutAdvisor getDefaultPointcutAdvisor() {
        // 带切入点,前置通知
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.huilong.chapter3.service..*(..))");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new com.huilong.chapter3.advice.MyMethodBeforeAdvice());
        return defaultPointcutAdvisor;
    }


    @Bean
    public DefaultPointcutAdvisor getDefaultPointcutAdvisor2() {
        // 带切入点,前置通知
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.huilong.chapter3.service..*(..))");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new com.huilong.chapter3.advice.MyAroundAdvice());
        return defaultPointcutAdvisor;
    }


}
