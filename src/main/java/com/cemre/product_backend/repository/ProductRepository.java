package com.cemre.product_backend.repository;

import com.cemre.product_backend.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {}


