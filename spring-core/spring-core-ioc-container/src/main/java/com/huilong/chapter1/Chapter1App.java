package com.huilong.chapter1;

import com.huilong.chapter1.service.Chapter1Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 初始化  spring  容器
 *
 * @author daocr
 * @date 2020/12/14
 */
public class Chapter1App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter1/application.xml");

        Chapter1Service bean = applicationContext.getBean(Chapter1Service.class);

        bean.SayHello("张三");
    }

}
