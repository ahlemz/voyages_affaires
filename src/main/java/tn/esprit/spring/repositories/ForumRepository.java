package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Forum;

@Repository

public interface ForumRepository extends CrudRepository<Forum, Long> {
	
}
