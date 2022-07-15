package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repositories.PostRepository;
import tn.esprit.spring.services.IPostService;


@Service
public class PostServiceImpl implements IPostService{
	
	private static final Logger l = LogManager.getLogger(PostServiceImpl.class);
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> retrieveAllPosts() {
		// TODO Auto-generated method stub
		
		 
		 List<Post> post = null; 
			try {
				
				l.info("In Method retrieveAllPosts :");
				post = (List<Post>) postRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Post entr : post) {
					l.debug("entr :" + entr.getTitle() ); 
				} 
				l.info("Out of Method retrieveAllPosts with Success" + post.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllPosts with Errors : " + e); 
			}

			return post;
	}

	@Override
	public Post addPost(Post fo) {
		// TODO Auto-generated method stub
		
		Post ent = null; 
		
		try {
			l.info("Process started");
			ent = postRepository.save(fo); 
			l.info("Saved post");
			
		} catch (Exception e) {
			 l.error("error in addPost() : " + fo);
		}
		
		return ent; 
	}

	@Override
	public void deletePost(Long id) {
		// TODO Auto-generated method stub
		
		try {
			l.info("Process started");
			postRepository.deleteById(id); 
			l.info("deleted post"); 
			
		} catch (Exception e) {
			l.error("error in deletePost() : " + e);
		}
		
	}

	@Override
	public Post updatePost(Post en) {
		Post postUpdated = null; 
		
		try {
			l.info(" Process has started");
			postUpdated = postRepository.save(en); 
			l.info("Post updated");
			
		} catch (Exception e) {
			l.error("error in updatePost() : " + e);
		}
		
		return postUpdated; 
	}

	@Override
	public Post retrievePost(Long id) {
		// TODO Auto-generated method stub
		
		Post entr = null;
			
		try {
			l.info("Start process");
			entr = postRepository.findById(id).get(); 
			l.info("Post found");
			
		} catch (Exception e) {
			l.error("error in retrievePost() : " + e);
		}
		
		return entr; 
	}

}
