package com.cp14.core.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.cp14.core.person.Person;

@Table(name="customer")
@Entity
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name ="person_id")
    private Long person_id;
	
	@Column(name ="cus_type")
    private Long cus_type;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="person_id",insertable=false,updatable =false)
	private Person person;
	
	//////////////////////
		
	@Transient
	public String getPersonName() {
		if(person!=null) {
		return person.getName();
		}
		return "";
	}
	
	//////////////////////

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}

	public Long getCus_type() {
		return cus_type;
	}

	public void setCus_type(Long cus_type) {
		this.cus_type = cus_type;
	}
	
}
