package com.example.product.DAO.product;

import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> findAllProducts() throws SQLException;
    Product getProductById(int productId) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(int productId) throws SQLException;
    List<Product> searchProducts(String keyword) throws SQLException;
}