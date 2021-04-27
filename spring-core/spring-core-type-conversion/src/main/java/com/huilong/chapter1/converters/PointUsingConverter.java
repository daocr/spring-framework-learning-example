/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-type-conversion
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter1.converters;

import com.huilong.chapter1.dto.Point;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

/**
 * 坐标点转换器
 *
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class PointUsingConverter implements Converter<String, Point> {
    @Override
    public Point convert(String source) {

        String[] split = source.split(",");

        Point point = new Point();
        point.setX(Double.valueOf(split[0]));
        point.setY(Double.valueOf(split[1]));

        log.info("调用 PointUsingConverter convert ,before value {} , after value {}", source, point);

        return point;
    }
}
