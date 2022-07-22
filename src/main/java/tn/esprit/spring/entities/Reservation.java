package tn.esprit.spring.entities;

import javax.persistence.*;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String todo;

    private Boolean confirmed=false;
    

    public String getTodo() {
		return todo;
	}


	public void setTodo(String todo) {
		this.todo = todo;
	}

	@OneToOne
    private User user;
    @OneToOne
    private Trip trip;

    public Reservation() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    

    public User getPassenger() {
        return user;
    }

    public void setPassenger(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
