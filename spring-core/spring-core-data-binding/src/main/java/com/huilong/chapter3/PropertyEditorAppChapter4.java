package com.huilong.chapter3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 代码注册 属性编辑器
 *
 * @author daocr
 * @date 2020/12/23
 * 其他默认属性编辑器参考
 * @see PropertyEditorRegistrySupport#createDefaultEditors()
 */
@Slf4j
public class PropertyEditorAppChapter4 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.huilong.chapter3");
        annotationConfigApplicationContext.refresh();
        // 关闭容器
        annotationConfigApplicationContext.close();

    }
}
