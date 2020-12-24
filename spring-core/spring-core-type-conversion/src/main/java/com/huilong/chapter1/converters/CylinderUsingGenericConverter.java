package com.huilong.chapter1.converters;

import com.huilong.chapter1.dto.Cylinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.HashSet;
import java.util.Set;

/**
 * 圆柱转换器
 *
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class CylinderUsingGenericConverter implements GenericConverter {
    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {

        ConvertiblePair convertiblePair = new ConvertiblePair(String.class, Cylinder.class);
        HashSet<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(convertiblePair);

        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {

        String[] split = source.toString().split(",");

        Cylinder cylinder = new Cylinder();
        cylinder.setHeight(Double.parseDouble(split[0]));
        cylinder.setRadius(Double.parseDouble(split[1]));

        log.info("调用 CylinderUsingGenericConverter  ,before value {} , after value {}", source, cylinder);

        return cylinder;

    }
}
