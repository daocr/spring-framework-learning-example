package com.huilong.chapter1;

import com.huilong.chapter1.advice.MyAfterReturningAdvice;
import com.huilong.chapter1.advice.MyAroundAdvice;
import com.huilong.chapter1.advice.MyMethodBeforeAdvice;
import com.huilong.chapter1.advice.MyThrowsAdvice;
import com.huilong.chapter1.service.HelloService;
import com.huilong.chapter1.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author daocr
 * @date 2020/12/31
 */
@Slf4j
public class ProxyFactoryApp {

    public static void main(String[] args) {

        ProxyFactory helloProxyFactory = new ProxyFactory(new HelloServiceImpl());
        helloProxyFactory.setInterfaces(HelloService.class);
        helloProxyFactory.addAdvice(new MyMethodBeforeAdvice());
        helloProxyFactory.addAdvice(new MyAfterReturningAdvice());
        helloProxyFactory.addAdvice(new MyThrowsAdvice());
        helloProxyFactory.addAdvice(new MyAroundAdvice());

        HelloService proxy = (HelloService) helloProxyFactory.getProxy();
        proxy.SayHello("aa");
        log.info("proxy class name ：{}", proxy.getClass().getName());

    }
}
