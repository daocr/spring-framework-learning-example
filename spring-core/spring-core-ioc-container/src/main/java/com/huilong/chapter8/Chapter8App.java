package com.huilong.chapter8;

import com.huilong.chapter7.service.CityService7;
import com.huilong.chapter7.service.DistrictService7;
import com.huilong.chapter7.service.impl.CityService7Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 依赖注入
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter8App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter8");

        annotationConfigApplicationContext.refresh();



        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
