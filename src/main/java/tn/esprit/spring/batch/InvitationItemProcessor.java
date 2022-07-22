package tn.esprit.spring.batch;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import tn.esprit.spring.entities.Invitation;

public class InvitationItemProcessor implements ItemProcessor<Invitation, Invitation>{
	private static final Logger log = LoggerFactory.getLogger(InvitationItemProcessor.class);

	
	public Invitation process(final Invitation invi) throws Exception {
		final Long id= invi.getId();
		final Date date_Invitation = invi.getDateInvitation();
		final String confirmation = invi.getConfirmation();
		final String answer= invi.getAnswer();
		final String description=invi.getDescription();

		final Invitation transformedInvitation = new Invitation(id,date_Invitation, confirmation,answer,description);

		log.info("Converting (" + invi + ") into (" + transformedInvitation + ")");

		return transformedInvitation;
	}
	/*	id	answer	confirmation	date_invitation	description
 */ 

}
