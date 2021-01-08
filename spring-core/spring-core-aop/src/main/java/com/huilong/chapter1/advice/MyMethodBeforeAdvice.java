package com.huilong.chapter1.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 前置通知
 *
 * @author daocr
 * @date 2020/12/31
 */
@Slf4j
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        log.info("前置通知 MethodBeforeAdvice");

    }
}
