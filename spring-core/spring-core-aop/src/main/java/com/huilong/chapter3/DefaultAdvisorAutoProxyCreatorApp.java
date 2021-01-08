package com.huilong.chapter3;

import com.huilong.chapter3.config.BeanConfig;
import com.huilong.chapter3.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动添加代理
 * <p>
 * 自动创建代理 {@link BeanConfig}
 *
 * @author daocr
 * @date 2021/1/8
 */
public class DefaultAdvisorAutoProxyCreatorApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong.chapter3");
        applicationContext.refresh();

        HelloService helloService = applicationContext.getBean(HelloService.class);

        helloService.SayHello("张三");

        // 关闭容器
        applicationContext.close();


    }
}
