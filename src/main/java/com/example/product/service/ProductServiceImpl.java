package com.example.product.service;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product(1, "MacBook Pro 14-inch", 52990000.0, "Xám không gian", "Laptop cao cấp"));
        products.add(new Product(2, "iPhone 15 Pro Max", 33990000.0, "Đen titan", "Điện thoại thông minh"));
        products.add(new Product(3, "Samsung Galaxy Tab S9", 19990000.0, "Be", "Máy tính bảng"));
        products.add(new Product(4, "Dell XPS 13", 45990000.0, "Bạc", "Laptop cao cấp"));
        products.add(new Product(5, "Asus ROG Strix G16", 32990000.0, "Đen", "Laptop gaming"));
        products.add(new Product(6, "iPad Pro 12.9-inch", 29990000.0, "Bạc", "Máy tính bảng"));
        products.add(new Product(7, "Apple Watch Ultra", 19990000.0, "Vàng", "Đồng hồ thông minh"));
        products.add(new Product(8, "Sony WH-1000XM5", 8990000.0, "Đen", "Tai nghe chống ồn"));
        products.add(new Product(9, "LG OLED TV 55-inch", 34990000.0, "Đen", "TV 4K cao cấp"));
        products.add(new Product(10, "Canon EOS R6", 62990000.0, "Đen", "Máy ảnh chuyên nghiệp"));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        return products.stream().filter(p -> p.getProductId() == productId).findFirst().orElse(null);
    }

    @Override
    public int getNextId() {
        int maxId = 0;
        for (Product product : products) {
            if (product.getProductId() > maxId) {
                maxId = product.getProductId();
            }
        }
        return maxId + 1;
    }


    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product existingProduct = getProductById(product.getProductId());
        if (existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductPrice(product.getProductPrice());
            existingProduct.setProductColor(product.getProductColor());
            existingProduct.setProductDescription(product.getProductDescription());
        }
    }

    @Override
    public void deleteProduct(int productId) {
        products.removeIf(p -> p.getProductId() == productId);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return products.stream().filter(p -> p.getProductName().toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }


}
