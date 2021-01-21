package com.huilong.chapter5.aware;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * 获取文件资源上下文
 * <p>
 * <p>
 * * 加载原理
 * * <p>
 * * {@link AbstractApplicationContext#refresh()}
 * * <p>
 * * {@link AbstractApplicationContext#prepareBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)}
 * * <p>
 * * {@link  org.springframework.context.support.ApplicationContextAwareProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)}
 * *
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
