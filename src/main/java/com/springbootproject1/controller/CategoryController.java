package com.springbootproject1.controller;

import java.util.List;
import java.util.Optional;

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
import com.springbootproject1.repository.CategoryRepository;
import com.springbootproject1.service.CategoryService;
import com.springbootproject1.entity.*;

@RestController
@RequestMapping("/api/catigories")
public class CategoryController {

	@Autowired
 private CategoryService categoryService;
 private CategoryRepository categoryRepository;
	
	 @PostMapping
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        Category newCategory = categoryService.createCategory(category);
	        return ResponseEntity.ok(newCategory);
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id) {
	        Optional<Category> category = categoryRepository.findById(id);
	        return ResponseEntity.ok(category);
	    }
	
	
	
	@GetMapping
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        Category updatedCategory = categoryService.updateCategory(id, category);
	        return ResponseEntity.ok(updatedCategory);
	    }
	
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		 categoryService.deleteCategory(id);
	        return ResponseEntity.noContent().build();
	    }
	
	 @GetMapping("/page")
	    public ResponseEntity<Page> getAllCategoriesWithPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	        Page categoryPage = (Page) categoryRepository.findAll(PageRequest.of(page, size));
	        return ResponseEntity.ok(categoryPage);
	    }
}

