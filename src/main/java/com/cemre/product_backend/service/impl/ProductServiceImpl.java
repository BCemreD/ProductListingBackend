package com.cemre.product_backend.service.impl;

import com.cemre.product_backend.model.entity.Product;
import com.cemre.product_backend.repository.ProductRepository;
import com.cemre.product_backend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
