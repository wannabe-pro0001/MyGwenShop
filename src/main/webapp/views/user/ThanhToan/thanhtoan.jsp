<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/user/ThanhToan/thanhtoan.css"
</head>

<body>
    <div class="wrap">
        <form style="display: flex; width: 100%;">
        <main class="main">
            <header class="main__header">
                <div>
                    <h1 class="shop__name">
                        <a href="/">
                            Gwen Shop
                        </a>
                    </h1>
                </div>
            </header>

            <div class="main__content">

                <div class="col col--two">
                    <div class="section__header">
                        <div class="layout-flex">
                            <h2 class="section__title layout-flex__item layout-flex__item--stretch">
                                Thông tin nhận hàng
                            </h2>
                        </div>
                    </div>
                    <div class="section__content">
                        <div class="fieldset">
                            <div class="field " data-bind-class="{'field--show-floating-label': email}">
                                <div class="field__input-wrapper">
                                    <label for="email" class="field__label">
                                        Email
                                    </label>
                                    <input name="email" id="email" type="email" class="field__input" data-bind="email" value="${sessionScope.account.email}">
                                </div>
                            </div>


                            <div class="field " data-bind-class="{'field--show-floating-label': billing.name}">
                                <div class="field__input-wrapper">
                                    <label for="billingName" class="field__label">Họ và tên</label>
                                    <input name="billingName" id="billingName" type="text" class="field__input" data-bind="billing.name" value="${sessionScope.account.fullName}">
                                </div>
                            </div>

                            <div class="field " data-bind-class="{'field--show-floating-label': billing.phone}">
                                <div class="field__input-wrapper field__input-wrapper--connected" data-define="{phoneInput: new InputPhone(this)}">
                                    <label for="billingPhone" class="field__label">
                                        Số điện thoại (tùy chọn)
                                    </label>
                                    <input name="billingPhone" id="billingPhone" type="tel" class="field__input" data-bind="billing.phone" value="${sessionScope.account.phoneNumber}">
                                </div>
                            </div>
                            <div class="field " data-bind-class="{'field--show-floating-label': billing.address}">
                                <div class="field__input-wrapper">
                                    <label for="billingAddress" class="field__label">
                                        Địa chỉ (tùy chọn)
                                    </label>
                                    <input name="billingAddress" id="billingAddress" type="text" class="field__input" data-bind="billing.address" value="${sessionScope.account.addr}">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="fieldset">
                        <h3 class="visually-hidden">Ghi chú</h3>
                        <div class="field" data-bind-class="{'field--show-floating-label': note}">
                            <div class="field__input-wrapper">
                                <label for="note" class="field__label">
                                    Ghi chú (tùy chọn)
                                </label>
                                <textarea name="note" id="note" type="text" class="field__input" data-bind="note"></textarea>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="col col--two">
					<section class="section">
                        <div class="section__header">
                            <div class="layout-flex">
                                <h2 class="section__title layout-flex__item layout-flex__item--stretch">
                                    <i class="fa fa-credit-card fa-lg section__title--icon hide-on-desktop"></i>
                                    Phương thức vận chuyển
                                </h2>
                            </div>
                        </div>
                        <div class="section__content">
							<div class="content-box" data-define="{paymentMethod: undefined}">
								<div class="content-box__row">
									<div class="radio-wrapper">
										<div class="radio__input">
											<input name="GH" id="giaohangtannoi" type="radio" class="input-radio" value="ghtn">
										</div>
										<label for="giaohangtannoi" class="radio__label">
											<span class="radio__label__primary">Giao hàng tận nơi</span>
											<!-- <span class="radio__label__accessory">
												<span class="radio__label__icon">
													<i class="bi bi-cash"></i>
												</span>
											</span> -->
										</label>
									</div>
								</div>
							</div>
						</div>
                    </section>

                    <section class="section">
                        <div class="section__header">
                            <div class="layout-flex">
                                <h2 class="section__title layout-flex__item layout-flex__item--stretch">
                                    <i class="fa fa-credit-card fa-lg section__title--icon hide-on-desktop"></i>
                                    Thanh toán
                                </h2>
                            </div>
                        </div>
                        <div class="section__content">
                            <div class="content-box" data-define="{paymentMethod: undefined}">
                                <div class="content-box__row">
                                    <div class="radio-wrapper">
                                        <div class="radio__input">
                                            <input name="TT" id="thanhtoan" type="radio" class="input-radio" value="thdh">
                                        </div>
                                        <label for="thanhtoan" class="radio__label">
                                            <span class="radio__label__primary">Thanh toán khi giao hàng (COD)</span>
                                            <span class="radio__label__accessory">
                                                <span class="radio__label__icon">
                                                    <i class="bi bi-cash"></i>
                                                </span>
                                            </span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
        </main>
        <aside class="sidebar">
			<div class="sidebar__header">
				<h2 class="sidebar__title">
					Đơn hàng (? sản phẩm)
				</h2>
			</div>
			<div class="sidebar__content">
				<div id="order-summary" class="order-summary order-summary--is-collapsed">
					<div class="order-summary__sections">
                        <c:forEach items="${cartItem}" var="item">
                            <div class="sanphamtrongDonHang">
                                <img class="anh_Sp" onerror="this.src='/image/duphong.webp'" src="${item.getProduct().getProductImages().get(0).getImage()}" />
                                <p class="ten_sp" style="line-height:50px; width:200px;">${item.getProduct().name}</p>
                                <p class="gia_sp" style="line-height:25px; width:50px; padding-top:12px">${item.amount}</p>

                                <p class="gia_sp" style="line-height:50px; width:150px;">${item.amount*item.getProduct().price}</p>

                            </div>
                        </c:forEach>

						<div class="order-summary__section order-summary__section--total-lines order-summary--collapse-element" data-define="{subTotalPriceText: '104.640.000₫'}" data-tg-refresh="refreshOrderTotalPrice" id="orderSummary">
							<table class="total-line-table">
								<tbody class="total-line-table__tbody">
									<tr class="total-line total-line--subtotal">
										<th class="total-line__name">
											Tạm tính
										</th>
										<td class="total-line__price">104.640.000₫</td>
									</tr>

									<tr class="total-line total-line--shipping-fee">
										<th class="total-line__name">
											Phí vận chuyển
										</th>
										<td class="total-line__price" data-bind="getTextShippingPrice()">-</td>
									</tr>

								</tbody>
								<tfoot class="total-line-table__footer">
									<tr class="total-line payment-due">
										<th class="total-line__name">
											<span class="payment-due__label-total">
												Tổng cộng
											</span>
										</th>
										<td class="total-line__price">
											<span class="payment-due__price" data-bind="getTextTotalPrice()">104.640.000₫</span>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>

						<div class="order">
							<div class="back_gioHang">

								<a href="#"> <i class="bi bi-chevron-compact-left"></i>Quay về giỏ hàng</a>
							</div>
							<div >
								<button class="btn_Dathang" type="submit">Đặt hàng</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</aside>
        </form>
    </div>