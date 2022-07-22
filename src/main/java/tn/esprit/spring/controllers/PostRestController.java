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

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.services.IEmailService;
import tn.esprit.spring.services.IPostService;

@RestController
public class PostRestController {
	
	
	@Autowired
	private IPostService postService;

	
	@GetMapping("/retrieve-all-posts")
	public List<Post> retrieveAllPosts() {
		List<Post> list = postService.retrieveAllPosts();
		return list;
	}

	/*@GetMapping("/retrieve-post/{post-id}")
	public Post retrievePost(@PathVariable("user-id") Long postId) {
		return postService.retrievePost(postId);
	}*/

	@PostMapping("/add-post")
	public Post addPost(@RequestBody Post po) {
		Post post = postService.addPost(po);
		return post;
	}

	@DeleteMapping("/remove-post/{post-id}")
	public void deletePost(@PathVariable("post-id") Long  postId) {
		postService.deletePost(postId);
	}
	

	

	
	@PutMapping("/update-post/{post-id}")
	public Post updatePost(@RequestBody Post post ,@PathVariable("post-id") Long  postId) {
		return postService.updatePost(post, postId);
	}
	

}
