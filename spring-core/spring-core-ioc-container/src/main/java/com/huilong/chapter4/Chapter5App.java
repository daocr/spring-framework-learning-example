package com.huilong.chapter4;

import com.huilong.chapter4.service.HelloService4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 生命周期
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter5App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter4/application.xml");

        // 获取 对象
        HelloService4 helloService = classPathXmlApplicationContext.getBean(HelloService4.class);
        helloService.SayHello("张三");


        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
