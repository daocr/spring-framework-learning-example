package com.huilong.chapter6.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author daocr
 * @date 2020/12/14
 */
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
