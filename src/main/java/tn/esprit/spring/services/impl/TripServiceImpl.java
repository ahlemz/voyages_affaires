package tn.esprit.spring.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Reservation;
import tn.esprit.spring.entities.Trip;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ReservationRepository;
import tn.esprit.spring.repositories.TripRepository;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.IReservationService;
import tn.esprit.spring.services.ITripService;
import tn.esprit.spring.services.IUserService;

@Service
public class TripServiceImpl implements ITripService {
	@Autowired
	TripRepository tripRepository;

	private static final Logger logger = LogManager.getLogger(TripServiceImpl.class);
	
	
	@Override
	public List<Trip> retrieveAllTrips() {
		return (List<Trip>) tripRepository.findAll();
	}
	
	
	@Override
	public Trip addTrip(Trip trip) {
		
		
		
			Trip vtrip= new Trip();
			logger.info("start mapping process");
			vtrip.setTripNumber(trip.getTripNumber());
			vtrip.setOperatingAirlines(trip.getOperatingAirlines());
			vtrip.setDepartureCity(trip.getDepartureCity());
			vtrip.setArrivalCity(trip.getArrivalCity());
			vtrip.setDateOfDeparture(trip.getDateOfDeparture());
			logger.info("end mapping process");
			logger.info("save contrat");
		return tripRepository.save(vtrip);
	}

	
	
	@Override
	public void cancelTrip(Long id) {
		tripRepository.deleteById(id);
	}

	
	
	@Override
	public Trip retrieveTrip(Long id) {
		
		return tripRepository.findById(id).get();
	}


	@Override
	public List<Trip> findTripbyDepartAndArrival(String from, String to) {
		return (List<Trip>) tripRepository.findTripbyDepartAndArrival(from, to);
	}
	


}
