package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "seller")

public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	private String sellerName;
	private String address;
	public Seller() {
		super();
	}
	public Seller(Long sellerId, String sellerName, String address) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.address = address;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", address=" + address + "]";
	}
	
    
}
