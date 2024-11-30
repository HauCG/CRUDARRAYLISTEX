package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product getProductById(int productId);
    int getNextId();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> searchProducts(String keyword);
}
