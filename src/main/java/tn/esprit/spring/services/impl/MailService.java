package tn.esprit.spring.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Partner;



/**
 * 
 * @author Ayoub BEN AZIZA
 *
 */
@Service
public class MailService {

	/*
	 * The Spring Framework provides an easy abstraction for sending email by using
	 * the JavaMailSender interface, and Spring Boot provides auto-configuration for
	 * it as well as a starter module.
	 */
	private JavaMailSender javaMailSender;

	/**
	 * 
	 * @param javaMailSender
	 */
	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * This function is used to send mail without attachment.
	 * @param user
	 * @throws MailException
	 */

	public void sendEmail(Partner patner) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
		 * JavaMailSender extends the MailSender Interface which contains send()
		 * function. SimpleMailMessage Object is required because send() function uses
		 * object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(patner.getEmail());
		mail.setSubject("Testing Mail API");
		mail.setText("Hurray ! You have done that dude...");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}


	

}