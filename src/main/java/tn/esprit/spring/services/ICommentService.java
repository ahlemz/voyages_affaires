package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Comment;

public interface ICommentService { 
	 
	List<Comment> retrieveAllComments(); 
	Comment addComment(Comment fo);
	void deleteComment(Long id);
	Comment updateComment(Comment fo);
	Comment retrieveComment(Long id);

} 
