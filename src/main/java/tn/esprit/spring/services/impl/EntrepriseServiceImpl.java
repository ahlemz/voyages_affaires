package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repositories.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;


@Service
public class EntrepriseServiceImpl implements IEntrepriseService{
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		// TODO Auto-generated method stub
		
		 
		 List<Entreprise> entreprise = null; 
			try {
				
				l.info("In Method retrieveAllEntreprises :");
				entreprise = (List<Entreprise>) entrepriseRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				for (Entreprise entr : entreprise) {
					l.debug("entr :" + entr.getName() ); 
				} 
				l.info("Out of Method retrieveAllEntreprises with Success" + entreprise.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllEntreprises with Errors : " + e); 
			}

			return entreprise;
	}

	@Override
	public Entreprise addEntreprise(Entreprise en) {
		// TODO Auto-generated method stub
		
		Entreprise ent = null; 
		
		try {
			l.info("Process started");
			ent = entrepriseRepository.save(en); 
			l.info("Saved entreprise");
			
		} catch (Exception e) {
			 l.error("error in addEntreprise() : " + e);
		}
		
		return ent; 
	}

	@Override
	public void deleteEntreprise(Long id) {
		// TODO Auto-generated method stub
		
		try {
			l.info("Process started");
			entrepriseRepository.deleteById(id); 
			l.info("deleted entreprise"); 
			
		} catch (Exception e) {
			l.error("error in deleteEntreprise() : " + e);
		}
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise en) {
		Entreprise entrepriseUpdated = null; 
		
		try {
			l.info(" Process has started");
			entrepriseUpdated = entrepriseRepository.save(en); 
			l.info("Entreprise updated");
			
		} catch (Exception e) {
			l.error("error in updateEntreprise() : " + e);
		}
		
		return entrepriseUpdated; 
	}

	@Override
	public Entreprise retrieveEntreprise(Long id) {
		// TODO Auto-generated method stub
		
		Entreprise entr = null;
			
		try {
			l.info("Start process");
			entr = entrepriseRepository.findById(id).get(); 
			l.info("Entreprise found");
			
		} catch (Exception e) {
			l.error("error in retrieveEntreprise() : " + e);
		}
		
		return entr; 
	}

}
