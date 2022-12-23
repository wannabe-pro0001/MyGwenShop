<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-----------------------Gio Hang---------------------->
<section class="main-content clearfix">
    <div class="container my-3">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="category-title position-relative">
                    <h2 class="text-center">Giỏ Hàng</h2>
                </div>
                <c:if test="${cartItem} == null">
                   <p>Bạn chưa có sản phẩm nào trong giỏ hàng. Hay quay lại <a href="${pageContext.request.contextPath}/home">trang chủ</a> để đặt</p>
                </c:if>

                <form action="${pageContext.request.contextPath}/cart/checkout" method="get">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Ảnh</th>
                            <th> Thông tin sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Thành tiền</th>
                            <th></th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${cartItem}">
                            <tr>
                                <td><img onerror="this.src='${pageContext.request.contextPath}/public/images/duphong.webp'" src="${item.getProduct().getProductImages().get(0).getImage()}" width="50px" height="50px" alt=""></td>
                                <td>${item.getProduct().name}</td>
                                <td>${item.getProduct().price}</td>
                                <td><input type="number" min="1" max="${item.getProduct().amount}" value="${item.amount}" name="amount">  </td>
                                <td>Tổng tiền: </td>
                                <td><a href="${pageContext.request.contextPath}/cart/delete?productId=${item.getProduct().id}">Xóa</a></td>
                            </tr>

                        </c:forEach>
                        <tr>
                            <td colspan="2">Tổng: </td>
                            <td colspan="5">
                                <button class="btn btn-primary" type="submit">Thanh Toán</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </form>
            </div>
        </div>
        <div class="col-md-4"> </div>
    </div>
</section>
