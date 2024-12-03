<%@ page import="com.example.product.model.Product" %>
<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 11/29/2024
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container my-4">
    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-light rounded">
        Chỉnh Sửa Sản Phẩm
    </h1>
    <form action="products" method="post">
        <input type="hidden" name="action" value="editProduct"/>
        <input type="hidden" name="id" value="${product.productId}"/>
        <div class="mb-3">
            <label for="name" class="form-label">Tên Sản Phẩm</label>
            <input type="text" class="form-control" id="name" name="name" value="${product.productName}" required>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="text" class="form-control" id="price" name="price"
                   value="<fmt:formatNumber value='${product.productPrice}' pattern='###,###,###' /> đ" required>
        </div>
        <div class="mb-3">
            <label for="color" class="form-label">Màu Sắc</label>
            <input type="text" class="form-control" id="color" name="color" value="${product.productColor}" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô Tả</label>
            <textarea class="form-control" id="description" name="description" rows="4"
                      required>${product.productDescription}</textarea>
        </div>
        <div class="mt-4">
            <div class="float-end">
                <a href="products?action=listProducts" class="btn btn-secondary ">Quay lại danh sách sản phẩm</a>
                <button type="submit" class="btn btn-primary me-2">Lưu Thay Đổi</button>
            </div>
        </div>
    </form>

    <script>
        document.getElementById("price").addEventListener("input", formatCurrency);

        function formatCurrency() {
            let inputNumber = document.getElementById("price");
            let onlyNumber = inputNumber.value.split(",").join("").replace(/[^0-9]/g, '');
            inputNumber.value = Number(onlyNumber).toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});
        }
    </script>
</div>
</body>
</html>
