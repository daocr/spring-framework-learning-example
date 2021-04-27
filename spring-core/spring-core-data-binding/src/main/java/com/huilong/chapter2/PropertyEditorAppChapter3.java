/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-data-binding
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2;

import com.huilong.chapter2.dto.Employee;
import com.huilong.chapter2.editor.MyCustomDateEditor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyEditorRegistrySupport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * xml 注册 属性编辑器
 *
 * @author daocr
 * @date 2020/12/23
 * 其他默认属性编辑器参考
 * @see PropertyEditorRegistrySupport#createDefaultEditors()
 */
@Slf4j
public class PropertyEditorAppChapter3 {


    public static void main(String[] args) {

        //1、 class path  加载配置
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter2/application.xml");

        Employee bean = applicationContext.getBean(Employee.class);

        log.info("Employee bean : {}", bean);

        // BeanWrapper 调用属性编辑器
        beanWrapperRegisterCustomEditor();

        // 关闭容器
        applicationContext.close();

    }

    public static void beanWrapperRegisterCustomEditor() {
        log.info("\n\n-------------- BeanWrapper 设置属性编辑器，并且赋值 -----------------");
        BeanWrapper company = new BeanWrapperImpl(new com.huilong.chapter3.dto.Employee());
        // 设置属性编辑器
        company.registerCustomEditor(Date.class, new MyCustomDateEditor());
        company.setPropertyValue("birthday", "2020-01-12");

    }

}
