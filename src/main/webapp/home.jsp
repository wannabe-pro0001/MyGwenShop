<%--
  Created by IntelliJ IDEA.
  User: Trung Thanh
  Date: 11/29/2022
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Gwen</title>
    <!-- CSS -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/css/home.css">


    <!-- <link href="<c:url value="templates/css/style.css"/>" rel="stylesheet" type="text/css"> -->
</head>
<body>
<header class="header-section header">
    <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand mt-2 mt-lg-0 logo"  href="#">
                <img src="${pageContext.request.contextPath}/views/public/images/logo_2.png" alt="Gwen Logo" width="100%"/>
            </a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav  mx-auto ">
                    <li class="nav-item active">
                        <a class="nav-link" href=""> Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href=""> Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href=""> Tin Tức</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href=""> Giới Thiệu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href=""> Liên Hệ</a>
                    </li>
                </ul>
                <div class="user_option">
                    <a class="user_link" href="#">
                        <a class="user" href=""> <i class="bi bi-search"></i> </a>
                        <a class="user" href=""> <i class="bi bi-person"></i> </a>
                        <!-- <li>
                            <ul class="nguoidung">
                                <li><a href=""> Đăng Nhập</a></li>
                                <li><a href=""> Đăng Ký</a></li>
                            </ul>
                        </li> -->

                        <a class="user" href=""> <i class="bi bi-heart"></i> </a>
                        <a class="user" href=""> <i class="bi bi-cart3"></i> </a>
                    </a>
                </div>
            </div>
        </nav>
    </div>
</header>
<div class="than">
    <img src="${pageContext.request.contextPath}/views/public/images/260214118_436427648105439_5090248770818895985_n.jpg " height="550px" width="100%">
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
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="footer_block">
                    <a class="logo-wrapper mb-3 d-block "  href="#">
                        <img src="${pageContext.request.contextPath}/views/public/images/logo_2.png" alt="Gwen Logo" height= "100px" width="100px"/>
                    </a>
                    <div class="single-contact text_footer">
                        <div class="content">
                            <i class="bi bi-geo-alt-fill"></i>
                            Địa chỉ:
                            <span>Số 1 Võ Văn Ngân</span>
                        </div>
                    </div>
                    <div class="single-contact text_footer">
                        <div class="content">
                            <i class="bi bi-phone-fill"></i>
                            Số điện thoại:
                            <span>0345 046 656</span>
                        </div>
                    </div>
                    <div class="single-contact text_footer">
                        <div class="content">
                            <i class="bi bi-envelope-fill"></i>
                            Email:
                            <span>Gwen@gmail.com</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="footer_block">
                            <h3 class="footer_title">
                                CHÍNH SÁCH
                            </h3>
                            <ul class="list_menu">
                                <li> <a class="link" href="">Giới thiệu</a> </li>
                                <li> <a class="link" href="">Hệ thống cửa hàng</a> </li>
                                <li> <a class="link" href="">Câu hỏi thường gặp</a> </li>
                                <li> <a class="link" href="">Gọi điện đặt hàng</a> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="footer_block">
                            <h3 class="footer_title">
                                HỖ TRỢ KHÁCH HÀNG
                            </h3>
                            <ul class="list_menu">
                                <li> <a class="link" href="">Thông tin liên hệ</a> </li>
                                <li> <a class="link" href="">Chính sách giao hàng</a> </li>
                                <li> <a class="link" href="">Chính sách đổi hàng</a> </li>
                                <li> <a class="link" href="">Chính sách bán hàng</a> </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="footer_block">
                            <h3 class="footer_title">
                                ĐĂNG KÝ NHẬN TIN
                            </h3>
                            <div class="form_register">
                                <input type="email" phacehodel="Nhập địa chỉ email" >
                                <button>Đăng ký</button>
                            </div>
                            <ul class="follow_option">
                                <li>
                                    <a class="icon" href="">
                                        <img src="${pageContext.request.contextPath}/views/public/images/facebook.png" width="32px" height="32px" alt="facebook">
                                    </a>
                                </li>
                                <li>
                                    <a class="icon" href="">
                                        <img src="${pageContext.request.contextPath}/views/public/images/zalo.png" width="32px" height="32px" alt="zalo">
                                    </a>
                                </li>
                                <li>
                                    <a class="icon" href="">
                                        <img src="${pageContext.request.contextPath}/views/public/images/instagram.png" width=32px" height="32px" alt="instagram">
                                    </a>
                                </li>
                                <li>
                                    <a class="icon" href="">
                                        <img src="${pageContext.request.contextPath}/views/public/images/youtube.png" width="32px" height="32px" alt="youtube">
                                    </a>
                                </li>
                                <li>
                                    <a class="icon" href="">
                                        <img src="${pageContext.request.contextPath}/views/public/images/tiktok.png" width="32px" height="32px" alt="tiktok">
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4"></div>
                    <div class="col-lg-4">
                        <div class="bank">
                            <img src="${pageContext.request.contextPath}/views/public/images/footer_trustbadge.png" width="277px" height="34px" alt="tiktok">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
