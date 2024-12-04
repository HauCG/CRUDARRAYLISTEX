<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 11/29/2024
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%-- Created by IntelliJ IDEA. User: maitr Date: 11/29/2024 Time: 8:31 AM --%>

<%-----------------------------------------------------------%>



<%--<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Danh Sách Sản Phẩm</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body class="bg-light">--%>
<%--<div class="container my-4">--%>
<%--    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-light rounded">--%>
<%--        Danh sách sản phẩm--%>
<%--    </h1>--%>

<%--    <form action="products" method="get" class="mb-3">--%>
<%--        <input type="hidden" name="action" value="searchProducts"/>--%>
<%--        <div class="input-group">--%>
<%--            <input type="text" class="form-control" name="keyword" placeholder="Tìm sản phẩm theo tên..." required>--%>
<%--            <button class="btn btn-primary me-2" type="submit">Tìm kiếm</button>--%>
<%--            <a href="h_store?action=addProductForm" class="btn btn-success">Thêm sản phẩm</a>--%>
<%--        </div>--%>
<%--    </form>--%>

<%--    <table class="table table-bordered table-hover table-striped mt-4">--%>
<%--        <thead class="table-dark">--%>
<%--        <tr>--%>
<%--            <th>Id Sản Phẩm</th>--%>
<%--            <th>Tên Sản Phẩm</th>--%>
<%--            <th>Giá Sản Phẩm</th>--%>
<%--            <th>Màu Sản Phẩm</th>--%>
<%--            <th>Hình Ảnh</th>--%>
<%--            <th>Chức Năng</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:if test="${not empty products}">--%>
<%--            <c:forEach var="product" items="${products}">--%>
<%--                <tr>--%>
<%--                    <td>${product.productId}</td>--%>
<%--                    <td>${product.productName}</td>--%>
<%--                    <td><fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="₫" /></td>--%>
<%--                    <td>${product.productColor}</td>--%>
<%--                    <td><img src="${product.productImgLink}" alt="Product Image" style="height: 100px; width: auto;"></td>--%>
<%--                    <td>--%>
<%--                        <a href="h_store?action=editProductForm&id=${product.productId}" class="btn btn-warning btn-sm me-2">Sửa</a>--%>
<%--                        <a href="h_store?action=deleteProduct&id=${product.productId}" class="btn btn-danger btn-sm me-2" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này không?')">Xóa</a>--%>
<%--                        <a href="h_store?action=viewProduct&id=${product.productId}" class="btn btn-info btn-sm">Chi tiết</a>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </c:if>--%>
<%--        <c:if test="${empty products}">--%>
<%--            <tr>--%>
<%--                <td colspan="5" class="text-danger text-center">Không tìm thấy sản phẩm.</td>--%>
<%--            </tr>--%>
<%--        </c:if>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>



<%----------------------------------------------------------------------%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s ease-in-out;
        }

        .product-card:hover {
            transform: scale(1.02);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .product-image {
            height: 200px;
            object-fit: cover;
            border-radius: 10px 10px 0 0;
        }

        .product-details {
            padding: 15px;
        }

        .product-actions a {
            margin: 5px 0;
        }
    </style>
</head>
<body class="bg-light">
<div class="container my-4">
    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-light rounded">
        Danh sách sản phẩm
    </h1>

    <form action="h_store" method="get" class="mb-4">
        <input type="hidden" name="action" value="searchProducts"/>
        <div class="input-group">
            <input type="text" class="form-control" name="keyword" placeholder="Tìm sản phẩm theo tên..." required>
            <button class="btn btn-primary" type="submit">Tìm kiếm</button>
            <a href="h_store?action=addProductForm" class="btn btn-success ms-2">Thêm sản phẩm</a>
        </div>
    </form>

    <div class="row g-4">
        <c:if test="${not empty products}">
            <c:forEach var="product" items="${products}">
                <div class="col-md-3">
                    <div class="product-card">
                        <img src="${product.productImgLink}" alt="${product.productName}" class="img-fluid product-image">
                        <div class="product-details text-center">
                            <h5 class="text-truncate">${product.productName}</h5>
                            <p class="text-danger fw-bold"><fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="₫" /></p>
                            <p class="text-muted">${product.productColor}</p>
                            <div class="product-actions">
                                <a href="h_store?action=editProductForm&id=${product.productId}" class="btn btn-warning btn-sm">Sửa</a>
                                <a href="h_store?action=deleteProduct&id=${product.productId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này không?')">Xóa</a>
                                <a href="h_store?action=viewProduct&id=${product.productId}" class="btn btn-info btn-sm">Chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${empty products}">
            <div class="col-12 text-center">
                <p class="text-danger">Không tìm thấy sản phẩm.</p>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
