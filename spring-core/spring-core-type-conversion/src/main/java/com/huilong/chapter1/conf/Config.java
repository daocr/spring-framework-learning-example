/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-type-conversion
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1.conf;

import com.huilong.chapter1.converters.CircleUsingConverterFactory;
import com.huilong.chapter1.converters.PointUsingConverter;
import com.huilong.chapter1.converters.RectangleUsingConditionalConverter;
import com.huilong.chapter1.converters.CylinderUsingGenericConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.HashSet;

/**
 * 配置 bean
 *
 * @author daocr
 * @date 2020/12/23
 */
@Configuration
@Slf4j
public class Config {

    /**
     * 配置  ConversionServiceFactoryBean
     * <p>
     * 可实现的类 {@link org.springframework.core.convert.converter.Converter},
     * {@link org.springframework.core.convert.converter.ConverterFactory},
     * or {@link org.springframework.core.convert.converter.GenericConverter}.
     *
     * @return <p>
     * 加载默认配置
     * @see ConversionServiceFactoryBean#afterPropertiesSet()
     * ↓
     * @see ConversionServiceFactoryBean#createConversionService()
     * ↓
     * @see DefaultConversionService#DefaultConversionService()
     * ↓
     * @see DefaultConversionService#addDefaultConverters(org.springframework.core.convert.converter.ConverterRegistry)
     * <p>
     */
    @Bean
    public ConversionServiceFactoryBean createConversionServiceFactoryBean() {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();

        HashSet<Object> converters = new HashSet<>();

        converters.add(new PointUsingConverter());
        converters.add(new CircleUsingConverterFactory());
        converters.add(new CylinderUsingGenericConverter());
        converters.add(new RectangleUsingConditionalConverter());

        // 添加自定义 转换器
        conversionServiceFactoryBean.setConverters(converters);

        log.info("注册自定义 转换器 成功 ");
        return conversionServiceFactoryBean;
    }
}
