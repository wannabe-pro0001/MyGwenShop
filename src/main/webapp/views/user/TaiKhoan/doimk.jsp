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
                            <span>Trang đổi mật khẩu</span>
                        </strong>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>

<!------------ Change Password -------------->
<section class="signup page_customer_account section">
    <div class="container">
        <div class="row">
            <c:import url="/views/user/TaiKhoan/user-navbar.jsp"></c:import>
            <div class="col-xs-12 col-sm-12 col-lg-9 col-right-ac">
                <div class="row">
                    <div class="col-md-6 col-12">
                        <div class="page-login">
                            <c:if test="${message != null}">
                                <div class="alert alert-danger" role="alert">${message}</div>
                            </c:if>
                            <form accept-charset="utf-8"
                                  action="${pageContext.request.contextPath}/user/changePasswd"
                                  id="change_customer_password"
                                  method="POST">
                                <input name="FormType" type="hidden" value="change_customer_password">
                                <input name="utf8" type="hidden" value="true">
                                <p>
                                    Để đảm bảo tính bảo mật vui lòng đặt mật khẩu với ít nhất 6 kí tự
                                </p>
                                <div class="form-signup clearfix">
                                    <fieldset class="form-group">
                                        <label for="oldPass">Mật khẩu cũ <span class="error">*</span></label>
                                        <input type="password" name="OldPassword" id="OldPass" required="" class="form-control form-control-lg">
                                    </fieldset>
                                    <fieldset class="form-group">
                                        <label for="changePass">Mật khẩu mới <span class="error">*</span></label>
                                        <input type="password" name="Password" id="changePass" required="" class="form-control form-control-lg">
                                    </fieldset>
                                    <fieldset class="form-group">
                                        <label for="confirmPass">Xác nhận lại mật khẩu <span class="error">*</span></label>
                                        <input type="password" name="ConfirmPassword" id="confirmPass" required="" class="form-control form-control-lg">
                                    </fieldset>
                                    <button class="button mt-2 btn-edit-addr btn btn-primary btn-more"><i class="hoverButton"></i>Đặt lại mật khẩu</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
