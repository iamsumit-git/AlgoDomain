package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.IProductService;




@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	public ICustomerService custService;
	
	@Autowired
	public IProductService productSer;
	
	
	@GetMapping("/productList")
	public List<Product> getAllProduct(){
		return productSer.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProductById(@PathVariable("id") Long productId){
		return productSer.getProductById(productId);
	}
	
	@PostMapping("/insertcustomer")
	public Customer insertCustomer(@RequestBody Customer newCustomer) {
		return custService.insertCustomer(newCustomer);
	}
	
	@GetMapping("/customerlist")
	public List<Customer> getAllCustomers(){
		return custService.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") Long cid){
		return custService.getCustomer(cid);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable("id") Long custid) {
		custService.deleteCustomer(custid);
	}
}
