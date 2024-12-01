<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 11/29/2024
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Sản Phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container my-4">
    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-light rounded">
        Thêm Sản Phẩm
    </h1>
    <form action="products" method="post">
        <input type="hidden" name="action" value="addProduct"/>
        <div class="mb-3">
            <label for="name" class="form-label">Tên Sản Phẩm</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>


        <div class="mb-3">
            <label for="price" class="form-label">Giá</label>
            <input type="text" step="0.01" class="form-control" id="price" name="price" required>
        </div>


        <div class="mb-3">
            <label for="color" class="form-label">Màu Sắc</label>
            <input type="text" class="form-control" id="color" name="color" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô Tả</label>
            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-success w-100">Thêm Sản Phẩm</button>
    </form>
    <div class="mt-4">
        <a href="products?action=listProducts" class="btn btn-secondary w-100">Quay lại danh sách sản phẩm</a>
    </div>
</div>

<%--sử lý nhập vào giá tự thay đổi thành định dạng đúng--%>
<script>

    document.getElementById("price").addEventListener("input", formatCurrency);

    function formatCurrency() {
        let inputNumber = document.getElementById("price");
        let onlyNumber = inputNumber.value.split(",").join("").replace(/[^0-9]/g, '');
        inputNumber.value = Number(onlyNumber).toLocaleString('vi-VN', {style: 'currency', currency: 'VND'});
    }
</script>
</body>
</html>









