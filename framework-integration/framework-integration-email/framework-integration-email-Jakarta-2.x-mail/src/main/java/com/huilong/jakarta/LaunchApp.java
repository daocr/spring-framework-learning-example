package com.huilong.jakarta;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 */
public class LaunchApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.huilong");
        applicationContext.refresh();

        JavaMailSender javaMailSender = applicationContext.getBean(JavaMailSender.class);

        sendMsg(javaMailSender);


        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setSender("**@qq.com");
                mimeMessage.setFrom("**@163.com");

            }
        };



        // 关闭容器
        applicationContext.close();
    }

    /**
     * 发送普通 email
     *
     * @param javaMailSender
     */
    private static void sendMsg(JavaMailSender javaMailSender) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("我是标题");
        simpleMailMessage.setText("我是测试内容");
        simpleMailMessage.setTo("**@qq.com");
        simpleMailMessage.setFrom("**@163.com");
        javaMailSender.send(simpleMailMessage);
    }





}
