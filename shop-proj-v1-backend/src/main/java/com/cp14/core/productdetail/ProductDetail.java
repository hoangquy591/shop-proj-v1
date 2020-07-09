package com.cp14.core.productdetail;

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

import com.cp14.core.product.Product;

@Table(name="product_detail")
@Entity
public class ProductDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected Long id;
	
	@Column(name ="description")
    private String description;
	
	@Column(name ="size")
    private String size;
	
	@Column(name ="color")
    private String color;
	
	@Column(name ="view_num")
    private Long view_num;
	
	@Column(name ="sold_num")
    private Long sold_num;
	
	@Column(name ="prod_id")
    private Long prod_id;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne
    @JoinColumn(name="prod_id",insertable=false,updatable =false)
    private Product product;
	
	//////////////////////
		
	@Transient
	public String getProductName() {
		if(product!=null) {
			return product.getProd_name();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getView_num() {
		return view_num;
	}

	public void setView_num(Long view_num) {
		this.view_num = view_num;
	}

	public Long getSold_num() {
		return sold_num;
	}

	public void setSold_num(Long sold_num) {
		this.sold_num = sold_num;
	}

	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}
	
	
}
