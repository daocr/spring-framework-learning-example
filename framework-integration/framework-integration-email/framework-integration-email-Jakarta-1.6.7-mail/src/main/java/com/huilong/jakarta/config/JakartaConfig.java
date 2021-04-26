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
        mailSender.setUsername("**@163.com");
        mailSender.setPassword("**");
        mailSender.setDefaultEncoding("UTF-8");
        return mailSender;
    }
}
