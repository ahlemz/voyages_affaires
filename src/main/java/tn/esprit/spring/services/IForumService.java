package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Forum;

public interface IForumService { 
	 
	List<Forum> retrieveAllForums(); 
	Forum addForum(Forum fo);
	void deleteForum(Long id);
	Forum updateForum(Forum fo);
	Forum retrieveForum(Long id);

} 
