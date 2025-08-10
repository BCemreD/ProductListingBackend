package com.cemre.product_backend.service;


import com.cemre.product_backend.model.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
}
