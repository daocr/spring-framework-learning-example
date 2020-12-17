package com.huilong.chapter5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 依赖注入
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter5App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter5");

        annotationConfigApplicationContext.refresh();

        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
