package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Post;

public interface IPostService { 
	 
	List<Post> retrieveAllPosts(); 
	Post addPost(Post po);
	void deletePost(Long id);
	Post updatePost(Post po,Long id);
	Post retrievePost(Long id);

} 
