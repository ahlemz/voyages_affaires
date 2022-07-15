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

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.services.ICommentService;

@RestController
public class CommentRestController {
	
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("/retrieve-all-comments")
	public List<Comment> retrieveAllComments() {
		List<Comment> list = commentService.retrieveAllComments();
		return list;
	}

	@GetMapping("/retrieve-comment/{comment-id}")
	public Comment retrieveComment(@PathVariable("user-id") Long commentId) {
		return commentService.retrieveComment(commentId);
	}

	@PostMapping("/add-comment")
	public Comment addComment(@RequestBody Comment en) {
		Comment comment = commentService.addComment(en);
		return comment;
	}

	@DeleteMapping("/remove-comment/{comment-id}")
	public void deleteComment(@PathVariable("user-id") Long  commentId) {
		commentService.deleteComment(commentId);
	}

	@PutMapping("/update-comment")
	public Comment updateComment(@RequestBody Comment comment) {
		return commentService.updateComment(comment);
	}
	

}
