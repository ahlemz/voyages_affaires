package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;

public interface IEmailService {

	public void sendSimpleMessage(String to, String subject, String text);

}
