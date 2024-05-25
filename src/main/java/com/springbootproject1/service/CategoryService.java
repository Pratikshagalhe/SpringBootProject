package com.springbootproject1.service;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springbootproject1.entity.*;
import com.springbootproject1.repository.CategoryRepository;
import com.springbootproject1.entity.*;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id).orElseThrow();
	}
	
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}
	   public Category updateCategory(Long id, Category category) {
	        Category existingCategory = getCategoryById(id);
	        existingCategory.setName(category.getName());
	        return categoryRepository.save(existingCategory);
	    }
	
	   public void deleteCategory(Long id) {
	        categoryRepository.deleteById(id);
	    }
	   
	   public Page getAllCategoriesWithPage(int page,int size){
		   return (Page) categoryRepository.findAll(PageRequest.of(page, size));
	   }
}
