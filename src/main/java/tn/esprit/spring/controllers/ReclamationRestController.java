package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IReclamationService;
import tn.esprit.spring.services.IUserService;

@RestController
public class ReclamationRestController {

	@Autowired
	private IReclamationService reclamationService;
	@Autowired
	private IUserService iUserService;

	@RequestMapping("/reclamations")
	public List<Reclamation> getReclamation() {
		List<Reclamation> reclamations = reclamationService.retrieveAllReclamation();
		return reclamations;
	}

	@RequestMapping(value = "/reclamation/delete")
	public String deleteReclamation(@RequestParam(name = "id") Long id) {
		reclamationService.deleteReclamation(id);
		return "id " + id + " est supprimé";
	}

	@RequestMapping(value = { "/reclamation/add" }, method = RequestMethod.POST)
	public String addReclamation(@Validated @RequestBody Reclamation reclamation) {
		reclamationService.addReclamtion(reclamation);
		return "reclamation ajouté avec succes";
	}

	@RequestMapping(value = { "/reclamation/update" }, method = RequestMethod.PUT)
	public String updateReclamation(@Validated @RequestBody Reclamation reclamation) {
		reclamationService.updateReclamation(reclamation);
		return "reclamation modifié avec succes";
	}

	@RequestMapping(value = "/reclamation/findById")
	public Reclamation getReclamationById(@RequestParam(name = "id") Long id) {
		return reclamationService.retrieveReclamation(id);

	}

	@RequestMapping(value = "/reclamation/findByUser")
	public List<Reclamation> getReclamationByUser(@RequestParam(name = "id") Long id) {
		User user = iUserService.retrieveUsere(id);

		return reclamationService.getReclamationByUser(user);

	}

}