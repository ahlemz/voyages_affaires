package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.repositories.CommentRepository;
import tn.esprit.spring.services.ICommentService;
import tn.esprit.spring.services.IEmailService;


@Component
public class EmailServiceImpl implements IEmailService{
	
    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("ahlem.zouaghi@esprit.tn");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
        
    }

}
