package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Seller;
import com.example.demo.service.ISellerService;



@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private ISellerService sellerService;
	
	
	
	@PostMapping("/addSeller")
	public Seller addSeller(@RequestBody Seller newSeller) {
		return sellerService.addSeller(newSeller);
	}
	
	@GetMapping("/sellet/{id}")
	public Optional<Seller> getSellerById(@PathVariable("id") Long sellerId){
		return sellerService.getSeller(sellerId);
	}
	
	
	
	
}
