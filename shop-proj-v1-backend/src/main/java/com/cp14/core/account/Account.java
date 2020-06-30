package com.cp14.core.account;

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
import com.cp14.core.role.Role;

@Table(name="account")
@Entity
public class Account implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name ="username")
    private String username;
	
	@Column(name ="password")
    private String password;
	
	@Column(name ="role_id")
    private Long role_id;
	
	@Column(name ="person_id")
    private Long person_id;
	
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
    @JoinColumn(name="role_id",insertable=false,updatable =false)
    private Role role;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
    @JoinColumn(name="person_id",insertable=false,updatable =false)
    private Person person;
	
	@Transient
	public String getRoleName() {
		if(role!=null) {
			return role.getRole_name();
		}
		return "";
	}
	
	@Transient
	public String getPersonName() {
		if(person!=null) {
			return person.getName();
		}
		return "";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Long getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Long person_id) {
		this.person_id = person_id;
	}
	
	
}
