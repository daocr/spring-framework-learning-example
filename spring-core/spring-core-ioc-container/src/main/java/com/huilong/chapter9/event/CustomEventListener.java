package com.huilong.chapter9.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 自定义事件
 *
 * @author daocr
 * @date 2020/12/18
 */
@Slf4j
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info("触发自定义事件 事件名称 ：{} 触发来源：{} ", event.getEventName(), event.getSource());
    }
}
