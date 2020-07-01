package com.cp14.core.staff;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.cp14.core.person.Person;

@Table(name="staff")
@Entity
public class Staff implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name ="staff_birthday")
    private Date staff_birthday;
	
	@Column(name ="staff_idcard")
    private String staff_idcard;
	
	@Column(name ="staff_manager")
    private Long staff_manager;
	
	@Column(name ="staff_img")
    private String staff_img;
	
	@Column(name ="person_id")
    private Long person_id;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="person_id",insertable=false,updatable =false)
	private Person person;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
    @JoinColumn(name="staff_manager",insertable=false,updatable =false)
    private Staff staff;
	
	//////////////////////
	
	@Transient
	public String getPersonName() {
		if(person!=null) {
			return person.getName();
		}
		return "";
	}
	
	@Transient
	public String getStaffManagerName() {
		if(staff!=null) {
			return staff.getPersonName();
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

	public Date getStaff_birthday() {
		return staff_birthday;
	}

	public void setStaff_birthday(Date staff_birthday) {
		this.staff_birthday = staff_birthday;
	}

	public String getStaff_idcard() {
		return staff_idcard;
	}

	public void setStaff_idcard(String staff_idcard) {
		this.staff_idcard = staff_idcard;
	}

	public Long getStaff_manager() {
		return staff_manager;
	}

	public void setStaff_manager(Long staff_manager) {
		this.staff_manager = staff_manager;
	}

	public String getStaff_img() {
		return staff_img;
	}

	public void setStaff_img(String staff_img) {
		this.staff_img = staff_img;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
	
	
}
