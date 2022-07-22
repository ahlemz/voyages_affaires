package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;


public interface IReclamationService { 
	 
	List<Reclamation> retrieveAllReclamation(); 
	Reclamation addReclamtion(Reclamation recl);
	void deleteReclamation(Long id);
	Reclamation updateReclamation(Reclamation recl);
	Reclamation retrieveReclamation(Long id);
	List<Reclamation> getReclamationByUser(User user);

} 