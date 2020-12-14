package com.huilong.chapter1;

import com.huilong.chapter1.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化  spring  容器
 *
 * @author daocr
 * @date 2020/12/14
 */
public class Chapter1App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter1/application.xml");

        // 获取 对象
        HelloService bean = classPathXmlApplicationContext.getBean(HelloService.class);

        bean.SayHello("张三");

        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
