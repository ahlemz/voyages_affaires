package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

	@Query(value = "SELECT count(*) FROM T_COMMENTS c WHERE c.creation_date = CURRENT_DATE", nativeQuery = true)
	public int retrieveNbrOfCommentsPerDay();
	
}
