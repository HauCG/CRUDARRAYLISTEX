package com.example.product.service;

import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    List<Product> findAll() throws SQLException;

    Product getProductById(int productId) throws SQLException;

    int getNextId() throws SQLException;

    void addProduct(Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void deleteProduct(int productId) throws SQLException;

    List<Product> searchProducts(String keyword) throws SQLException;
}