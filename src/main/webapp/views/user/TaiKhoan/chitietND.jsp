<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Trung Thanh
  Date: 12/6/2022
  Time: 11:52 PM
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
                        <a class="link" href="${pageContext.request.contextPath}/">Trang Chủ</a>
                        <span>/</span>
                    </li>
                    <li>
                        <strong>
                            <span>Trang chi tiết</span>
                        </strong>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>

<!-----------User Detail---------------------->
<section class="signup page_customer_account section">
    <div class="container">
        <div class="row">
            <c:import url="/views/user/TaiKhoan/user-navbar.jsp"></c:import>
            <div class="col-xs-12 col-sm-12 col-lg-9 col-right-ac">
                <c:if test="${sessionScope.account == null}">
                    <c:redirect url="/login"></c:redirect>
                </c:if>
                <c:if test="${sessionScope.account != null}">
                    <c:if test="${message != null}">
                        <div class="alert alert-danger" role="alert">${message}</div>
                    </c:if>
                    <h1 class="title-head margin-top-0">Thông tin tài khoản</h1>
<%--                    <p><strong>Họ tên: </strong>${sessionScope.account.fullName}</p>--%>
<%--                    <p><strong>Email: </strong>${sessionScope.account.email}</p>--%>
<%--                    <p><strong>Số điện thoại: </strong>${sessionScope.account.phoneNumber}</p>--%>
<%--                    <p><strong>Địa chỉ: </strong>${sessionScope.account.addr}</p>--%>
                    <form accept-charset="UTF-8"
                          method="post"
                          action="${pageContext.request.contextPath}/user/update">
                        <div class="form-group row">
                            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-10">
                                <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${sessionScope.account.email}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="fullName" class="col-sm-2 col-form-label">Họ tên:</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="fullName" name="fullName" value="${sessionScope.account.fullName}" placeholder="${sessionScope.account.fullName}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="phoneNo" class="col-sm-2 col-form-label">Số điện thoại:</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="phoneNo" name="phoneNumber" value="${sessionScope.account.phoneNumber}" placeholder="${sessionScope.account.phoneNumber}">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="addr" class="col-sm-2 col-form-label">Địa chỉ:</label>
                            <div class="col-sm-10">
                                <input class="form-control" id="addr" name="addr" value="${sessionScope.account.addr}" placeholder="${sessionScope.account.addr}">
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary" role="button">Cập nhật</button>
                    </form>

                </c:if>
            </div>

        </div>
    </div>
</section>