package com.huilong.chapter5.converters;

import com.huilong.chapter5.dto.Circle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * 转换
 *
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class CircleUsingConverterFactory implements ConverterFactory<String, Circle> {


    @Override
    public <T extends Circle> Converter<String, T> getConverter(Class<T> targetType) {


        Converter<String, T> converter = new Converter<String, T>() {
            @Override
            public T convert(String source) {

                Circle circle = new Circle();
                circle.setRadius(Double.valueOf(source));

                log.info("调用 CircleUsingConverterFactory convert ,before value {} , after value {}", source, circle);
                return (T) circle;
            }
        };


        return converter;
    }
}
