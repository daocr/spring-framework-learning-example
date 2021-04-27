/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-data-binding
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
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
