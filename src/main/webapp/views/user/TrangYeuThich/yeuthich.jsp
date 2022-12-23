<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="${pageContext.request.contextPath}/views/user/TrangYeuThich/yeuthich.css" rel="stylesheet">
</head>

<section class="bread-crumb mb-3">
    <div class="container">
        <div class="row">
            <div class="col-12 a-left">
                <ul class="breadcrumb m-0 px-0 py-2">
                    <li class="home">
                        <a class="link" href="">Trang Chủ</a>
                        <span>/</span>
                    </li>
                    <li>
                        <strong>
                            <span>Sản phẩm ưa thích</span>
                        </strong>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>

<!---San pham ua thichh--->

<div class="menu_sp">

        <h1 class="title-head">
            Sản phẩm yêu thích
        </h1>

    <c:if test="${items} == null">
        <p>Bạn không có sản phẩm ưa thích nào</p>
    </c:if>
    <c:forEach var="item" items="${items}">
        <div class="menu_sp-item">
                <img onerror="this.src='${pageContext.request.contextPath}/public/images/duphong.webp'" src="${item.getProduct().getProductImages().get(0).getImage()}" width="250px" height="250px" alt="">
                <%--            <img src="${pageContext.request.contextPath}/public/images/duphong.webp" width="250px" alt="">--%>

            <div class="item_daban">
                <a href="">${item.getProduct().category.name}</a>
            </div>
            <div class="item_text">
                <a href="">${item.getProduct().name}</a> <br>
            </div>
            <br>
            <div class="item_gia">
                <a href="">${item.getProduct().price}</a>
            </div>

            <div class="layer2">
                <a href="">
                    <img onerror="this.src='${pageContext.request.contextPath}/public/images/duphong.webp'" src="${item.getProduct().getProductImages().get(0).getImage()}"width="255px" height="255px" alt="">
                </a>
                <div id="id1" onclick="dolen(this)" class="tim"> <a class="user" href="${pageContext.request.contextPath}/wishlist/add?productId=${item.getProduct().id}"> <i class="bi bi-heart"></i> </a></div>
                <button><a class="user" href="${pageContext.request.contextPath}/product/addToCart?productId=${item.getProduct().id}"> <i class="bi bi-cart3"></i> </a></button>
            </div>
        </div>
    </c:forEach>
</div>

