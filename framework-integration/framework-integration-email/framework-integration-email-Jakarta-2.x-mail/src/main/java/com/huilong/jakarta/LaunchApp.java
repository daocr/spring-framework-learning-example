/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：framework-integration-email-Jakarta-2.x-mail
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.jakarta;

import jakarta.mail.*;
import jakarta.mail.internet.MimeMessage;

import java.util.Date;
import java.util.Properties;


/**
 * Hello world!
 */
public class LaunchApp {
    public static void main(String[] args) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.debug", "true");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("q873104692@163.com");
            msg.setRecipients(Message.RecipientType.TO,
                    "873104692@qq.com");
            msg.setSubject("Jakarta Mail hello world example");
            msg.setSentDate(new Date());
            msg.setText("Hello, world 0001!\n");
            Transport.send(msg, "q873104692", "VCZONHMJRVHQKNCL");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
    }


}
