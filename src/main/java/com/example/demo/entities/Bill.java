package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Bill {
	 @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; 
	private Date buillingDate; 
	@OneToMany(mappedBy = "bill")
	private Collection<ProductItem> productsItems; 
	@Transient
	private Customer customer; 
	private long customerId;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bill(Long id, Date buillingDate, Collection<ProductItem> productsItems, Customer customer, long customerId) {
		super();
		this.id = id;
		this.buillingDate = buillingDate;
		this.productsItems = productsItems;
		this.customer = customer;
		this.customerId = customerId;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getBuillingDate() {
		return buillingDate;
	}
	public void setBuillingDate(Date buillingDate) {
		this.buillingDate = buillingDate;
	}
	public Collection<ProductItem> getProductsItems() {
		return productsItems;
	}
	public void setProductsItems(Collection<ProductItem> productsItems) {
		this.productsItems = productsItems;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	} 
	
	

}
