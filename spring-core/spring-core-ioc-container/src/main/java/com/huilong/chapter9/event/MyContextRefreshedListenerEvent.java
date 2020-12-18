package com.huilong.chapter9.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 容器刷新事件，可能会触发多次
 *
 * @author daocr
 * @date 2020/12/18
 */
@Component
@Slf4j
public class MyContextRefreshedListenerEvent implements ApplicationListener<ContextRefreshedEvent> {


    /**
     * 出发时机
     *
     * @param event
     * @see AbstractApplicationContext#finishRefresh()
     * @see org.springframework.context.event.SimpleApplicationEventMulticaster#multicastEvent(org.springframework.context.ApplicationEvent, org.springframework.core.ResolvableType)
     */

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("触发容器刷新事件  ContextRefreshedEvent");
    }
}
