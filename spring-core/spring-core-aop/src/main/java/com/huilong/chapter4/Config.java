package com.huilong.chapter4;

import com.huilong.chapter4.advice.MyAfterReturningAdvice;
import com.huilong.chapter4.advice.MyAroundAdvice;
import com.huilong.chapter4.advice.MyMethodBeforeAdvice;
import com.huilong.chapter4.advice.MyThrowsAdvice;
import com.huilong.chapter4.service.HelloService;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置 热更新
 *
 * @author daocr
 * @date 2021/1/8
 */
@Configuration
public class Config {

    /**
     * 1、声明热更新
     *
     * @param helloServiceV1
     * @return
     */
    @Bean
    public HotSwappableTargetSource getHotSwappableTargetSource(@Autowired HelloService helloServiceV1) {
        // 代理
        HotSwappableTargetSource hotSwappableTargetSource = new HotSwappableTargetSource(helloServiceV1);
        return hotSwappableTargetSource;
    }

    /**
     * 2、声明代理
     *
     * @param hotSwappableTargetSource
     * @return
     */
    @Bean("myProxyFactory")
    public ProxyFactory getProxyFactory(@Autowired HotSwappableTargetSource hotSwappableTargetSource) {

        ProxyFactory helloProxyFactory = new ProxyFactory();
        //代理热更新对象
        helloProxyFactory.setTargetSource(hotSwappableTargetSource);
        helloProxyFactory.setInterfaces(HelloService.class);

        // 带切入点,前置通知
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.huilong.chapter4.service.HelloService*.*(..))");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new MyMethodBeforeAdvice());
        helloProxyFactory.addAdvisor(defaultPointcutAdvisor);

//        helloProxyFactory.addAdvice(new MyMethodBeforeAdvice());
        // 后置通知
        helloProxyFactory.addAdvice(new MyAfterReturningAdvice());
        // 异常通知
        helloProxyFactory.addAdvice(new MyThrowsAdvice());
        // 环绕通知
        helloProxyFactory.addAdvice(new MyAroundAdvice());

        return helloProxyFactory;
    }
}
