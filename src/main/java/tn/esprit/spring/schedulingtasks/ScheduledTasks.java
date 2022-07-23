package tn.esprit.spring.schedulingtasks;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Statestique;
import tn.esprit.spring.services.ICommentService;
import tn.esprit.spring.services.IPostService;
import tn.esprit.spring.services.IStatestiqueService;

@Component
public class ScheduledTasks {
	
    @Autowired
	private ICommentService commentService;
    
    @Autowired
	private IPostService postService;
    
    @Autowired
	private IStatestiqueService statestiqueService;


	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "40 56 0 * * *")
	public void reportComments() {
		log.info("number of comements today :" + commentService.retrieveNbrOfCommentsPerDay());
		Date now = new Date();
		Statestique stat = new Statestique(now,"Comments",commentService.retrieveNbrOfCommentsPerDay());
		statestiqueService.addStatestique(stat);
	}
	
	@Scheduled(cron = "0 6 1 * * *")
	public void reportPosts() {
		log.info("number of posts today :" + postService.retrieveNbrOfPostsPerDay());
		Date now = new Date();
		Statestique stat = new Statestique(now,"Posts",postService.retrieveNbrOfPostsPerDay());
		statestiqueService.addStatestique(stat);
	}
}