/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-core-sp-el
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.chapter2;

import com.huilong.chapter2.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/**
 * 编译模式 设置
 */
@Slf4j
public class SpElParserConfigurationAppChapter2 {


    public static void main(String[] args) {

        /**
         * @see SpelCompilerMode#OFF 关闭编译
         * @see SpelCompilerMode#IMMEDIATE 尽快编译
         * @see SpelCompilerMode#MIXED 自动选择编译时机
         */
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE,
                SpElParserConfigurationAppChapter2.class.getClassLoader());

        SpelExpressionParser parser = new SpelExpressionParser(config);

        Employee employee = new Employee();
        employee.setName("张三");
        employee.setSalary(1000F);

        for (int i = 0; i < 10000; i++) {
            Expression expr = parser.parseExpression("name");
            Object payload = expr.getValue(employee);
            log.info("name {}", payload);
        }


    }


}