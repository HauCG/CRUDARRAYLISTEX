<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Chi tiết sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center text-primary fw-bold display-4 shadow-lg p-3 bg-light rounded">
        Chi tiết sản phẩm
    </h1>
    <c:choose>
        <c:when test="${not empty product}">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${product.productName}</h5>
                    <p class="card-text"><strong>Mã sản phẩm:</strong> ${product.productId}</p>
                    <p class="card-text"><strong>Giá:</strong> <fmt:formatNumber value="${product.productPrice}" type="currency" currencySymbol="₫" /></p>
                    <p class="card-text"><strong>Màu sắc:</strong> ${product.productColor}</p>
                    <p class="card-text"><strong>Mô tả:</strong> ${product.productDescription}</p>
                    <img src="${product.productImgLink}" alt="Ảnh sản phẩm" style="max-height: 100px; width: auto;" class="border">
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <p class="text-danger">Không tìm thấy sản phẩm.</p>
        </c:otherwise>
    </c:choose>
    <div class="mt-4">
        <a href="h_store?action=listProducts" class="btn btn-secondary float-end">Quay lại danh sách sản phẩm</a>
    </div>
</div>


