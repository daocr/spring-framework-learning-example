package com.huilong.chapter3;

import com.huilong.chapter3.service.DependencyInjectionHelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @author daocr
 * @date 2020/12/14
 */
public class Chapter2App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter2/application.xml");

        // 获取 对象
        DependencyInjectionHelloService bean = classPathXmlApplicationContext.getBean("helloService3", DependencyInjectionHelloService.class);

        bean.SayHello("张三");

        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
