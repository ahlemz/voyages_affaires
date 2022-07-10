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

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RestController
public class EntrepriseRestController {
	
	
	@Autowired
	private IEntrepriseService entrepriseService;
	
	@GetMapping("/retrieve-all-entreprises")
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> list = entrepriseService.retrieveAllEntreprises();
		return list;
	}

	@GetMapping("/retrieve-entreprise/{entreprise-id}")
	public Entreprise retrieveEntreprise(@PathVariable("employe-id") Long entrepriseId) {
		return entrepriseService.retrieveEntreprise(entrepriseId);
	}

	@PostMapping("/add-entreprise")
	public Entreprise addEntreprise(@RequestBody Entreprise en) {
		Entreprise entreprise = entrepriseService.addEntreprise(en);
		return entreprise;
	}

	@DeleteMapping("/remove-entreprise/{entreprise-id}")
	public void deleteEntreprise(@PathVariable("employe-id") Long  entrepriseId) {
		entrepriseService.deleteEntreprise(entrepriseId);
	}

	@PutMapping("/update-entreprise")
	public Entreprise updateEntreprise(@RequestBody Entreprise entreprise) {
		return entrepriseService.updateEntreprise(entreprise);
	}
	

}
