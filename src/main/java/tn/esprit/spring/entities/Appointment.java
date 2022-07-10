package tn.esprit.spring.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

 
@Entity
@Table(name = "T_APPOINTMENT")
public class Appointment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int id_sender;
	private int id_recived;
		 
	public Appointment() {
		super();
	}
	
	public Appointment(Long id, int id_sender, int id_recived) {
		super();
		this.id = id;
		this.id_sender = id_sender;
		this.id_recived = id_recived;
	}

	public Appointment(int id_recived, int id_sender) {
		this.id_recived = id_recived;
		this.id_sender = id_sender;
		
	}


	public int getId_sender() {
		return id_sender;
	}

	public void setId_sender(int id_sender) {
		this.id_sender = id_sender;
	}

	public int getId_recived() {
		return id_recived;
	}

	public void setId_recived(int id_recived) {
		this.id_recived = id_recived;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", id_sender=" + id_sender + ", id_recived=" + id_recived + ", getId_sender()="
				+ getId_sender() + ", getId_recived()=" + getId_recived() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	} 

} 


	