package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.repositories.CommentRepository;
import tn.esprit.spring.services.ICommentService;


@Service
public class CommentServiceImpl implements ICommentService{
	
	private static final Logger l = LogManager.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> retrieveAllComments() {
		// TODO Auto-generated method stub
		
		 
		 List<Comment> comment = null; 
			try {
				
				l.info("In Method retrieveAllComments :");
				comment = (List<Comment>) commentRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Comment entr : comment) {
					l.debug("entr :" + entr.getComment() ); 
				} 
				l.info("Out of Method retrieveAllComments with Success" + comment.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllComments with Errors : " + e); 
			}

			return comment;
	}

	@Override
	public Comment addComment(Comment co) {
		// TODO Auto-generated method stub
		
		Comment ent = null; 
		
		try {
			l.info("Process started");
			ent = commentRepository.save(co); 
			l.info("Saved comment");
			
		} catch (Exception e) {
			 l.error("error in addComment() : " + co);
		}
		
		return ent; 
	}

	@Override
	public void deleteComment(Long id) {
		// TODO Auto-generated method stub
		
		try {
			l.info("Process started");
			commentRepository.deleteById(id); 
			l.info("deleted comment"); 
			
		} catch (Exception e) {
			l.error("error in deleteComment() : " + e);
		}
		
	}

	@Override
	public Comment updateComment(Comment co, Long id) {
		
		Comment commentUpdated = null;
		try {
			l.info(" Process has started");
			Comment comment = commentRepository.findById(id).get();
			//comment.setDescription(co.getDescription());
			//comment.setDateDebut(fo.getDateDebut());
		    commentUpdated = commentRepository.save(comment);
			l.info("Comment updated");
		} catch (Exception e) {
			l.error("error in updateComment() : " + co);
		}
		
		return commentUpdated; 
	}


	@Override
	public Comment retrieveComment(Long id) {
		// TODO Auto-generated method stub
		
		Comment entr = null;
			
		try {
			l.info("Start process");
			entr = commentRepository.findById(id).get(); 
			l.info("Comment found");
			
		} catch (Exception e) {
			l.error("error in retrieveComment() : " + e);
		}
		
		return entr; 
	}

	public int retrieveNbrOfCommentsPerDay() {
		int count = 0;
		try {
			l.info("Start process get number of comments today");
			count = commentRepository.retrieveNbrOfCommentsPerDay();
		} catch (Exception e) {
			l.error("error in retrieveNbrOfCommentsPerDay() : " + e);
		}
		
		return count; 
	}
}
