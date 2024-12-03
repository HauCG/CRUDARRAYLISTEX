package com.example.product.controller;

import com.example.product.DAO.ProductDAO;
import com.example.product.DAO.ProductDaoImpl;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.example.product.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final ProductDAO productDao = new ProductDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        if (action == null) {
            action = "listProducts";
        }
        switch (action) {
            case "viewProduct":
                try {
                    viewProduct(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addProductForm":
                showAddProductForm(request, response);
                break;
            case "editProductForm":
                try {
                    showEditProductForm(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteProduct":
                try {
                    deleteProduct(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "searchProducts":
                try {
                    searchProducts(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listProducts(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        if (action == null) {
            action = "listProducts";
        }
        switch (action) {
            case "addProduct":
                try {
                    addProduct(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "editProduct":
                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                try {
                    listProducts(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listProducts.jsp");
        dispatcher.forward(request, response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(productId);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewProduct.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addProductForm.jsp");
        dispatcher.forward(request, response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = productService.getNextId();
        String name = request.getParameter("name");


        String priceHavePattern = request.getParameter("price");
        String priceOnlyHaveNumber = priceHavePattern.replaceAll("[^0-9]", "");
        double price = Double.parseDouble(priceOnlyHaveNumber);


        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Product product = new Product(id, name, price, color, description);
        productService.addProduct(product);
        response.sendRedirect("products?action=listProducts");
    }

    private void showEditProductForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int productId = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProductById(productId);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editProductForm.jsp");
        dispatcher.forward(request, response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        String priceHavePattern = request.getParameter("price");
        String priceOnlyHaveNumber = priceHavePattern.replaceAll("[^0-9]", "");
        double price = Double.parseDouble(priceOnlyHaveNumber);


        String color = request.getParameter("color");
        String description = request.getParameter("description");
        Product product = new Product(id, name, price, color, description);
        productService.updateProduct(product);
        response.sendRedirect("products?action=listProducts");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int productId = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(productId);
        response.sendRedirect("products?action=listProducts");
    }

    private void searchProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.searchProducts(keyword);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchProducts.jsp");
        dispatcher.forward(request, response);
    }

}

// todo: sửa phần sửa tiền thêm chữ vnd (OK)
// todo: lưu tiền bị lỗi dạng đang text sang dạng number mới lưu được xử lý ở edit  (OK)
// todo: tìm theo tên  (OK)
// todo: thêm tự định dạng số khi thêm mới nhập sản phẩm  (OK)

// todo: thêm nút cuộn lên đầu  ()
// todo: thêm giá cao thấp thấp cao ()
// todo: theo màu - lặp lấy màu riêng xong hiện ra list lăn xuống   ()