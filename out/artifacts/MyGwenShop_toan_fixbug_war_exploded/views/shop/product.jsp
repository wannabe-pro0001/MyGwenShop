<%--
  Created by IntelliJ IDEA.
  User: TOAN
  Date: 12/14/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Alo alo 1234</p>
<c:if test="${sessionScope.account != null}">
    <h1>Tên người dùng: ${sessionScope.account.fullName}</h1>
    <button type="button" id="sign-out">
        <a href = "${pageContext.request.contextPath}/sign-out" for="sign-out" >Đăng xuất</a>
    </button>
    <br>
</c:if>
<c:if test="${message != null}">
    <div class="alert alert-success" role="alert">${message}</div>
</c:if>
<c:if test="${alert != null}">
    <div class="alert alert-danger" role="alert">${alert}</div>
</c:if>

<table class="table table-striped table-bordered table-hover"
       id="sample_2">
    <thead>
    <tr>
        <th></th>
        <th>ID</th>
        <th>Tên</th>
        <th>Miêu tả</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Thể loại</th>
        <th></th>
    </tr>
    <thead>
    <tbody>
    <c:forEach var="item" items="${product}">
        <tr>
            <td class="col__id-category">${item.id}</td>
            <td class="col__category-name">${item.name}</td>
            <td class="col__category-productAmount">${item.description}</td>
            <td>${item.price}</td>
            <td>${item.category.name}</td>
            <td>
                <button class="btn_Edit">
                    <i class="fa-solid fa-pen-to-square" style="color: white;"></i>
                </button>
                <button class="btn_Delete">
                    <i class="fa-solid fa-trash-can" style="color: red;"></i>
                </button>
                <label>
                    <input type="checkbox">
                    <a href="<c:url value="/wishlist/add?productID=${item.id}"/>">Ưa thích</a>
                </label>
                <label>
                    <input type="checkbox">
                    <a href="<c:url value="/wishlist/remove?productID=${item.id}"/>">Bỏ ưa thích</a>
                </label>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>

