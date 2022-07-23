package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Statestique;
import tn.esprit.spring.entities.Statestique;
import tn.esprit.spring.repositories.StatestiqueRepository;
import tn.esprit.spring.repositories.StatestiqueRepository;
import tn.esprit.spring.services.IStatestiqueService;


@Service
public class StatestiqueServiceImpl implements IStatestiqueService{
	
	private static final Logger l = LogManager.getLogger(StatestiqueServiceImpl.class);
	
	@Autowired
	private StatestiqueRepository statestiqueRepository;

	@Override
	public List<Statestique> retrieveAllStatestique() {
		// TODO Auto-generated method stub
		
		 
		 List<Statestique> statestique = null; 
			try {
				
				l.info("In Method retrieveAllStatestiques :");
				statestique = (List<Statestique>) statestiqueRepository.findAll(); 
				l.debug("connexion à la DB Ok :"); 
				l.info("Out of Method retrieveAllStatestiques with Success" + statestique.size());
			}catch (Exception e) {
				l.error("Out of Method retrieveAllStatestiques with Errors : " + e); 
			}

			return statestique;
	}

	@Override
	public Statestique addStatestique(Statestique co) {
		// TODO Auto-generated method stub
		
		Statestique ent = null; 
		
		try {
			l.info("Process started");
			ent = statestiqueRepository.save(co); 
			l.info("Saved statestique");
			
		} catch (Exception e) {
			 l.error("error in addStatestique() : " + co);
		}
		
		return ent; 
	}







}
