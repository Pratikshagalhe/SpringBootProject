package com.springbootproject1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject1.entity.*;
import com.springbootproject1.repository.ProductRepository;
import com.springbootproject1.entity.*;

@Service
public class ProductService {


	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow();
	}
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	   public Product updateProduct(Long id, Product product) {
		   Product existingProduct = getProductById(id);
	        existingProduct.setName(product.getName());
	        return productRepository.save(existingProduct);
	    }
	
	   public void deleteProduct(Long id) {
		   productRepository.deleteById(id);
	    }
}
