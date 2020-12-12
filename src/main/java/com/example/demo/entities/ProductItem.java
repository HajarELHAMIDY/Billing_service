package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class ProductItem {
	 @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id ; 
	 @Transient 
	 private Product product; 
	 private long productID; 
	 private double price; 
	 private int quantity; 
	 @ManyToOne
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	 private Bill bill;
	public ProductItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductItem(Long id, Product product, long productID, double price, int quantity, Bill bill) {
		super();
		this.id = id;
		this.product = product;
		this.productID = productID;
		this.price = price;
		this.quantity = quantity;
		this.bill = bill;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public long getProductID() {
		return productID;
	}
	public void setProductID(long productID) {
		this.productID = productID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	} 
	 

}
