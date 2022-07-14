package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Partner;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long>{

}
