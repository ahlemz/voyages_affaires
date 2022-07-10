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

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@RestController
public class EmployeRestController {

	@Autowired
	private IEmployeService iEmployeService;

	@GetMapping("/retrieve-all-employes")
	public List<Employe> retrieveAllEmployes() {
		List<Employe> list = iEmployeService.retrieveAllEmployes();
		return list;
	}

	@GetMapping("/retrieve-employe/{employe-id}")
	public Employe retrieveEmploye(@PathVariable("employe-id") Long employeId) {
		return iEmployeService.retrieveEmploye(employeId);
	}

	@PostMapping("/add-employe")
	public Employe addEmploye(@RequestBody Employe e) {
		Employe Employe = iEmployeService.addEmploye(e);
		return Employe;
	}

	@DeleteMapping("/remove-employe/{employe-id}")
	public void removeEmploye(@PathVariable("employe-id") Long employeId) {
		iEmployeService.deleteEmploye(employeId);
	}

	@PutMapping("/modify-employe")
	public Employe updateEmploye(@RequestBody Employe employe) {
		return iEmployeService.updateEmploye(employe);
	}

}
