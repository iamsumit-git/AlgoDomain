package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String productType;
	private String productCategoty;
	private Float productprice;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="sellerId")
	private Seller seller;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="customerId")
	private Customer customer;

	public Product() {
		super();
	}

//	public Product(Long productId, String productName, String productType, String productCategoty, Float productprice,
//			Seller seller, Customer customer) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.productType = productType;
//		this.productCategoty = productCategoty;
//		this.productprice = productprice;
//		this.seller = seller;
//		this.customer = customer;
//	}
	
	

	public Product(Long productId, String productName, String productType, String productCategoty, Float productprice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productCategoty = productCategoty;
		this.productprice = productprice;
	}

//	public Product(Long productId, String productName, String productType, String productCategoty, Float productprice,
//		Seller seller) {
//	super();
//	this.productId = productId;
//	this.productName = productName;
//	this.productType = productType;
//	this.productCategoty = productCategoty;
//	this.productprice = productprice;
//	this.seller = seller;
//}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductCategoty() {
		return productCategoty;
	}

	public void setProductCategoty(String productCategoty) {
		this.productCategoty = productCategoty;
	}

	public Float getProductprice() {
		return productprice;
	}

	public void setProductprice(Float productprice) {
		this.productprice = productprice;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productType=" + productType
				+ ", productCategoty=" + productCategoty + ", productprice=" + productprice + ", seller=" + seller
				+"]";
	}

	
	
	
	
}
