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
import tn.esprit.spring.services.IReservationService;
import tn.esprit.spring.services.ITripService;
import tn.esprit.spring.services.IUserService;

@RestController
public class TripRestController {
	
	@Autowired
	private ITripService tripService;
	
	/*@GetMapping("/retrieve-all-trips")
	public List<Trip> retrieveAllTrips() {
		List<Trip> list = tripService.retrieveAllTrips();
		return list;
	}*/
	
	@GetMapping(value = "/retrieve-all-trips")
	public ResponseEntity retrieveAllTrips() {
		List<Trip> trips = new ArrayList<>();
		try {
			trips = tripService.retrieveAllTrips();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(trips);
	}

	@GetMapping("/retrieve-trip/{trip-id}")
	public Trip retrieveTrip(@PathVariable("trip-id") Long id) {
		return tripService.retrieveTrip(id);
	}
	
	@GetMapping("/retrieve-trip/{departure}/{arrival}")
	public ResponseEntity findTripbyDepartAndArrival(@PathVariable("departure") String from, @PathVariable("arrival") String to) {
		List<Trip> trips = new ArrayList<>();
		try {
			trips = tripService.findTripbyDepartAndArrival(from, to);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(trips);
	}

	@PostMapping("/add-trip")
	public Trip addTrip(@RequestBody Trip trip) {
		Trip vtrip = tripService.addTrip(trip);
		return vtrip;
	}

	@DeleteMapping("/cancel-trip/{trip-id}")
	public void cancelTrip(@PathVariable("trip-id") Long  id) {
		tripService.cancelTrip(id);
	}

}
