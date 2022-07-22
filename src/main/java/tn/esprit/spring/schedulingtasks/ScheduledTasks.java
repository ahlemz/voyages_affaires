package tn.esprit.spring.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.services.ICommentService;

@Component
public class ScheduledTasks {
	
    @Autowired
	private ICommentService commentService;


	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "0 0 23 * * *")
	public void reportCurrentTime() {
		log.info("number of comements today :" + commentService.retrieveNbrOfCommentsPerDay());
	}
}