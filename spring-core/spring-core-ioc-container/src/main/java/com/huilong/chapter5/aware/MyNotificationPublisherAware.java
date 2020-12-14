package com.huilong.chapter5.aware;

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
public class MyNotificationPublisherAware implements NotificationPublisherAware {
    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {

    }
}
