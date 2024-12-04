package com.example.product.service.product;

import com.example.product.DAO.product.ProductDAO;
import com.example.product.DAO.product.ProductDaoImpl;
import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAllProducts() throws SQLException {
        return productDao.findAllProducts();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        return productDao.getProductById(productId);
    }

    @Override
    public int getNextProductId() throws SQLException {
        List<Product> products = productDao.findAllProducts();
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