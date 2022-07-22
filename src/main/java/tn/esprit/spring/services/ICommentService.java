package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;

public interface ICommentService { 
	 
	List<Comment> retrieveAllComments(); 
	Comment addComment(Comment co);
	void deleteComment(Long id);
	Comment updateComment(Comment co,Long id);
	Comment retrieveComment(Long id);
	int retrieveNbrOfCommentsPerDay();

} 
