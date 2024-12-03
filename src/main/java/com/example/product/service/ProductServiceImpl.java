package com.example.product.service;

import com.example.product.DAO.ProductDAO;
import com.example.product.DAO.ProductDaoImpl;
import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAll() throws SQLException {
        return productDao.findAll();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productDao.getProductById(productId);
    }

    @Override
    public int getNextId() throws SQLException {
        List<Product> products = productDao.findAll();
        return products.stream().mapToInt(Product::getProductId).max().orElse(0) + 1;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        productDao.deleteProduct(productId);
    }

    @Override
    public List<Product> searchProducts(String keyword) throws SQLException {
        return productDao.searchProducts(keyword);
    }
}