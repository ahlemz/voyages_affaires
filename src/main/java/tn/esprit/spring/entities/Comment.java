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
@Table(name = "T_COMMENTS")
public class Comment implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -8540326358780233564L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_comment;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(name="comment")
	private String comment;
	
	
	@OneToMany(mappedBy="comment", 
	cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
	fetch=FetchType.EAGER)
private List<Comment> comments = new ArrayList<>(); 

	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
			private Post post; 
	
	public Comment() {
	
	}

	public Long getId_comment() {
		return id_comment;
	}

	public void setId_comment(Long id_comment) {
		this.id_comment = id_comment;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comments [id_comment=" + id_comment + ", creationDate=" + creationDate + ", comment=" + comment
				+ ", getId_comment()=" + getId_comment() + ", getCreationDate()=" + getCreationDate()
				+ ", getComment()=" + getComment() + "]";
	}
	
	



 
}
