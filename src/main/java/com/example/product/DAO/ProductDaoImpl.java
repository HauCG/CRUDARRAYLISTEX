package com.example.product.DAO;

import com.example.product.connection.DatabaseConnection;
import com.example.product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDAO {
    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    @Override
    public List<Product> findAll() throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product");
        ResultSet rs = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            Product product = new Product(
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getDouble("productPrice"),
                    rs.getString("productColor"),
                    rs.getString("productDescription")
            );
            products.add(product);
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE productId = ?");
        statement.setInt(1, productId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return new Product(
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getDouble("productPrice"),
                    rs.getString("productColor"),
                    rs.getString("productDescription")
            );
        }
        return null;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Product (productId, productName, productPrice,productColor, productDescription) VALUES (?, ?, ?, ?, ?)");
        statement.setInt(1, product.getProductId());
        statement.setString(2, product.getProductName());
        statement.setDouble(3, product.getProductPrice());
        statement.setString(4, product.getProductColor());
        statement.setString(5, product.getProductDescription());
        statement.executeUpdate();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Product SET productName = ?, productPrice = ?, productDescription = ?,productColor = ? WHERE productId = ?");
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getProductPrice());
        statement.setString(4, product.getProductColor());
        statement.setString(3, product.getProductDescription());
        statement.setInt(5, product.getProductId());
        statement.executeUpdate();
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Product WHERE productId = ?");
        statement.setInt(1, productId);
        statement.executeUpdate();
    }

    @Override
    public List<Product> searchProducts(String keyword) throws SQLException {
        Connection connection = databaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Product WHERE productName LIKE ?");
        statement.setString(1, "%" + keyword + "%");
        ResultSet rs = statement.executeQuery();
        List<Product> products = new ArrayList<>();

        while (rs.next()) {
            Product product = new Product(
                    rs.getInt("productId"),
                    rs.getString("productName"),
                    rs.getDouble("productPrice"),
                    rs.getString("productColor"),
                    rs.getString("productDescription")
            );
            products.add(product);
        }
        return products;
    }
}