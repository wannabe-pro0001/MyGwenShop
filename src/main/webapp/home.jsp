<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-------------Panel----------------------->
<div class="than">
    <img src="${pageContext.request.contextPath}/public/images/260214118_436427648105439_5090248770818895985_n.jpg " height="550px" width="100%">
</div>
<div class="khung">
    <div class="khoi">
        <a class="logo_khung" href=""> <i class="bi bi-truck"></i> </a> <br>
        <span class="khoi_text">GIAO HÀNG TOÀN QUỐC </span>
        <p>
            Miễn phí vận chuyển với các đơn hàng trị giá trên 2.000.000Đ
        </p>
    </div>
    <div class="khoi">
        <a class="logo_khung" href=""> <i class="bi bi-box-seam"></i></i> </a> <br>
        <span class="khoi_text"> QUÀ TẶNG HẤP DẪN </span>
        <p>
            Miễn phí đổi trả trong vòng 30 ngày đầu tiên cho tất cả các mặt hàng
        </p>
    </div>
    <div class="khoi">
        <a class="logo_khung" href=""> <i class="bi bi-award"></i></i> </a> <br>
        <span class="khoi_text">BẢO ĐẢM CHẤT LƯỢNG</span>
        <p>
            Chương trình khuyễn mãi cực lớn và hấp dẫn hàng tháng

        </p>
    </div>
    <div class="khoi">
        <a class="logo_khung" href=""> <i class="bi bi-telephone"></i> </a><br>
        <span class="khoi_text">HỖ TRỢ ONLINE 24/24 </span>
        <p>
            Luôn hỗ trợ khách hàng 24/24 tất cả các ngày trong tuần
        </p>
    </div>
</div>

<%--<!------------------- HOME PAGE -------------------------------->--%>

    <div class="menu_sp">
        <c:forEach var="item" items="${product}">
        <div class="menu_sp-item">
            <c:if test="${item.productImages[0] != null}">
                <img onerror="this.src='${pageContext.request.contextPath}/public/images/duphong.webp'" src="${item.getProductImages().get(0).getImage()}" width="250px" height="250px" alt="">
            </c:if>
<%--            <img src="${pageContext.request.contextPath}/public/images/duphong.webp" width="250px" alt="">--%>

            <div class="item_daban">
                <a href="">${item.category.name}</a>
            </div>
            <div class="item_text">
                <a href="">${item.name}</a> <br>
            </div>
            <br>
            <div class="item_gia">
                <a href="">${item.price}</a>
            </div>

            <div class="layer2">
                <a href="${pageContext.request.contextPath}/product/detail?productID=${item.id}">
                    <img onerror="this.src='${pageContext.request.contextPath}/public/images/duphong.webp'" src="${item.getProductImages().get(0).getImage()}"width="255px" height="255px" alt="">
                </a>
                <div id="id1" onclick="dolen(this)" class="tim"> <a class="user" href="${pageContext.request.contextPath}/wishlist/add?productId=${item.id}"> <i class="bi bi-heart"></i> </a></div>
                <button><a class="user" href="${pageContext.request.contextPath}/product/addToCart?productId=${item.id}"> <i class="bi bi-cart3"></i> </a></button>
            </div>
        </div>
        </c:forEach>
    </div>

