package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "T_STATESTIQUE")
public class Statestique implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -8540326358780233564L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_statestique;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(name="type")
	private String type;
	
	@Column(name="nombre")
	private int nombre;

	
	public Statestique() {
	
	}


	public Long getId_statestique() {
		return id_statestique;
	}


	public void setId_statestique(Long id_statestique) {
		this.id_statestique = id_statestique;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public Statestique(Date creationDate, String type, int nombre) {
		super();
		this.creationDate = creationDate;
		this.type = type;
		this.nombre = nombre;
	}
	


	
	



 
}
