package com.huilong.chapter4;

import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 动态切换代理对象
 *
 * @author daocr
 * @date 2021/1/8
 */
@Slf4j
public class HotSwappableTargetSourceApp {


    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong.chapter4");
        applicationContext.refresh();


        new Thread(() -> {
            try {
                log.info("5秒后切换");
                Thread.sleep(5000);
                HotSwappableTargetSource bean = applicationContext.getBean(HotSwappableTargetSource.class);
                HelloService helloServiceV2 = applicationContext.getBean("helloServiceV2", HelloService.class);
                bean.swap(helloServiceV2);
                log.info("切换成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        for (int i = 0; i < 100; i++) {
            ProxyFactory proxyFactory = applicationContext.getBean("myProxyFactory", ProxyFactory.class);
            HelloService helloService = (HelloService) proxyFactory.getProxy();
            helloService.SayHello("张三");
            Thread.sleep(1000);
        }


        // 关闭容器
        applicationContext.close();


    }
}
