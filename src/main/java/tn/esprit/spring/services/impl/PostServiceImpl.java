package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.PostRepository;
import tn.esprit.spring.services.IEmailService;
import tn.esprit.spring.services.IPostService;
import tn.esprit.spring.services.IUserService;

@Service
public class PostServiceImpl implements IPostService {

	private static final Logger l = LogManager.getLogger(PostServiceImpl.class);

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private IEmailService emailService;

	@Autowired
	private IUserService userService;

	@Override
	public List<Post> retrieveAllPosts() {
		// TODO Auto-generated method stub

		List<Post> post = null;
		try {

			l.info("In Method retrieveAllPosts :");
			post = (List<Post>) postRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Post entr : post) {
				l.debug("entr :" + entr.getTitle());
			}
			l.info("Out of Method retrieveAllPosts with Success" + post.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllPosts with Errors : " + e);
		}

		return post;
	}

	@Override
	public Post addPost(Post fo) {
		Post ent = null;

		List<User> users = null;

		String subject = "New Post published : " + fo.getTitle();
		String content = fo.getContent();

		try {
			l.info("Process started");
			users = (List<User>) userService.retrieveAllUsers();

			for (User user : users) {
				emailService.sendSimpleMessage(user.getEmail(), subject, content);
			}

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
	public Post updatePost(Post fo, Long id) {

		Post postUpdated = null;
		try {
			l.info(" Process has started");
			Post post = postRepository.findById(id).get();
			// post.setDescription(fo.getDescription());
			// post.setDateDebut(fo.getDateDebut());
			postUpdated = postRepository.save(post);
			l.info("Post updated");
		} catch (Exception e) {
			l.error("error in updatePost() : " + fo);
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
	
	public int retrieveNbrOfPostsPerDay() {
		int count = 0;
		try {
			l.info("Start process get number of comments today");
			count = postRepository.retrieveNbrOfPostsPerDay();
		} catch (Exception e) {
			l.error("error in retrieveNbrOfCommentsPerDay() : " + e);
		}
		
		return count; 
	}

}
