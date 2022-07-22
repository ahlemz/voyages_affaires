package tn.esprit.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.IReservationService;
import tn.esprit.spring.services.IUserService;

@Service
public class ReservationServiceImpl implements IReservationService {
	@Autowired
	ReservationRepository reservationRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);
	

	@Override
	public List<Reservation> retrieveAllReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public void cancelReservation(Long id) {
	    reservationRepository.deleteById(id);
		
	}

	@Override
	public Reservation confirmReservation(Long  reservationId) {
		Reservation r_update = null;
		Reservation reservation = reservationRepository.findById(reservationId).get();
		reservation.setConfirmed(true);
		r_update = reservationRepository.save(reservation);
		return r_update;
		
	}

	@Override
	public Reservation retrieveReservation(Long id) {
		return reservationRepository.findById(id).get();
	}

}
