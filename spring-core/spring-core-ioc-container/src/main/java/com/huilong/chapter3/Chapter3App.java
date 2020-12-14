package com.huilong.chapter3;

import com.huilong.chapter3.service.DependencyInjectionHelloService;
import com.huilong.chapter3.service.impl.ComplexObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter3App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter3/application.xml");

        // 获取 对象
        DependencyInjectionHelloService bean1 = classPathXmlApplicationContext.getBean("dependencyInjectionService", DependencyInjectionHelloService.class);
        bean1.SayHello("张三");

        DependencyInjectionHelloService bean2 = classPathXmlApplicationContext.getBean("dependencyInjectionService2", DependencyInjectionHelloService.class);
        bean2.SayHello("李四");


        ComplexObject bean = classPathXmlApplicationContext.getBean(ComplexObject.class);
        log.info("ComplexObject : {}",bean);


        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
