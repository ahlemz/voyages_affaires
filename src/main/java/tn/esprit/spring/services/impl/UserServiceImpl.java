package tn.esprit.spring.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() {
		 List<User> user = null; 
			try {
				
				l.info("In Method retrieveAllUsers :");
				user = (List<User>) userRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (User u : user) {
					l.debug("User :" + u.getUsername() ); 
				} 
				l.info("Out of Method retrieveAllUsers with Success" + user.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllUsers with Errors : " + e); 
			}

			return user;
	}

	@Override
	public User addUser(User u) {
		User u_saved = null;
		try {
			l.info("In Method addUser:");
			u_saved = userRepository.save(u);
			l.info("Out of Method addUser with Success");
		} catch (Exception e) {
			l.error("Out of Method addUser with Errors: " + e);
		}
		return u_saved;
	}

	@Override
	public void deleteUser(Long id) {
		try {
			l.info("In Method deleteUser:");
			userRepository.deleteById(id);
			l.info("Out of Method deleteUser with Success");
		} catch (Exception e) {
			l.error("Out of Method deleteUser with Errors: " + e);
		}
		
	}

	@Override
	public User updateUser(User u) {
		User u_updated = null;
		try {
			l.info("In Method updateUser:");
			u_updated = userRepository.save(u);
			l.info("Out of Method updateUser with Success");
		} catch (Exception e) {
			l.error("Out of Method updateUser with Errors: " + e);
		}
		return u_updated;
	}

	@Override
	public User retrieveUsere(Long id) {
		User user = null;
		try {
			l.info("In Method retrieveUser:");
			user = userRepository.findById(id).get();
			l.info("Out of Method retrieveUser with Success");
		} catch (Exception e) {
			l.error("Out of Method retrieveUser with Errors: " + e);
		}
		return user;
	}


	
}

