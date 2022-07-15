package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "T_POST")
public class Post implements Serializable {
	
	private static final long serialVersionUID = 6191889143079517027L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_post;
	
	@Temporal(TemporalType.DATE)
	private Date datePost;

	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.EAGER)
			private Forum forum; 
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Post() {
	
	}
	
	public Post(Date datePost) {
		this.datePost = datePost;
	
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Posts [id_post=" + id_post + ", datePost=" + datePost + ", content=" + content + ", title=" + title
				+ ", getTitle()=" + getTitle() + ", getDatePost()=" + getDatePost() + ", getContent()=" + getContent()
				+ "]";
	}

 
}
