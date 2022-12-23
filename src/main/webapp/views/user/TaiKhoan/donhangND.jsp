<%--
  Created by IntelliJ IDEA.
  User: Trung Thanh
  Date: 12/7/2022
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <span>Đơn hàng của bạn</span>
                        </strong>
                    </li>
                </ul>
            </div>
        </div>
</section>


<!--------------Don Hang----------------->
<section class="signup page_customer_account section">
    <div class="container">
        <div class="row">
            <c:import url="/views/user/TaiKhoan/user-navbar.jsp"></c:import>
            <div class="col-xs-12 col-sm-12 col-lg-9 col-right-ac">
                <h1 class="title-head margin-top-0">Đơn hàng của bạn</h1>
                <div class="col-xs-12 col-sm-12 col-lg-12 no-padding">
                    <div class="dashboard">
                        <table class="table table-cart table-order" id="my-orders-table">
                            <thead class="thead-default">
                            <tr>
                                <th>Đơn hàng</th>
                                <th>Ngày</th>
                                <th>Địa chỉ</th>
                                <th>Giá trị đơn hàng</th>
                                <th>TT thanh toán</th>
                            </tr>
                            </thead>

                            <tbody>

                            <tr>
                                <td colspan="6">
                                    <p>Không có đơn hàng nào.</p>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>

</section>
</body>
</html>
