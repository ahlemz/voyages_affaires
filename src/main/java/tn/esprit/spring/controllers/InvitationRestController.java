package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.Invitation;
import tn.esprit.spring.services.IInvitationService;



@RestController
public class InvitationRestController {

	@Autowired
	private IInvitationService invitationService;
	
	@GetMapping("/retrieve-all-invitations")
	public List<Invitation> retrieveAllInvitation() {
		List<Invitation> list = invitationService.retrieveAllInvitations();
		return list;
	}
	
	@GetMapping("/retrieve-invitation/{invitation-id}")
	public Invitation retrieveInvitation(@PathVariable("invitation-id") Long invitationId) {
		return invitationService.retrieveInvitation(invitationId);
	}

	@PostMapping("/add-invitation")
	public Invitation addInvitation(@RequestBody Invitation invi) {
		Invitation invitation = invitationService.addInvitation(invi);
		return invitation;
	}
	
	
	
	@DeleteMapping("/remove-invitation/{invitation-id}")
	public void deleteInvitation(@PathVariable("invitation-id") Long  invitationId) {
		invitationService.deleteInvitation(invitationId);
	}

	@PutMapping("/update-invitation")
	public Invitation updateInvitation(@RequestBody Invitation invitation) {
		return invitationService.updateInvitation(invitation);
	}
	


}
