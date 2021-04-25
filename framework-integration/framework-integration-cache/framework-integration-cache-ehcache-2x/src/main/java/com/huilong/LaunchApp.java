package com.huilong;


import com.huilong.ehcache2.model.param.StaffParam;
import com.huilong.ehcache2.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 */
@Slf4j
public class LaunchApp {

    // 线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong");
        applicationContext.refresh();

        HelloService helloService = applicationContext.getBean(HelloService.class);
        StaffParam staffParam = new StaffParam();
        staffParam.setName("张三");

        for (int i = 0; i < 10; i++) {
            log.info("第 {} 次调用", i + 1);
            helloService.findStaff(staffParam);
        }

        // 关闭容器
        applicationContext.close();

    }


}
