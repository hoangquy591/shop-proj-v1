package com.cp14.core.catalog;

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

@Table(name="catalog")
@Entity
public class Catalog implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name ="catalog_name")
    private String catalog_name;
	
	@Column(name ="catalog_parent_id")
    private Long catalog_parent_id;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
    @JoinColumn(name="catalog_parent_id",insertable=false,updatable =false)
    private Catalog catalog;
	
	//////////////////////
	
	@Transient
	public String getCatalogParentName() {
		if(catalog!=null) {
			return catalog.getCatalog_name();
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

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	public Long getCatalog_parent_id() {
		return catalog_parent_id;
	}

	public void setCatalog_parent_id(Long catalog_parent_id) {
		this.catalog_parent_id = catalog_parent_id;
	}
	
	
}
