package tn.esprit.spring.services.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	
	@Autowired private JavaMailSender javaMailSender;

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
		Reservation reservation = reservationRepository.findById(id).get();
		SimpleMailMessage mailMessage
        = new SimpleMailMessage();
		
		mailMessage.setFrom("Reservation");
        mailMessage.setTo(reservation.getPassenger().getEmail());
        mailMessage.setText("Bonjour "+reservation.getPassenger().getFirstname()+" "+ reservation.getPassenger().getLastname()+","
        		+"\n"+"La reservation du voyage de "+reservation.getTrip().getDepartureCity()+" à "+ reservation.getTrip().getArrivalCity()
        		+" est annulée!");
        mailMessage.setSubject("Annulation Voyage!");
        javaMailSender.send(mailMessage);
        
        
	    reservationRepository.deleteById(id);
	    
	    
		
	}

	@Override
	public Reservation confirmReservation(Long  reservationId) {
		Reservation r_update = null;
		Reservation reservation = reservationRepository.findById(reservationId).get();
		reservation.setConfirmed(true);
		r_update = reservationRepository.save(reservation);
		
		
		SimpleMailMessage mailMessage
        = new SimpleMailMessage();
		
		mailMessage.setFrom("Reservation");
        mailMessage.setTo(reservation.getPassenger().getEmail());
        mailMessage.setText("Bonjour "+reservation.getPassenger().getFirstname()+" "+ reservation.getPassenger().getLastname()+","
        		+"\n"+"La reservation du voyage de "+reservation.getTrip().getDepartureCity()+" à "+ reservation.getTrip().getArrivalCity()
        		+" est confirmé!");
        mailMessage.setSubject("Confirmation Voyage");
        javaMailSender.send(mailMessage);
		
		return r_update;
		
	}

	@Override
	public Reservation retrieveReservation(Long id) {
		return reservationRepository.findById(id).get();
	}

	/*@Override
	public Reservation retrieveEmployeeReservation(Long id) {
		return reservationRepository.findById(id).
	}*/
	
	@Override
	public List<Reservation> retrieveEmployeeReservation(Long id) {
		return (List<Reservation>) reservationRepository.retrieveEmployeeReservation(id);
	}

}
