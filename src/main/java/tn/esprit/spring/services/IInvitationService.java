package tn.esprit.spring.services;


import java.util.List;


import tn.esprit.spring.entities.Invitation;

public interface IInvitationService {

	
	List<Invitation> retrieveAllInvitations();
	Invitation addInvitation(Invitation invi);
	void deleteInvitation(Long id);
	Invitation updateInvitation(Invitation invi);
	Invitation retrieveInvitation(Long id);
	
}
