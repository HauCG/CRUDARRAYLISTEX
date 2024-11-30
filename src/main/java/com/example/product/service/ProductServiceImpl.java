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

        // Thêm 30 sản phẩm khác
        products.add(new Product(4, "Dell XPS 13", 45990000.0, "Bạc", "Laptop cao cấp"));
        products.add(new Product(5, "Asus ROG Strix G16", 32990000.0, "Đen", "Laptop gaming"));
        products.add(new Product(6, "iPad Pro 12.9-inch", 29990000.0, "Bạc", "Máy tính bảng"));
        products.add(new Product(7, "Apple Watch Ultra", 19990000.0, "Vàng", "Đồng hồ thông minh"));
        products.add(new Product(8, "Sony WH-1000XM5", 8990000.0, "Đen", "Tai nghe chống ồn"));
        products.add(new Product(9, "LG OLED TV 55-inch", 34990000.0, "Đen", "TV 4K cao cấp"));
        products.add(new Product(10, "Canon EOS R6", 62990000.0, "Đen", "Máy ảnh chuyên nghiệp"));
        products.add(new Product(11, "PlayStation 5", 15990000.0, "Trắng", "Máy chơi game"));
        products.add(new Product(12, "Xbox Series X", 14990000.0, "Đen", "Máy chơi game"));
        products.add(new Product(13, "Nikon Z6 II", 51990000.0, "Đen", "Máy ảnh mirrorless"));
        products.add(new Product(14, "Logitech MX Master 3S", 2990000.0, "Xám", "Chuột không dây"));
        products.add(new Product(15, "Razer BlackWidow V4", 3290000.0, "Đen", "Bàn phím cơ"));
        products.add(new Product(16, "HP Envy 13", 27990000.0, "Bạc", "Laptop văn phòng"));
        products.add(new Product(17, "Samsung Galaxy S23 Ultra", 32990000.0, "Xanh", "Điện thoại thông minh"));
        products.add(new Product(18, "Google Pixel 8", 21990000.0, "Đen", "Điện thoại thông minh"));
        products.add(new Product(19, "OnePlus 11", 18990000.0, "Xanh", "Điện thoại thông minh"));
        products.add(new Product(20, "DJI Mavic 3", 67990000.0, "Xám", "Flycam cao cấp"));
        products.add(new Product(21, "Fitbit Charge 6", 4590000.0, "Đen", "Vòng đeo tay sức khỏe"));
        products.add(new Product(22, "Microsoft Surface Pro 9", 24990000.0, "Xanh", "Máy tính bảng"));
        products.add(new Product(23, "Bose QC45", 8990000.0, "Trắng", "Tai nghe chống ồn"));
        products.add(new Product(24, "Garmin Fenix 7X", 25990000.0, "Đen", "Đồng hồ thông minh"));
        products.add(new Product(25, "Lenovo Legion 5 Pro", 30990000.0, "Xám", "Laptop gaming"));
        products.add(new Product(26, "Xiaomi Pad 6 Pro", 14990000.0, "Vàng", "Máy tính bảng"));
        products.add(new Product(27, "Huawei MatePad Pro", 12990000.0, "Trắng", "Máy tính bảng"));
        products.add(new Product(28, "Asus ZenBook 14 OLED", 25990000.0, "Xanh", "Laptop văn phòng"));
        products.add(new Product(29, "Corsair K95 RGB", 5990000.0, "Đen", "Bàn phím cơ cao cấp"));
        products.add(new Product(30, "Apple AirPods Pro 2", 5490000.0, "Trắng", "Tai nghe không dây"));
        products.add(new Product(31, "Amazon Kindle Paperwhite", 3990000.0, "Đen", "Máy đọc sách"));
        products.add(new Product(32, "Epson EcoTank L3150", 4890000.0, "Đen", "Máy in đa năng"));
        products.add(new Product(33, "Philips Hue Starter Kit", 3299000.0, "Trắng", "Bộ đèn thông minh"));
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
