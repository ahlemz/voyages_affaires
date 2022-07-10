package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_FORUM")
public class Forum implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long reference;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	 
	private String typeForum;
 
	@JsonIgnore
	@OneToOne(mappedBy="forum")
	private Employe employe;

	private float salaire;

	public Forum() {
		super();
	}
	
	public Forum(Date dateDebut, String typeForum, float salaire) {
		this.dateDebut = dateDebut;
		this.typeForum = typeForum;
		this.salaire = salaire;
	}


	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
 
	public Long getReference() {
		return reference;
	}

	public void setReference(Long reference) {
		this.reference = reference;
	}

	public String getTypeForum() {
		return typeForum;
	}

	public void setTypeForum(String typeForum) {
		this.typeForum = typeForum;
	}

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
 
 
}
