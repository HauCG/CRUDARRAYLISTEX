
// về trang list product dưới quyền admin : http://localhost:8080/h_store?action=listProducts


package com.example.product.controller;

import com.example.product.DAO.product.ProductDAO;
import com.example.product.DAO.product.ProductDaoImpl;
import com.example.product.model.Account;
import com.example.product.model.Product;
import com.example.product.service.account.AccountService;
import com.example.product.service.account.AccountServiceImpl;
import com.example.product.service.product.ProductService;
import com.example.product.service.product.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Controller", urlPatterns = "/h_store")
public class MainController extends HttpServlet {
    private final ProductService productService = new ProductServiceImpl();
    private final AccountService accountService = new AccountServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        if (action == null) {
            action = "listAccounts";
        }
        switch (action) {
            case "listAccounts":

                try {
                    listAccounts(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "listProducts":
                try {
                    listProducts(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
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
                    listAccounts(request, response);
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


    private void listAccounts(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Account> accounts = accountService.findAllAccount();
        request.setAttribute("accounts", accounts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listAccounts.jsp");
        dispatcher.forward(request, response);
    }


    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> products = productService.findAllProducts();
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
        int id = productService.getNextProductId();
        String name = request.getParameter("name");


        String priceHavePattern = request.getParameter("price");
        String priceOnlyHaveNumber = priceHavePattern.replaceAll("[^0-9]", "");
        double price = Double.parseDouble(priceOnlyHaveNumber);


        String color = request.getParameter("color");
        String description = request.getParameter("description");

        String imgLink = "https://ih1.redbubble.net/image.1861329778.2941/st,small,845x845-pad,1000x1000,f8f8f8.jpg";
        if (request.getParameter("imgLink") != null) {
            imgLink = request.getParameter("imgLink");
        }

            Product product = new Product(id, name, price, color, description, imgLink);
            productService.addProduct(product);
            response.sendRedirect("h_store?action=listProducts");
        }


        private void showEditProductForm (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException, SQLException {
            int productId = Integer.parseInt(request.getParameter("id"));
            Product product = productService.getProductById(productId);
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editProductForm.jsp");
            dispatcher.forward(request, response);
        }

        private void editProduct (HttpServletRequest request, HttpServletResponse response) throws
        IOException, SQLException {
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
            String imgLink = request.getParameter("imgLink");
            Product product = new Product(id, name, price, color, description, imgLink);
            productService.updateProduct(product);
            response.sendRedirect("h_store?action=listProducts");
        }

        private void deleteProduct (HttpServletRequest request, HttpServletResponse response) throws
        IOException, SQLException {
            int productId = Integer.parseInt(request.getParameter("id"));
            productService.deleteProduct(productId);
            response.sendRedirect("h_store?action=listProducts");
        }

        private void searchProducts (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException, SQLException {
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
// todo: hiện được số address dựa vào acccountid (OK)


// todo: xử lý ảnh khi ko nhập link ở thêm mới và sửa - cho hiện ảnh default   ()
// todo: thêm (đăng ký), sửa (lấy lại mật khẩu vv), xóa (xóa tài khoản)    ()
// todo: phân quyền - đang nghĩ là thêm mục danh tính vào account ()
// todo:
// todo: hiển thị thông tin của account đó - như kiểu view detals ()
// todo: thêm accountid (tư cách bán hàng vào mỗi sản phẩm) ()
// todo: thêm nút cuộn lên đầu  ()
// todo: thêm giá cao thấp thấp cao ()
// todo: theo màu - lặp lấy màu riêng xong hiện ra list lăn xuống   ()


// todo: TƯ CÁCH ĐĂNG NHẬP ĐANG NGHĨ LÀ NẾU NÓ ĐĂNG NHẬP ĐÚNG
//  THÌ NÓ SẼ TRẢ VỀ CHO MỘT ĐOẠN MÃ ID KHÁCH HÀNG RANDOM DÀI \
//  CHO NÓ KO FAKE ĐƯỢC XONG CỨ MỖI THAO TÁC SẼ CÁI BIẾN ID NGƯỜI ĐĂNG NHẬP ĐÓ
//  THÌ NẾU LÀ ID NHƯ NÀO THÌ SẼ HIỂN THỊ THAO TÁC VV HẠN CHẾ NHƯ NÀO VÀO VỚI CÁI ĐÓ SẼ CẦN BẢNG ID ĐĂNG NHẬP VÀ TƯ CÁCH



