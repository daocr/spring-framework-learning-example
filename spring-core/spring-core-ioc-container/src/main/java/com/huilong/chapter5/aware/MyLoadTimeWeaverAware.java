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
        log.info("LoadTimeWeaverAware 目前不知道是做什么的 {}", loadTimeWeaver);
    }
}
