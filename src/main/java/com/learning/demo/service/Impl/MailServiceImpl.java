package com.learning.demo.service.Impl;

import com.learning.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender sender;

    @Override
    public void sendSimpleMail(String from,String to, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("欢迎加入党团学新xx部门！");
        message.setText(content);
    }
}
