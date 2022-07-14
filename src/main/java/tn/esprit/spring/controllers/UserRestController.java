package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

@RestController
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/retrieve-all-users")
	public List<User> retrieveAllUsers() {
		List<User> list = userService.retrieveAllUsers();
		return list;
	}

	@GetMapping("/retrieve-user/{user-id}")
	public User retrieveUser(@PathVariable("user-id") Long userId) {
		return userService.retrieveUsere(userId);
	}

	@PostMapping("/add-user")
	public User addUser(@RequestBody User u) {
		User user = userService.addUser(u);
		return user;
	}

	@DeleteMapping("/remove-user/{user-id}")
	public void deleteUser(@PathVariable("user-id") Long  userId) {
		userService.deleteUser(userId);
	}

	@PutMapping("/update-user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

}
