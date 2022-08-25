package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private String customerName;
	private String username;
	private String password;
	
	
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "seller")
	private List<Product> product;



	public Customer() {
		super();
	}



	
    public Customer(Long customerId, String customerName, String username, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.username = username;
		this.password = password;
	}








	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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



//	public List<Product> getProduct() {
//		return product;
//	}



	public void setProduct(List<Product> product) {
		this.product = product;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
}
