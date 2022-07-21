package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Trip;


public interface ITripService {

	List<Trip> retrieveAllTrips(); 
	Trip addTrip(Trip trip);
	void cancelTrip(Long id);
	Trip retrieveTrip(Long id);
	List<Trip> findTripbyDepartAndArrival(String from, String to);
}