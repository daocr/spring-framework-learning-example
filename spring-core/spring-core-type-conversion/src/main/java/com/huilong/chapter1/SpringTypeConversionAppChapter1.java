package com.huilong.chapter1;

import com.huilong.chapter1.dto.Point;
import com.huilong.chapter1.dto.Circle;
import com.huilong.chapter1.dto.Cylinder;
import com.huilong.chapter1.dto.Rectangle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

/**
 * @author daocr
 * @date 2020/12/23
 */
@Slf4j
public class SpringTypeConversionAppChapter1 {

    /**
     * 点
     */
    static String point = "116.401682,39.918034";

    /**
     * 圆半径
     */
    static String circle = "15";

    /**
     * 圆柱
     */
    static String cylinder = "15,90";

    /**
     * 矩形
     */
    static String rectangle = "20,20";


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.huilong.chapter5");
        context.refresh();

        ConversionService conversionService = context.getBean(ConversionService.class);

        Point pointConvert = conversionService.convert(point, Point.class);

        Circle circleConvert = conversionService.convert(circle, Circle.class);

        Cylinder cylinderConvert = conversionService.convert(cylinder, Cylinder.class);

        Rectangle rectangleConvert = conversionService.convert(rectangle, Rectangle.class);


        log.info("pointConvert : {}\t circleConvert:{}\t cylinderConvert:{}\t  rectangleConvert:{}"
                , pointConvert, circleConvert, cylinderConvert, rectangleConvert);

        // 关闭容器
        context.close();

    }

    private static void forValueOf(ConversionService conversionService, String point) {
        Object convert1 = conversionService.convert(point, TypeDescriptor.valueOf(String.class), TypeDescriptor.valueOf(Point.class));

        log.info("TypeDescriptor.valueOf  天安门坐标：{}", convert1);
    }


    private static void forObject(ConversionService conversionService, String point) {
        TypeDescriptor typeDescriptor = TypeDescriptor.forObject(new String());

        TypeDescriptor pointDescriptor = TypeDescriptor.forObject(new Point());

        Object convert2 = conversionService.convert(point, typeDescriptor, pointDescriptor);

        log.info("TypeDescriptor.forObject  天安门坐标：{}", convert2);
    }
}
