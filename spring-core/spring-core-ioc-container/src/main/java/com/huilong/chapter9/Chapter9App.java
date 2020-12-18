package com.huilong.chapter9;

import com.huilong.chapter9.event.AnnotationListener;
import com.huilong.chapter9.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        ApplicationContext applicationContext = (ApplicationContext) annotationConfigApplicationContext;

        applicationContext.publishEvent(new CustomEvent(new Chapter9App(), "登录"));

        applicationContext.publishEvent(new CustomEvent(new Chapter9App(), "黑名单"));

        AnnotationListener bean = annotationConfigApplicationContext.getBean(AnnotationListener.class);
//        bean.annotationTrigger(new CustomEvent(new Chapter9App(), "黑名单"));
        //停止容器事件
        annotationConfigApplicationContext.stop();

        // 关闭容器
        annotationConfigApplicationContext.close();

    }

}
