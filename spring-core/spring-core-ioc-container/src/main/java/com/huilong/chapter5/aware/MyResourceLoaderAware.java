package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 获取文件资源上下文
 *
 * @author daocr
 * @date 2020/12/14
 */
@Component
@Slf4j
public class MyResourceLoaderAware implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

        log.info("获取资源文件管理上下文成功 {}", resourceLoader);
    }
}
