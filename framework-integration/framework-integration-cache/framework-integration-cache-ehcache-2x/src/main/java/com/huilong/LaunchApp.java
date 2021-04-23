package com.huilong;


import com.huilong.ehcache2.model.param.StaffParam;
import com.huilong.ehcache2.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


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

        /**
         * 模拟并发查询
         * 解决 缓存击穿 问题
         */
//        mockConcurrentQuery(helloService);

        /**
         * 模拟并发查询
         * <p>
         * ps 出现多次查询成功，是因为出现了缓存击穿 问题，
         */
        mockConcurrentQueryLock(helloService);

        // 关闭容器
        applicationContext.close();

    }


    /**
     * 模拟并发查询
     * 解决 缓存击穿 问题
     *
     * @param helloService
     */
    private static void mockConcurrentQuery(HelloService helloService) {

        AtomicInteger cut = new AtomicInteger();
        // 并发查询
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                int i1 = cut.incrementAndGet();
                log.info("线程：{} 第{}次调用！", Thread.currentThread().getName(), i1);
                StaffParam staffParam = new StaffParam();
                staffParam.setName("张三");
                helloService.findStaff(staffParam);

            });
        }
    }


    /**
     * 模拟并发查询
     * <p>
     * ps 出现多次查询成功，是因为出现了缓存击穿 问题，
     *
     * @param helloService
     */
    private static void mockConcurrentQueryLock(HelloService helloService) {

        AtomicInteger cut = new AtomicInteger();
        // 并发查询
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {

                int i1 = cut.incrementAndGet();
                log.info("线程：{} 第{}次调用！", Thread.currentThread().getName(), i1);
                StaffParam staffParam = new StaffParam();
                staffParam.setName("张三");
                helloService.findStaffLock(staffParam);

            });
        }
    }
}
