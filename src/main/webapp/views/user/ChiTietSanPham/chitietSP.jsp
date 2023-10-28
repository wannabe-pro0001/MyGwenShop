<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link rel="stylesheet" href="chitietSP.css">
</head>
<body>
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
                            <span>Chi tiết sản phẩm</span>
                        </strong>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</section>

<c:set var="item" value="product" />
<section class="section mt-0 mb-lg-4 mb-3 mb-sm-0">
    <div class="container">
        <div class="row m-sm-0">
            <div class="product-detail-left product-images bg-white py-3 col-12 col-lg-6 overflow-hidden thumbs-on-mobile--show">
                <div class="anh_sp">
                    <img onerror="this.src='/image/duphong.webp'" src="" />
                    <img onerror="this.src='/image/duphong.webp'" src="" />
                    <img onerror="this.src='/image/duphong.webp'" src="" />
                    <img onerror="this.src='/image/duphong.webp'" src="" />
                    <img onerror="this.src='/image/duphong.webp'" src="" />
                </div>
            </div>
            <div class="col-xs-12 col-lg-6 details-pro bg-white py-3 mt-3 mt-lg-0 px-3">
                <div class="d-flex justify-content-between">
                    <h1 class="title-product">Áo sơ mi cao cấp</h1>
                </div>
                <span class="thuonghieu1">
                    <p>Thương hiệu: <b>Shein</b></p>

                    <p>Mã: <b>001</b></p>
                </span>
                <div class="gia"><p id="gia">200.000đ </p></div>
                <div class="swatch-div">
                    <div class="swatch clearfix">
                        <div class="header1">
                            <span>Kích thước:
                                <span class="swatch-value">"backend"</span>
                            </span>
                            <a href="" class="open-size-modal link">Hướng dẫn chọn size</a>
                        </div>
                        <div class="swatch-element-list">
                            <div class="position-relative">
                                <input id="swatch-0-m" type="radio" name="option-0" value="M" checked="">
                                    <label>
                                        M
                                    </label>
                            </div>
                            <div class="position-relative">
                                <input id="swatch-0-l" type="radio" name="option-0" value="L">
                                    <label>
                                        L
                                    </label>
                            </div>
                        </div>
                    </div>
                    <div class="swatch clearfix swatch-color">
                        <div class="header1">
                            <span>Màu sắc:
                                <span class="swatch-value">"backend"</span>
                            </span>
                        </div>
                        <div class="swatch-element-list">
                            <div class="position-relative">
                                <input id="swatch-1-do" type="radio" name="option-1" value="Đỏ" checked="">
                                    <label>
                                        Đỏ
                                    </label>
                            </div>
                            <div class="position-relative">
                                <input id="swatch-1-trang" type="radio" name="option-1" value="Trắng">
                                    <label>
                                        Trắng
                                    </label>
                            </div>
                            <div class="position-relative">
                                <input id="swatch-1-xanh" type="radio" name="option-1" value="Xanh">
                                    <label>
                                        Xanh
                                    </label>
                            </div>
                        </div>
                    </div>
                    <div class="tong"><h3>Tổng tiền:</h3><p id="tong">0 đ</p></div>
                </div>
                <div class="form-product">
                    <div class="form_button_details w-100">
                        <div class="soluong soluong_type_1">
                            <div class="custom input_number_product custom-btn-number">
                                <button class="minus"type="button" onclick=""><i class="bi bi-dash"></i></button>
                                <input class="sl" asp-for="SoLuong" onchange="" id="id1" type="text" value="0" min="0">
                                <button class="plus" type="button" onclick=""><i class="bi bi-plus"></i></button>
                            </div>
                            <div class="button_actions mb-0">
                                <div class="themgiohang">
                                    <button type="submit" class="btn btn-cart">THÊM VÀO GIỎ</button>
                                </div>
                            </div>
                        </div>
                        <div class="button_actions">
                            <button type="submit" class="muahang">MUA NGAY</button>

                        </div>
                    </div>
                    <div class="product-policises-wrapper">
                        <ul class="product-policises list-unstyled py-sm-3 px-sm-3 m-0">
                            <li class="media">
                                <div class="mr-2">
                                    <img class="img-fluid " width="24" height="24" src="//bizweb.dktcdn.net/100/448/042/themes/878628/assets/policy_product_image_1.png?1670556174956" alt="Giao hàng toàn quốc">
                                </div>
                                <div class="media-body">
                                    Giao hàng toàn quốc
                                </div>
                            </li>
                            <li class="media">
                                <div class="mr-2">
                                    <img class="img-fluid " width="24" height="24" src="//bizweb.dktcdn.net/100/448/042/themes/878628/assets/policy_product_image_2.png?1670556174956" alt="Tích điểm tất cả sản phẩm">
                                </div>
                                <div class="media-body">
                                    Tích điểm tất cả sản phẩm
                                </div>
                            </li>
                            <li class="media">
                                <div class="mr-2">
                                    <img class="img-fluid " width="24" height="24" src="//bizweb.dktcdn.net/100/448/042/themes/878628/assets/policy_product_image_3.png?1670556174956" alt="Giảm 5% khi thanh toán online">
                                </div>
                                <div class="media-body">
                                    Giảm 5% khi thanh toán online
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

                <section class="section sec_tab product-tabs section_product_top ">
                    <div class="container">
                        <div class="mota"><h3>Mô Tả</h3>Áo sơ mi là trang phục lịch sự, trang nhã,
                            luôn đem lại phong cách thanh lịch cho nam giới. Tuy được sử dụng rộng rãi
                            nhưng việc lựa chọn áo sơmi sao cho phù hợp với mỗi người thì...
                        </div>

                    </div>
                </section>
            </div>
        </div>
    </div>
</section>
