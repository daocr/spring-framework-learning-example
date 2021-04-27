/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-ioc-container
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

/**
 * jmx
 *
 * @author daocr
 * @date 2020/12/14
 */
@Component
@Slf4j
public class MyNotificationPublisherAware implements NotificationPublisherAware {
    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        log.info("获取 jmx 通知上下文成功 {}", notificationPublisher);
    }
}
