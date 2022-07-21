package tn.esprit.spring.controllers;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Partner;
import tn.esprit.spring.services.impl.MailService;


/**
 * This class contains a Mail API developed using Spring Boot
 * 
 * @author Ayoub Ben Aziza
 *
 */
@RestController
public class NotificationController {

	@Autowired
	private MailService notificationService;

	@Autowired
	private Partner partner;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("send-mail")
	public String send() {

		/*
		 * Creating a User with the help of User class that we have declared and setting
		 * Email address of the sender.
		 */
		partner.setEmail("ayoub.benaziza@esprit.tn");  //Receiver's email address
		/*
		 * Here we will call sendEmail() for Sending mail to the sender.
		 */
		try {
			notificationService.sendEmail(partner);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}

	
}