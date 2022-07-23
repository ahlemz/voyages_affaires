package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.entities.Statestique;

@Repository
public interface StatestiqueRepository extends CrudRepository<Statestique, Long> {


	
}
