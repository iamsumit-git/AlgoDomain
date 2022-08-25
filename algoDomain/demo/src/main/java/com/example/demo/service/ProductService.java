package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SellerRepository;




@Service
public class ProductService implements IProductService {
	
	@Autowired
	public ProductRepository productRepo;
	
	@Autowired
	public SellerRepository sellerRepository;

	@Override
	public Product addProduct(Product newProduct) {
		// TODO Auto-generated method stub
		return productRepo.save(newProduct);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}



	@Override
	public void deleteProduct(Long productId) {
		// TODO Auto-generated method stub

		productRepo.deleteById(productId);
	}

	@Override
	public Product updateProduct(Product updateProduct) {
		// TODO Auto-generated method stub
		return productRepo.save(updateProduct);
	}

	@Override
	public Optional<Product> getProductById(Long productId) {
		// TODO Auto-generated method stub
		return productRepo.findById(productId);
	}

	
	

}
