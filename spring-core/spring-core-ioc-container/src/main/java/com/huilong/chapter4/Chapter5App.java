package com.huilong.chapter4;

import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter5App {

    public static void main(String[] args) {

        // 加载配置
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("chapter4/application$1.xml");

        // 获取 对象
        HelloService helloService = classPathXmlApplicationContext.getBean(HelloService.class);
        helloService.SayHello("张三");


        // 关闭容器
        classPathXmlApplicationContext.close();

    }

}
