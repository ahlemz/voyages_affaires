package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comment;

@Repository

public interface CommentRepository extends CrudRepository<Comment, Long> {
	
}
