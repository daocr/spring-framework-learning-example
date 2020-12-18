package com.huilong.chapter9;

import com.huilong.chapter9.event.CustomEvent;
import com.huilong.chapter9.service.impl.MyApplicationEventPublisherAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 环境隔离
 *
 * @author daocr
 * @date 2020/12/14
 */
@Slf4j
public class Chapter9App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.scan("com.huilong.chapter9");


        annotationConfigApplicationContext.refresh();

        // 启动容器
        annotationConfigApplicationContext.start();

        MyApplicationEventPublisherAware myApplicationEventPublisherAware = annotationConfigApplicationContext.getBean(MyApplicationEventPublisherAware.class);

        myApplicationEventPublisherAware.trigger(new CustomEvent(new Chapter9App(), "登录"));

        //停止容器事件
        annotationConfigApplicationContext.stop();

        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
