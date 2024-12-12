package com.example.demo.Emails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String subject, String body){
        SimpleMailMessage mess = new SimpleMailMessage();
        mess.setFrom("vignesh.karimikonda@gmail.com");
        mess.setTo(toEmail);
        mess.setText(body);
        mess.setSubject(subject);
        javaMailSender.send(mess);
        System.out.println("mail sent to " + toEmail);
    }
}
