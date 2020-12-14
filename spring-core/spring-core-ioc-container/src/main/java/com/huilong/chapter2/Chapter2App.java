package com.huilong.chapter2;

import com.huilong.chapter2.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化
 *
 * @author daocr
 * @date 2020/12/14
 */
public class Chapter2App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter2/application.xml");

        // 获取 对象
        HelloService bean = classPathXmlApplicationContext.getBean("helloService3", HelloService.class);

        bean.SayHello("张三");

        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
