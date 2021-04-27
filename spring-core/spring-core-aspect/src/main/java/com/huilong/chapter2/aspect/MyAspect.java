/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-aspect
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2.aspect;

import com.huilong.chapter2.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 我的切面例子
 * <p>
 * 通知顺序  @Around > @Before >  @After >  @AfterReturning > @AfterThrowing
 *
 * @author daocr
 * @date 2020/12/28
 */
@Aspect
@Component
@Slf4j
public class MyAspect {

    public MyAspect() {
        log.info("MyAspect 初始化完成");
    }


    /**
     * 定义切入点
     * <pre>
     *         execution(public * *(..))                                            匹配任何共有方法
     *         execution(* set*(..))                                                匹配任何set方法
     *         execution(* com.xyz.service.AccountService.*(..))                    匹配AccountService 接口的任何方法
     *         execution(* com.xyz.service.*.*(..))                                 匹配com.xyz.service 包下的所有方法，但是不包括子包
     *         execution(* com.xyz.service..*.*(..))                                匹配com.xyz.service 包下的所有方法，但是包括子包
     *
     *         within(com.xyz.service.*)                                            匹配com.xyz.service 包下的所有方法，但是不包括子包  ；仅在Spring AOP中执行方法
     *         within(com.xyz.service..*)                                           匹配com.xyz.service 包下的所有方法，但是包括子包    ；仅在Spring AOP中执行方法
     *
     *         this(com.xyz.service.AccountService)                                 匹配AccountService 接口的任何方法                 ；仅在Spring AOP中执行方法
     *
     *         target(com.xyz.service.AccountService)                               匹配AccountService 实现类所以的方法                ；仅在Spring AOP中执行方法
     *
     *         args(java.io.Serializable)                                           匹配单个参数实现了Serializable 的方法               ；仅在Spring AOP中执行方法
     *
     *         @target(org.springframework.transaction.annotation.Transactional) 匹配使用Transactional 注解的方法                      ；仅在Spring AOP中执行方法
     *         @within(org.springframework.transaction.annotation.Transactional) 匹配使用Transactional 注解的方法                      ；仅在Spring AOP中执行方法
     *         @annotation(org.springframework.transaction.annotation.Transactional)匹配使用Transactional 注解的方法                   ；仅在Spring AOP中执行方法
     *
     *         bean(tradeService)                                                   匹配bean name 是tradeService                      ；仅在Spring AOP中执行方法
     *         bean(*Service)                                                       匹配bean name 后缀是 Service                       ；仅在Spring AOP中执行方法
     *
     * </pre>
     */

    /**
     * 前置通知
     */
    @Before("@annotation(logAspect)")
    public void before(LogAspect logAspect) {

        log.info("触发前置通知（Before） {}", logAspect);
    }

    /**
     * 前置通知
     */
    @After("@annotation(logAspect)")
    public void after(LogAspect logAspect) {
        log.info("触发后置通知（After） {}", logAspect);
    }

    /**
     * 后置通知
     */
    @AfterReturning(returning = "retVal", value = "@annotation(logAspect)")
    public void afterReturning(LogAspect logAspect, Object retVal) {
        log.info("触发后置通知 （AfterReturning） {}", logAspect);
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "@annotation(logAspect)", throwing = "ex")
    public void afterThrowing(LogAspect logAspect, Exception ex) {
        log.info("触发异常通知（） {AfterThrowing}", logAspect);
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "@annotation(com.huilong.chapter1.LogAspect) &&@annotation(logAspect)")
    public void around(ProceedingJoinPoint pjp, LogAspect logAspect) throws Throwable {
        log.info("开始触发环绕通知（Around） {}", logAspect);
        pjp.proceed();
        log.info("结束触发环绕通知（Around） {}", logAspect);
    }


}
