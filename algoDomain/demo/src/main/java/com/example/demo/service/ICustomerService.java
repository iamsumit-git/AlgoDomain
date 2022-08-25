package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;



public interface ICustomerService {

	public Customer insertCustomer(Customer newCustomer);
	
	public List<Customer> getAllCustomer();
	
	public Optional<Customer> getCustomer(Long customerId);
	
	public void deleteCustomer(Long customerId);

}
