package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.Seller;



public interface ISellerService {

	public Seller addSeller(Seller newSeller);
	
	public Optional<Seller> getSeller(Long sellerId);
}
