package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Table(name = "T_INVITATION")
public class Invitation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5444486706565774406L;

	/**
	 * 
	 */
	

	public Invitation() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateInvitation;

	private String description;

	private String answer;

	private String confirmation;

	public Long getId() {
		return id;
	}

	public void setReference(Long id) {
		this.id = id;
	}

	public Date getDateInvitation() {
		return dateInvitation;
	}

	public void setDateInvitation(Date dateInvitation) {
		this.dateInvitation = dateInvitation;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Invitation(Long id, Date dateInvitation, String description, String answer, String confirmation) {
		this.id = id;
		this.dateInvitation = dateInvitation;
		this.description = description;
		this.answer = answer;
		this.confirmation = confirmation;
	}

}