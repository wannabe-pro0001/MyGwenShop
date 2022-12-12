<%--
  Created by IntelliJ IDEA.
  User: TOAN
  Date: 12/12/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Alo alo 1234</p>
    <thead>
        <tr>
           <th></th>
            <th>ID</th>
            <th>Danh mục</th>
            <th>Tổng sản phẩm</th>
            <th></th>
        </tr>
    <thead>
    <tbody>
        <c:forEach var="item" items="${cate}">
        <tr>
            <td> <input type="checkbox"> </td>
            <td class="col__id-category">${item.getId()}</td>
            <td class="col__category-name">${item.getName()}</td>
            <td class="col__category-productAmount">${item.getDescription()}</td>
            <td>
                <button class="btn_Edit">
                <i class="fa-solid fa-pen-to-square" style="color: white;"></i>
                </button>
                <button class="btn_Delete">
                    <i class="fa-solid fa-trash-can" style="color: red;"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</body>
</html>
