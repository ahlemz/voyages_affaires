package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@Column(name="role_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@Enumerated(EnumType.STRING)
private ERole name;

public Role(Integer id, ERole name) {
	super();
	this.id = id;
	this.name = name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public ERole getName() {
	return name;
}
public void setName(ERole name) {
	this.name = name;
}

@Override
public String toString() {
	return "Role [id=" + id + ", name=" + name + "]";
}



}
