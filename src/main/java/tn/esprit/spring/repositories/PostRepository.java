package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Post;

@Repository

public interface PostRepository extends CrudRepository<Post, Long> {
	
	@Query(value = "SELECT count(*) FROM T_POST p WHERE p.date_post = CURRENT_DATE", nativeQuery = true)
	public int retrieveNbrOfPostsPerDay();
	
}
