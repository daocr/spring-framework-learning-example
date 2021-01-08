package com.huilong.chapter2.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 环绕通知
 *
 * @author daocr
 * @date 2021/1/8
 */
@Slf4j
public class MyAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("开始环绕通知");
        Object proceed = invocation.proceed();
        log.info("结束环绕通知");
        return proceed;

    }
}
