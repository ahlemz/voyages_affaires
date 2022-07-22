package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reservation;



@Repository
public interface ReservationRepository extends  CrudRepository<Reservation, Long>, JpaRepository<Reservation,Long> {
	
	@Query(value = "SELECT * FROM Reservation r WHERE r.user_id=?1", nativeQuery = true)
    List<Reservation> retrieveEmployeeReservation(@Param("user_id")Long id);

}
