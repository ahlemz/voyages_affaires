package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Forum;
import tn.esprit.spring.repositories.ForumRepository;
import tn.esprit.spring.services.IForumService;


@Service
public class ForumServiceImpl implements IForumService{
	
	private static final Logger l = LogManager.getLogger(ForumServiceImpl.class);
	
	@Autowired
	private ForumRepository forumRepository;

	@Override
	public List<Forum> retrieveAllForums() {
		// TODO Auto-generated method stub
		
		 
		 List<Forum> forum = null; 
			try {
				
				l.info("In Method retrieveAllForums :");
				forum = (List<Forum>) forumRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Forum entr : forum) {
					l.debug("entr :" + entr.getDescription() ); 
				} 
				l.info("Out of Method retrieveAllForums with Success" + forum.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllForums with Errors : " + e); 
			}

			return forum;
	}

	@Override
	public Forum addForum(Forum fo) {
		// TODO Auto-generated method stub
		
		Forum ent = null; 
		
		try {
			l.info("Process started");
			ent = forumRepository.save(fo); 
			l.info("Saved forum");
			
		} catch (Exception e) {
			 l.error("error in addForum() : " + fo);
		}
		
		return ent; 
	}

	@Override
	public void deleteForum(Long id) {
		// TODO Auto-generated method stub
		
		try {
			l.info("Process started");
			forumRepository.deleteById(id); 
			l.info("deleted forum"); 
			
		} catch (Exception e) {
			l.error("error in deleteForum() : " + e);
		}
		
	}

	@Override
	public Forum updateForum(Forum en) {
		Forum forumUpdated = null; 
		
		try {
			l.info(" Process has started");
			forumUpdated = forumRepository.save(en); 
			l.info("Forum updated");
			
		} catch (Exception e) {
			l.error("error in updateForum() : " + e);
		}
		
		return forumUpdated; 
	}

	@Override
	public Forum retrieveForum(Long id) {
		// TODO Auto-generated method stub
		
		Forum entr = null;
			
		try {
			l.info("Start process");
			entr = forumRepository.findById(id).get(); 
			l.info("Forum found");
			
		} catch (Exception e) {
			l.error("error in retrieveForum() : " + e);
		}
		
		return entr; 
	}

}
