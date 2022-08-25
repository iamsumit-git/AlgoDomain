package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.IProductService;
import com.example.demo.service.ISellerService;




@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public IProductService productSer;
	
	@Autowired
	private ISellerService sellerService;
	
	@Autowired
	private ProductRepository productRepo;
	
	//add new product for corresponding seller
	@PostMapping("/seller/{sellerId}/product")
	public Product addProductBySellerId(@PathVariable(value = "sellerId") Long sellerId, @Validated @RequestBody Product product) throws ResourceNotFoundException {
		return sellerService.getSeller(sellerId).map(seller ->{product.setSeller(seller);
		return productSer.addProduct(product);
		}).orElseThrow(() -> new ResourceNotFoundException("vendor not found"));
	}
	
	
	
	@GetMapping("/productList")
	public List<Product> getAllProduct(){
		return productSer.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public Optional<Product> getProductById(@PathVariable("id") Long productId){
		return productSer.getProductById(productId);
	}
	
	
	//Delete an item according to productId and vendorId
	@DeleteMapping("/seller/{sellerId}/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "sellerId") Long sellerId,
			@PathVariable(value = "productId") Long productId) throws ResourceNotFoundException
	{
		return productRepo.findByProductIdAndSeller_SellerId(productId, sellerId).map(product -> {
			productRepo.delete(product);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Product no found"));
	}
	
	
	@PutMapping("/updateproduct/{id}")
	public Product updateProduct(@PathVariable("id") Long productId,@RequestBody Product updateProduct) {
		Optional<Product> product = getProductById(productId);
		Product oldProduct = product.get();
		if(product.isPresent()) {
			oldProduct.setProductprice(updateProduct.getProductprice());
			oldProduct.setProductName(updateProduct.getProductName());
			oldProduct.setProductCategoty(updateProduct.getProductCategoty());
			oldProduct.setProductType(updateProduct.getProductType());
		}else {
			System.out.println("Product not found");
		}
		return productSer.updateProduct(oldProduct);
	}
}
