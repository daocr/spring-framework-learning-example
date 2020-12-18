package com.huilong.chapter6;

import com.huilong.chapter6.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * processor 相关接口实现
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter6App {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter6");

        annotationConfigApplicationContext.refresh();

        HelloService helloService
                = annotationConfigApplicationContext.getBean(HelloService.class);

        helloService.SayHello("李四");


        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
