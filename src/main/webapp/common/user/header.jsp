<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<header class="header-section header">
    <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand mt-2 mt-lg-0 logo"  href="#">
                <img src="${pageContext.request.contextPath}/public/images/logo_2.png" alt="Gwen Logo" width="100%"/>
            </a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav  mx-auto ">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Tin Tức</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Giới Thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="">Liên Hệ</a>
                    </li>
                </ul>
                <ul class="sub-icon">
                    <li>
                        <a class="user" href=""> <i class="bi bi-search"></i> </a>
                        <form >
                            <div class="search">
                                <input type="text" asp-for="TenNguoiDung" placeholder="Tìm kiếm sản phẩm">
                            </div>
                        </form>
                    </li>
                    <li>
                        <a href="">
                            <a class="user" href="${pageContext.request.contextPath}/user/wishlist"> <i class="bi bi-heart"></i> </a>
                            <!-- <input class="after" id="trangyeuthich"> -->
                        </a>

                    </li>
                    <li>
                        <a class="user" href="${pageContext.request.contextPath}/cart"> <i class="bi bi-cart3"></i> </a>

                    </li>
                    <!-- <li><a href=""><ion-icon name="menu-outline"></ion-icon></a></li> -->
                    <li>
                        <c:choose>
                        <c:when test="${sessionScope.account == null}">
                            <a href="${pageContext.request.contextPath}/login">Đăng nhập</a> | <a href="${pageContext.request.contextPath}/sign-up">Đăng ký</a>
                        </c:when>
                        <c:otherwise>
                            <a class="user" href=""> <i class="bi bi-person"></i>Xin chào, ${sessionScope.account.GetLastName()}</a>
                            <ul class="dangnhap">
                                <li><a href="${pageContext.request.contextPath}/user/info">Tài Khoản</a></li>
                                <li><a href="${pageContext.request.contextPath}/cart">Đơn hàng của tôi</a></li>
                                <li><a href="${pageContext.request.contextPath}/sign-out">Đăng xuất</a></li>
                            </ul>
                            </c:otherwise>
                            </c:choose>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</header>
