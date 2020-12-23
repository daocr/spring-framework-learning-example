package com.huilong.chapter5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class SpringTypeConversionAppChapter5 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.huilong.chapter4");
        annotationConfigApplicationContext.refresh();
        // 关闭容器
        annotationConfigApplicationContext.close();

    }
}
