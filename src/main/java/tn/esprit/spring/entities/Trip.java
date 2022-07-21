package tn.esprit.spring.entities;

//import com.udemy.flightReservation.entity.common.AbstractEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Trip {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String tripNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private LocalDate dateOfDeparture;

    public Trip() {

    }




    public Long getId() {
		return id;
	}



	public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public String getOperatingAirlines() {
        return operatingAirlines;
    }

    public void setOperatingAirlines(String operatingAirlines) {
        this.operatingAirlines = operatingAirlines;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    
}
