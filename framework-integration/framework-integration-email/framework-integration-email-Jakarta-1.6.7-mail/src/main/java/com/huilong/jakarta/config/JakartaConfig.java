/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-email-Jakarta-1.6.7-mail
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.jakarta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author daocr
 * @date 2021/4/26
 */
@Configuration
public class JakartaConfig {

    @Bean
    public JavaMailSender simpleMailMessage() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(new Properties());
        mailSender.setProtocol("smtp");
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("q873104692@163.com");
        mailSender.setPassword("VCZONHMJRVHQKNCL");
        mailSender.setDefaultEncoding("UTF-8");
        return mailSender;
    }
}
