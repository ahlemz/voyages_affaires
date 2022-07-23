package tn.esprit.spring.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.payload.PdfUserGenerator;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/auth")
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

	@PostMapping("/signup")
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
	
	@GetMapping("/users/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<User> listUsers = userService.retrieveAllUsers();

		System.out.println(listUsers.toString());

		PdfUserGenerator exporter = new PdfUserGenerator(userService.retrieveAllUsers());
		exporter.export(response);

	}

}
