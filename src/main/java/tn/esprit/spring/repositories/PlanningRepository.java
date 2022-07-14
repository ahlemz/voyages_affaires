package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Planning;

@Repository
public interface PlanningRepository extends CrudRepository<Planning, Long>{

}
