<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="/views/public/css/management/base.css">
    <link rel="stylesheet" href="/views/public/css/management/content.css">
    <link rel="stylesheet" href="/views/public/css/management/product/content.css">
    <title>product</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="web_body">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div class="content__wrapper">
        <div class="content">
            <div class="content__header">
                <div>
                    <div class="search">
                        <input class="search--input" type="text" onkeypress="checkEnterClick(event)" placeholder="Nhập tên hoặc ID">
                    </div>
                    <img src="/views/public/icon/icon_add.png" class="content__header--buttonAdd" alt="">
                </div>
                <div class="">
                    <div id="filter_product">
                        <div class="filter_product-price">
                            <select name="" id="select_price">
                                <option value="all">All</option>
                                <option value="min">Dưới 500.000</option>
                                <option value="middle">500.000 - 1.500.000</option>
                                <option value="max">Trên 1.500.000</option>
                            </select>
                        </div>
                        <div class="filter_product-category">
                            <select name="" id="select_category">
                                <option value="all">All</option>
                                <option value="vest">Áo vest</option>
                                <option value="unisex">Áo Unisex</option>
                                <option value="shirt ">Áo sơ mi</option>
                            </select>
                        </div>
                    </div>
                    <img src="/views/public/icon/icon_wastebasket.png" class="content__header--buttonDel" alt="">
                </div>

            </div>
            <div class="table_wrapper">
                <table class="table_product">

                </table>
            </div>
            <form action="" method="POST" id="form-inforProduct">
                <section id="inforProduct_wrapper">
                    <div id="form-inforProduct__image">
                        <div class="main-image_wrapper">
                            <div class="main-image"></div>
                        </div>
                        <div class="list-image">
                            <i class="fa-solid fa-chevron-left swiper-button-prev" onclick="plusImages(-1)"></i>
                            <i class="fa-solid fa-chevron-right swiper-button-next" onclick="plusImages(1)"></i>
                            <div class="image-item_wrapper">
                                <div class="image-item addImage">
                                    <i class="fa-solid fa-plus"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="form-inforProduct__infor">
                        <section style="margin-bottom: 1rem;">
                            <input type="text" id="product_name" value="" placeholder="Nhập tên sản phẩm">
                            <span class="form-message"></span>
                        </section>
                        <section>
                            <input type="text" id="product_price" value="" placeholder="Nhập giá sản phẩm">
                            <span class="form-message"></span>
                        </section>
                        <div id="product_color">
                            <label>Màu sắc</label>
                            <i class="fa-solid fa-circle-plus icon-plus"></i>
                            <div class="list-color">
                                <section>
                                    <input type="text"  class="item-color" value="" placeholder="Nhập tên màu">
                                    <!-- <i class="fa-solid fa-circle-minus icon-minus"></i> -->
                                    <span class="form-message"></span>
                                </section>
                            </div>
                        </div>
                        <div id="product_size">
                            <label>Size</label>
                            <i class="fa-solid fa-circle-plus icon-plus"></i>
                            <div class="list-size">
                                <section>
                                    <input type="text"  class="item-size" value="" placeholder="Nhập size"></input>
                                    <!-- <i class="fa-solid fa-circle-minus icon-minus"></i> -->
                                    <span class="form-message"></span>
                                </section>
                            </div>
                        </div>
                        <div id="product_amount">
                            <label>Số lượng:</label>
                            <section>
                                <input type="text" value="" placeholder="Nhập số lượng"></input>
                                <span class="form-message"></span>
                            </section>
                        </div>
                        <button class="button-update">Cập nhật</button>
                        <button class="button-insert">Thêm</button>
                    </div>
                </section>
                <textarea id="form-inforProduct__description" style="white-space: pre-wrap;"></textarea>
            </form>
        </div>
    </div>
</div>
<div id="toast"></div>
<script src="/views/public/js/ProductManagement/getElement.js"></script>
<script src="/views/public/js/main.js"></script>
<script src="/views/public/js/ProductManagement/checkInfo.js"></script>
<script src="/views/public/js/ProductManagement/product.js"></script>
</body>
</html>


