package com.springbootproject1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject1.entity.*;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
