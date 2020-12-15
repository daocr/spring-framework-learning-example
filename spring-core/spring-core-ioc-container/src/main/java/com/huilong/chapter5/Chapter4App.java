package com.huilong.chapter5;

import com.huilong.chapter4.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter4App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter5");

        annotationConfigApplicationContext.refresh();


        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
