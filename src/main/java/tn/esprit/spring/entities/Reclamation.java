package tn.esprit.spring.entities;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "T_Reclamation")
public class Reclamation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReclam;
	
	private String refReclam;
	
	private boolean etatReclam;
	
	private Date dateReclamation;
	
	private String email;
	
	private String Description;

	@ManyToOne()
	private User user;

	public User getUser() {
		return user;
	}
}