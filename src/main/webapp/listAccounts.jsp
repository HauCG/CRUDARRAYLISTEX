<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/4/2024
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 12/4/2024
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Accounts</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-5">
    <h1 class="text-center mb-4">Danh Sách Tài Khoản</h1>
    <table class="table table-bordered table-hover">
        <thead class="table-primary">
        <tr>
            <th>Id Tài Khoản</th>
            <th>Tên Đăng Nhập</th>
            <th>Mật Khẩu</th>
            <th>Địa Chỉ</th>
            <th>Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="account" items="${accounts}">
            <tr>
                <td>${account.accountId}</td>
                <td>${account.accountUserName}</td>
                <td>${account.accountPassword}</td>
                <td>${account.accountAddressCount} -
                    <a href="h_store?action=viewAddress&id=${account.accountId}" class="btn btn-info btn-sm">Xem Chi tiết</a>
                </td>
                <td>
                        <a href="h_store?action=editProductForm&id=${product.productId}" class="btn btn-warning btn-sm">Sửa</a>
                        <a href="h_store?action=deleteProduct&id=${product.productId}" class="btn btn-danger btn-sm" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này không?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
