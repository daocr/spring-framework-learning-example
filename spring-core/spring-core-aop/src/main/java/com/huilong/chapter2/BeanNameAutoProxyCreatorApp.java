package com.huilong.chapter2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动创建代理
 *
 * @author daocr
 * @date 2021/1/8
 */
public class BeanNameAutoProxyCreatorApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.huilong.chapter2");






        context.refresh();
        // 关闭容器
        context.close();

    }
}
