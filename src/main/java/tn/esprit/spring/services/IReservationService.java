package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Reservation;


public interface IReservationService {

	List<Reservation> retrieveAllReservations(); 
	Reservation addReservation(Reservation reservation);
	void cancelReservation(Long id);
	Reservation confirmReservation(Long id);
	Reservation retrieveReservation(Long id);
}