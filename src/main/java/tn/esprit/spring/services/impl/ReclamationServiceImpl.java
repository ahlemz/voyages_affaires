package tn.esprit.spring.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ReclamationRepository;
import tn.esprit.spring.services.IReclamationService;

@Service
public class ReclamationServiceImpl implements IReclamationService {

	private static final Logger l = LogManager.getLogger(ReclamationServiceImpl.class);

	@Autowired
	private ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> retrieveAllReclamation() {
		List<Reclamation> reclamations = new ArrayList<Reclamation>();
		try {

			l.info("In Method retrieveAllReclamation :");
			reclamations = (List<Reclamation>) reclamationRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Reclamation recl : reclamations) {
				recl.getUser();
				l.debug("User :" );
			}
			l.info("Out of Method retrieveAllReclamations with Success" + reclamations.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllReclamations with Errors : " + e);
		}

		return reclamations;
	}

	@Override
	public Reclamation updateReclamation(Reclamation recl) {
		Reclamation reclamation = null;

		try {
			l.info(" Process has started");
			reclamation = reclamationRepository.save(recl);

		} catch (Exception e) {
			l.error("error in updateReclamation() : " + e);
		}
		return reclamation;

	}

	@Override
	public Reclamation retrieveReclamation(Long id) {
		Reclamation reclamation = null;
		try {
			l.info("In Method retrieveReclamation:");
			Optional<Reclamation> optional = reclamationRepository.findById(id);
			if (optional.isPresent()) {
				reclamation = optional.get();
			}

			l.info("Out of Method retrieveReclamation with Success");
		} catch (Exception e) {
			l.error("Out of Method retrieveReclamation with Errors: " + e);
		}
		return reclamation;
	}

	@Override
	public Reclamation addReclamtion(Reclamation recl) {
		// TODO Auto-generated method stub

		Reclamation reclamation = null;
		try {
			l.info("Process started");
			reclamation = reclamationRepository.save(recl);
			l.info("Saved reclamation");

		} catch (Exception e) {
			l.error("error in addPost() : " + recl);
		}

		return reclamation;

	}

	@Override
	public void deleteReclamation(Long id) {
		// TODO Auto-generated method stub

		try {
			l.info("In Method deleteReclamation:");
			reclamationRepository.deleteById(id);
			l.info("Out of Method deleteReclamaion with Success");
		} catch (Exception e) {
			l.error("Out of Method deleteReclamation with Errors: " + e);
		}

	}

	@Override
	public List<Reclamation> getReclamationByUser(User user) {
		List<Reclamation> collection = new ArrayList<>();
		try {
			collection = reclamationRepository.findByReclamant(user);
		} catch (Exception e) {
			l.error("Out of Method deleteReclamation with Errors: " + e);
		}

		return collection;
	}
}