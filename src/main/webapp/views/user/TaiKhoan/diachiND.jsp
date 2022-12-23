<%--
  Created by IntelliJ IDEA.
  User: Trung Thanh
  Date: 12/7/2022
  Time: 2:56 AM
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

<!-----------Chi tiết địa chỉ---------------------->
<section class="signup page_customer_account section">
    <div class="container">
        <div class="row">
            <c:import url="/views/user/TaiKhoan/user-navbar.jsp"></c:import>
            <div class="col-xs-12 col-sm-12 col-lg-9 col-right-ac">
                <h1 class="title-head margin-top-0">Địa chỉ</h1>
                <p class="btn-row">
                    <button class="btn-edit-addr btn btn-primary btn-more" type="button" onclick="Bizweb.CustomerAddress.toggleNewForm(); return false;">Thêm địa chỉ</button>
                </p>
            </div>
        </div>
    </div>
</section>
