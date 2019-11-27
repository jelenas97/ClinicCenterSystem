package com.clinicCenter.service.implementation;

import com.clinicCenter.model.User;
import com.clinicCenter.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Override
    @Async
    public void sendNotification(User user) throws MailException, InterruptedException{
        System.out.println("Sending email...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Automated mail");
        mail.setText("This is an automated mail!");
        javaMailSender.send(mail);

        System.out.println("Email sent!");
    }
}
