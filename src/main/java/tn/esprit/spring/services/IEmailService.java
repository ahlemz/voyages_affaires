package tn.esprit.spring.services;


public interface IEmailService {

	public void sendSimpleMessage(String to, String subject, String text);

}
