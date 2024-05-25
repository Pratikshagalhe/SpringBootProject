package com.springbootproject1.controller;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject1.entity.*;
import com.springbootproject1.repository.ProductRepository;
import com.springbootproject1.service.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	 @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody Product product,@RequestBody Long categoryId) {
		 Product newProduct = productService.createProduct(product, categoryId);
	        return ResponseEntity.ok(newProduct);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		 Product product = productService.getProductById(id);
	        return ResponseEntity.ok(product);
	    }
	
	
	
	@GetMapping
	public List<Product> getAllAccount() {
		return productService.getAllProduct();
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        Product updatedProduct = productService.updateProduct(id, product);
	        return ResponseEntity.ok(updatedProduct);
	    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		 productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	 @GetMapping("/page")
	    public ResponseEntity<Page> getAllProductWithPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	        Page categoryPage = (Page) productRepository.findAll(PageRequest.of(page, size));
	        return ResponseEntity.ok(categoryPage);
	    }
}
