package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;

/**
 * @author daocr
 * @date 2020/12/14
 */
@Component
@Slf4j
public class MyLoadTimeWeaverAware implements LoadTimeWeaverAware {

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        log.info("LoadTimeWeaverAware 目前不知道是做什么的");
    }
}
