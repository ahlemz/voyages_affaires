package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {

}
