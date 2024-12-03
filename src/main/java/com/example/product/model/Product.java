package com.example.product.model;

public class Product {
    private int productId;
    private String productName;
    private double productPrice;
    private String productColor;
    private String productDescription;
    private String productImgLink;

    public Product(int productId, String productName, double productPrice, String productColor, String productDescription, String productImgLink) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productDescription = productDescription;
        this.productImgLink = productImgLink;
    }

    public String getProductImgLink() {
        return productImgLink;
    }

    public void setProductImgLink(String productImgLink) {
        this.productImgLink = productImgLink;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}