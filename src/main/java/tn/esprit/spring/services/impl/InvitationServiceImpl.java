package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.repositories.InvitationRespository;
import tn.esprit.spring.services.IInvitationService;

@Service
public class InvitationServiceImpl implements IInvitationService {

	private static final Logger l = LogManager.getLogger(InvitationServiceImpl.class);

	

	@Autowired
	private InvitationRespository invitationRepository;

	@Override
	public List<Invitation> retrieveAllInvitations() {
		List<Invitation> invitation=null;
		
		try {
			l.info("In Method retrieveAllInvitations :");
			invitation = (List<Invitation>) invitationRepository.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for (Invitation invi : invitation) {
				l.debug("entr :" + invi.getId() ); 						
		}
			l.info("Out of Method retrieveAllEntreprises with Success" + invitation.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprises with Errors : " + e); 
		}	
		return invitation;
		
		}
	

	@Override
	public void deleteInvitation(Long id) {
		// TODO Auto-generated method stub
		try {
			l.info("Process started");
			invitationRepository.deleteById(id); 
			l.info("deleted invitation"); 
			
		} catch (Exception e) {
			l.error("error in deleteInvitation() : " + e);
		}
			
	}

	@Override
	public Invitation updateInvitation(Invitation invi) {
		// TODO Auto-generated method stub
		Invitation updatedInvitation=null;
		try {
			l.info(" Process has started");
			updatedInvitation = invitationRepository.save(invi); 
			l.info("Invitation updated");
			
		} catch (Exception e) {
			l.error("error in updateInvitation() : " + e);
		}
		
					
		return updatedInvitation;
	}

	@Override
	public Invitation retrieveInvitation(Long id) {
		// TODO Auto-generated method stub
		
		
		Invitation invi = null;
				
		try {
			l.info("Start process");
			invi = invitationRepository.findById(id).get(); 
			l.info("Invitation found");
			
		} catch (Exception e) {
			l.error("error in retrieveInvitation() : " + e);
		}
		
		return invi; 
	}



	@Override
	public Invitation addInvitation(Invitation invi) {
		try {
			l.info("Process started");
			invi = invitationRepository.save(invi); 
			l.info("Saved invitation");
			
		} catch (Exception e) {
			 l.error("error in addInvitation() : " + e);
		}
		
		return invi; 
	}
	
}
