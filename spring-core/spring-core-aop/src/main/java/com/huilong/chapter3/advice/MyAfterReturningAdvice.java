package com.huilong.chapter3.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * 后置通知
 *
 * @author daocr
 * @date 2020/12/31
 */
@Slf4j
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        log.info("后置通知 (AfterReturningAdvice) returnValue : {} \n", returnValue);

    }
}
