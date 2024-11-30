<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 11/29/2024
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%-- Created by IntelliJ IDEA. User: maitr Date: 11/29/2024 Time: 8:31 AM --%>
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
</head>
<body class="bg-light">
<div class="container my-4">
    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-light rounded">
        Danh sách sản phẩm
    </h1>
    <%--    seach sp--%>

    <form action="products" method="get" class="mb-3">
        <input type="hidden" name="action" value="searchProducts"/>
        <div class="input-group">
            <input type="text" class="form-control" name="keyword" placeholder="Tìm sản phẩm theo tên..." required>
            <button class="btn btn-primary me-2" type="submit">Tìm kiếm</button>
            <a href="products?action=addProductForm" class="btn btn-success">Thêm sản phẩm</a>
        </div>
    </form>

    <table class="table table-bordered table-hover table-striped mt-4">
        <thead class="table-dark">
        <tr>
            <th>Id Sản Phẩm</th>
            <th>Tên Sản Phẩm</th>
            <th>Giá Sản Phẩm</th>
            <th>Màu Sản Phẩm</th>
            <th>Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td><fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="₫" /></td>
                <td>${product.productColor}</td>
                <td>
                    <a href="products?action=editProductForm&id=${product.productId}" class="btn btn-warning btn-sm me-2">Sửa</a>
                    <a href="products?action=deleteProduct&id=${product.productId}" class="btn btn-danger btn-sm me-2" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này không?')">Xóa</a>
                    <a href="products?action=viewProduct&id=${product.productId}" class="btn btn-info btn-sm">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="mt-4">
        <a href="products?action=listProducts" class="btn btn-secondary float-end">Quay lại danh sách sản phẩm</a>
    </div>
</div>
</body>
</html>
