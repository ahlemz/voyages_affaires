package tn.esprit.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.services.IReservationService;
import tn.esprit.spring.services.IUserService;

@RestController
public class ReservationRestController {
	
	@Autowired
	private IReservationService reservationService;
	@Autowired
	ReservationRepository reservationRepository;
	
	@GetMapping("/retrieve-all-reservations")
	public List<Reservation> retrieveAllReservations() {
		List<Reservation> list = reservationService.retrieveAllReservations();
		return list;
	}

	@GetMapping("/retrieve-reservation/{reservation-id}")
	public Reservation retrieveReservation(@PathVariable("reservation-id") Long reservationId) {
		return reservationService.retrieveReservation(reservationId);
	}
	
	
	
	@GetMapping("/retrieve-employee-reservation/{employee-id}")
	public ResponseEntity retrieveEmployeeReservation(@PathVariable("employee-id") Long id) {
		List<Reservation> reservations = new ArrayList<>();
		try {
			reservations = reservationService.retrieveEmployeeReservation(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(reservations);
	}

	@PostMapping("/add-reservation")
	public Reservation addReservation(@RequestBody Reservation reservation) {
		Reservation reserv = reservationService.addReservation(reservation);
		return reserv;
	}

	@DeleteMapping("/cancel-reservation/{reservation-id}")
	public void cancelReservation(@PathVariable("reservation-id") Long  reservationId) {
		reservationService.cancelReservation(reservationId);
	}

	@PutMapping("/confirm-reservation/{reservation-id}")
	public Reservation confirmReservation(@PathVariable("reservation-id") Long  reservationId) {
		
		return reservationService.confirmReservation(reservationId);
	}

}
