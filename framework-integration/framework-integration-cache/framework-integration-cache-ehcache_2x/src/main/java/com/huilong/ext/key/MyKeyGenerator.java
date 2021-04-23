package com.huilong.ext.key;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 缓存 名称 生成 策略
 *
 * @author daocr
 * @date 2021/4/23
 */
@Component("myKeyGenerator")
public class MyKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object o, Method method, Object... objects) {
        return null;
    }
}
