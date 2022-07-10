package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repositories.EmployeRepository;
import tn.esprit.spring.services.IEmployeService;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public List<Employe> retrieveAllEmployes() {
		List<Employe> employes = null;
		try {
			l.info("In Method retrieveAllEmployes:");
			employes = (List<Employe>) employeRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Employe Employe : employes) {
				l.debug("Employe :" + Employe.getNom());
			}
			l.info("Out of Method retrieveAllEmployes with Success" + employes.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllEmployes with Errors: " + e);
		}
		return employes;
	}

	@Override
	public Employe addEmploye(Employe employe) {
		Employe e_saved = null;
		try {
			l.info("In Method addEmploye:");
			e_saved = employeRepository.save(employe);
			l.info("Out of Method addEmploye with Success");
		} catch (Exception e) {
			l.error("Out of Method addEmploye with Errors: " + e);
		}
		return e_saved;
	}

	@Override
	public Employe updateEmploye(Employe employe) {
		Employe e_updated = null;
		try {
			l.info("In Method updateEmploye:");
			e_updated = employeRepository.save(employe);
			l.info("Out of Method updateEmploye with Success");
		} catch (Exception e) {
			l.error("Out of Method updateEmploye with Errors: " + e);
		}
		return e_updated;
	}

	@Override
	public void deleteEmploye(Long id) {
		try {
			l.info("In Method deleteEmploye:");
			employeRepository.deleteById(id);
			l.info("Out of Method deleteEmploye with Success");
		} catch (Exception e) {
			l.error("Out of Method deleteEmploye with Errors: " + e);
		}
	}

	@Override
	public Employe retrieveEmploye(Long id) {
		Employe employe = null;
		try {
			l.info("In Method retrieveEmploye:");
			employe = employeRepository.findById(id).get();
			l.info("Out of Method retrieveEmploye with Success");
		} catch (Exception e) {
			l.error("Out of Method retrieveEmploye with Errors: " + e);
		}
		return employe;
	}

}