 package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "T_FORUM")
public class Forum implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_forum;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	private Trip trip;
	
	public Forum() {
	
	}
	
	public Forum(Date dateDebut) {
		this.dateDebut = dateDebut;
	
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Forum [id_forum=" + id_forum + ", dateDebut=" + dateDebut + ", description=" + description
				+ ", getDateDebut()=" + getDateDebut() + ", getDescription()=" + getDescription() + "]";
	}
 

 
}
