package com.huilong.chapter5.converters;

import com.huilong.chapter5.dto.Cylinder;
import com.huilong.chapter5.dto.Rectangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.HashSet;
import java.util.Set;

/**
 * 矩形转换器
 *
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class RectangleUsingConditionalConverter implements ConditionalGenericConverter {

    /**
     * 设置匹配条件
     *
     * @param sourceType
     * @param targetType
     * @return
     */
    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {

        // 获取注解
        // sourceType.getAnnotation()


        log.info(" matches sourceType : {} ,targetType : {}", sourceType, targetType);

        return sourceType.getType() == String.class && targetType.getType() == Rectangle.class;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {

        ConvertiblePair convertiblePair = new ConvertiblePair(String.class, Rectangle.class);
        HashSet<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(convertiblePair);

        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

        String[] split = source.toString().split(",");

        Rectangle rectangle = new Rectangle();
        rectangle.setLength(Double.parseDouble(split[0]));
        rectangle.setWidth(Double.parseDouble(split[1]));

        log.info("调用 RectangleUsingConditionalConverter convert ,before value {} , after value {}", source, rectangle);

        return rectangle;
    }
}
