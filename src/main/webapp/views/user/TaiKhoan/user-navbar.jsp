<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TOAN
  Date: 12/18/2022
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!----------User navigation bar --------------->
<c:url value="${pageContext.request.contextPath}" var="link"></c:url>
<div class="col-xs-12 col-sm-12 col-lg-15 col-left-ac">
    <div class="block-account">
        <h5 class="title-account">Trang Tài Khoản</h5>
        <p>
            Xin chào: <span style = "color: #cd6420">${sessionScope.account.fullName}</span>
        </p>
        <ul class="noidung1_1">
            <li><a class="noidungInfo" href="${pageContext.request.contextPath}/views/user/TaiKhoan/chitietND.jsp">Thông tin tài khoản</a></li>
            <li><a class="noidungInfo" href="${pageContext.request.contextPath}/views/user/TaiKhoan/donhangND.jsp">Đơn hàng của bạn</a></li>
            <li><a class="noidungInfo" href="${pageContext.request.contextPath}/views/user/TaiKhoan/doimk.jsp">Đổi mật khẩu</a></li>
        </ul>
    </div>
</div>
