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

import tn.esprit.spring.entities.Forum;
import tn.esprit.spring.services.IForumService;

@RestController
public class ForumRestController {
	
	
	@Autowired
	private IForumService forumService;
	
	@GetMapping("/retrieve-all-forums")
	public List<Forum> retrieveAllForums() {
		List<Forum> list = forumService.retrieveAllForums();
		return list;
	}

	/*@GetMapping("/retrieve-forum/{forum-id}")
	public Forum retrieveForum(@PathVariable("user-id") Long forumId) {
		return forumService.retrieveForum(forumId);
	}*/

	@PostMapping("/add-forum")
	public Forum addForum(@RequestBody Forum fo) {
		Forum forum = forumService.addForum(fo);
		return forum;
	}

	@DeleteMapping("/remove-forum/{forum-id}")
	public void deleteForum(@PathVariable("user-id") Long  forumId) {
		forumService.deleteForum(forumId);
	}

	@PutMapping("/update-forum")
	public Forum updateForum(@RequestBody Forum forum) {
		return forumService.updateForum(forum);
	}
	

}
