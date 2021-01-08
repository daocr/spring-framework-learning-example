package com.huilong.chapter1;

import com.huilong.chapter1.advice.MyAfterReturningAdvice;
import com.huilong.chapter1.advice.MyAroundAdvice;
import com.huilong.chapter1.advice.MyMethodBeforeAdvice;
import com.huilong.chapter1.advice.MyThrowsAdvice;
import com.huilong.chapter1.service.HelloService;
import com.huilong.chapter1.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author daocr
 * @date 2020/12/31
 */
@Slf4j
public class ProxyFactoryApp {

    public static void main(String[] args) {

        ProxyFactory helloProxyFactory = new ProxyFactory(new HelloServiceImpl());
        helloProxyFactory.setInterfaces(HelloService.class);

        // 带切入点,前置通知
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.huilong.chapter1.service.HelloService.*(..))");
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new MyMethodBeforeAdvice());
        helloProxyFactory.addAdvisor(defaultPointcutAdvisor);


//        helloProxyFactory.addAdvice(new MyMethodBeforeAdvice());
        helloProxyFactory.addAdvice(new MyAfterReturningAdvice());
        helloProxyFactory.addAdvice(new MyThrowsAdvice());
        helloProxyFactory.addAdvice(new MyAroundAdvice());

        HelloService proxy = (HelloService) helloProxyFactory.getProxy();
        proxy.SayHello("aa");
        log.info("proxy class name ：{}", proxy.getClass().getName());

    }
}
