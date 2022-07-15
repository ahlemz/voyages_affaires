package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Post;

@Repository

public interface PostRepository extends CrudRepository<Post, Long> {
	
}
