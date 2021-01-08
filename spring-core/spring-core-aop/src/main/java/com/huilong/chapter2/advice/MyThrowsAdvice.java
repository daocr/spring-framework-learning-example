package com.huilong.chapter2.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 异常通知
 *
 * @author daocr
 * @date 2020/12/31
 */
@Slf4j
public class MyThrowsAdvice implements ThrowsAdvice {

    /**
     * 第一种约定
     * 注意事项：方法名称，参数顺序个数，都不能进行修改
     * <like
     * 具体原因查看
     * {@link org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor#ThrowsAdviceInterceptor(Object)} 限制方法名称以及参数个数
     * {@link org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor#invokeHandlerMethod(org.aopalliance.intercept.MethodInvocation, Throwable, Method)} 传入实参
     *
     * @param method
     * @param args
     * @param target
     * @param exception
     * @throws Throwable
     */
    public void afterThrowing(Method method, Object[] args, Object target, Exception exception) throws Throwable {
        log.info("异常通知：");
    }


//    /**
//     * 第二种约定
//     * 注意事项：方法名称，参数顺序个数，都不能进行修改
//     *
//     * 具体原因查看
//     * {@link org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor#ThrowsAdviceInterceptor(java.lang.Object)}
//     * {@link org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor#invokeHandlerMethod(org.aopalliance.intercept.MethodInvocation, java.lang.Throwable, java.lang.reflect.Method)}
//     *
//     * @param exception
//     * @throws Throwable
//     */
//    public void afterThrowing(Exception exception) throws Throwable {
//        log.info("异常通知：");
//    }
}
