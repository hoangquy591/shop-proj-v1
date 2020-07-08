package com.cp14.core.product;

import java.io.Serializable;
import java.math.BigDecimal;

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

import com.cp14.core.catalog.Catalog;

@Table(name="product")
@Entity
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name ="prod_serial")
    private String prod_serial;
	
	@Column(name ="prod_name")
    private String prod_name;
	
	@Column(name ="prod_price")
    private BigDecimal prod_price;
	
	@Column(name ="catalog_id")
    private Long catalog_id;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
    @JoinColumn(name="catalog_id",insertable=false,updatable =false)
    private Catalog catalog;
	
	//////////////////////
		
	@Transient
	public String getCatalogName() {
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

	public String getProd_serial() {
		return prod_serial;
	}

	public void setProd_serial(String prod_serial) {
		this.prod_serial = prod_serial;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public BigDecimal getProd_price() {
		return prod_price;
	}

	public void setProd_price(BigDecimal prod_price) {
		this.prod_price = prod_price;
	}

	public Long getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(Long catalog_id) {
		this.catalog_id = catalog_id;
	}
	
	

}
