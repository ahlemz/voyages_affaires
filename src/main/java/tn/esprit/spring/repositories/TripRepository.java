package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long>{

}
 