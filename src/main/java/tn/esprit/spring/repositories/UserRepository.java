package tn.esprit.spring.repositories;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> {
	User findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	public User getByUsername(String username);

	public User findByResetPasswordToken(String token);

	@Query("SELECT count(u) FROM User as  u WHERE u.dateCreation BETWEEN :date2   AND :date1  ")

	public int UserStatistic(@Param("date1") Date date1, @Param("date2") Date date2);

	public User findByEmail(String email);

	@Query(value = "SELECT u FROM User u")
	Collection<User> findAllemp();
}
