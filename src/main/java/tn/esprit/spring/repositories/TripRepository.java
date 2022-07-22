package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import tn.esprit.spring.entities.Trip;


@Repository
public interface TripRepository extends  CrudRepository<Trip, Long>, JpaRepository<Trip,Long> {
	
	@Query(value = "SELECT * FROM Trip t WHERE t.departure_city=?1 AND t.arrival_city=?2", nativeQuery = true)
    List<Trip> findTripbyDepartAndArrival(@Param("departureCity")String from, @Param("arrivalCity") String to);
	
	@Query(value = "SELECT * FROM Trip t, Resevation r WHERE t.id=?1 AND r.trip_id=?1", nativeQuery = true)
    List<Trip> findTripReservations(@Param("trip_id")Long id);

}
