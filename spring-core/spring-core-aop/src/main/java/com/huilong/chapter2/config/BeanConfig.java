package com.huilong.chapter2.config;

import com.huilong.chapter2.advice.MyAfterReturningAdvice;
import com.huilong.chapter2.advice.MyAroundAdvice;
import com.huilong.chapter2.advice.MyMethodBeforeAdvice;
import com.huilong.chapter2.advice.MyThrowsAdvice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * 通过bean 名称 自动创建拦截器
 *
 * @author daocr
 * @date 2021/1/8
 */
@Configurable
public class BeanConfig {

    @Bean
    public BeanNameAutoProxyCreator getBeanNameAutoProxyCreator() {

        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();

        // 多个用 "," 隔开
        beanNameAutoProxyCreator.setBeanNames("HelloService*");
        // 设置拦截器
        beanNameAutoProxyCreator.setInterceptorNames("myAfterReturningAdvice", "myAfterReturningAdvice", "myAfterReturningAdvice", "myAfterReturningAdvice");

        return beanNameAutoProxyCreator;
    }


    @Bean("myAfterReturningAdvice")
    public MyAfterReturningAdvice getMyAfterReturningAdvice() {
        return new MyAfterReturningAdvice();
    }


    @Bean("myAfterReturningAdvice")
    public MyAroundAdvice getMyAroundAdvice() {
        return new MyAroundAdvice();
    }


    @Bean("myAfterReturningAdvice")
    public MyMethodBeforeAdvice getMyMethodBeforeAdvice() {
        return new MyMethodBeforeAdvice();
    }


    @Bean("myAfterReturningAdvice")
    public MyThrowsAdvice getMyThrowsAdvice() {
        return new MyThrowsAdvice();
    }
}
