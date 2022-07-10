<%-- 
    Document   : checkout
    Created on : Nov 22, 2021, 10:04:53 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Checkout</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/IconLogo1.png"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/checkout.css">
    </head>
    <body>
        <!-- Header -->
        <header class="header-v4">
            <!-- Header desktop -->
            <div>
                <!-- Topbar -->
                <div class="top-bar">
                    <div class="content-topbar flex-sb-m h-full container">
                        <div class="left-top-bar">
                        </div>

                        <div class="right-top-bar flex-w h-full">
                            <c:choose> 
                                <c:when test = "${email == null}">
                                    <a href="login.jsp" class="flex-c-m trans-04 p-lr-25" style="text-transform: none;">Đăng Nhập</a>
                                </c:when>

                                <c:otherwise>
                                    <c:set var = "emailU" value = "${email}"/>
                                    <c:set var = "userName" value = "${fn:substringBefore(emailU, '@')}" />
                                    <a href="#" class="flex-c-m trans-04 p-lr-25" style="text-transform: none; background-color: #800000;">${userName}</a>
                                    
                                    <a class="flex-c-m trans-04 p-lr-25" href="LogoutCtrl">Đăng Xuất</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="wrap-menu-desktop fix-header">
                    <nav class="limiter-menu-desktop container">
                        <!-- Logo desktop -->		
                        <a href="index.jsp" class="logo " style="margin-right: 25px">
                            <img src="images/icons/Logo_Wedding-14.png" alt="IMG-LOGO">
                        </a>

                        <h2 class="fs-24" style="color: black">
                            Thanh Toán
                        </h2>
                    </nav>
                </div>	
            </div>
        </header>

        <div class="order" style="background-image: url('images/aleksandar-pasaric-02.jpg');">
            <div class="row">
                <div class="col-75">
                    <div class="container-order">
                        <form action="CheckoutCtrl">

                            <div class="row">
                                <div class="col-50">
                                    <br>
                                    <h3>Địa Chỉ Giao Hàng</h3> <br>
                                    <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                    <input type="text" id="fname" name="fname" placeholder="Enter Your Full Name">
                                    <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                    <input type="text" id="adr" name="address" placeholder="Enter Your Address">
                                    <label for="phone"><i class="fa fa-phone"></i> Phone</label>
                                    <input type="text" id="city" name="phone" placeholder="Enter Your Phone">


                                </div>

                                <div class="col-50">
                                    <br>
                                    <h3>Thông tin cá nhân</h3> <br>
                                    <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                    <input type="text" id="email" name="email" value="${email}" readonly>
                                    <label for="date"><i class="fa fa-calendar"></i> Date</label>
                                    <input type="localdate" id="date" name="date" value="${date}" readonly>


                                </div>

                            </div>

                            <br>

                            <div class="end">
                                <div class="infoCheckout">
                                    Nhấn "Đặt hàng" đồng nghĩa với việc bạn đồng ý tuân theo
                                    <a href="law.jsp" target="_blank"> Quy định DiemMy</a>
                                </div>
                                
                                <input type="hidden" name="total" value="${total}"/>

                                <span class="checkout">
                                    <input type="submit" value="Đặt Hàng" class="btn">
                                </span>
                            </div>

                        </form>
                    </div>
                </div>
                <div class="col-25">
                    <div class="container-order">
                        <br>
                        <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>${soSP}</b></span></h4>
                        <c:forEach var="item" items="${listCartProduct}">
                            <c:choose>
                                <c:when test="${item.getSoLuong() == 1}">
                                    <p><a href="#">${item.getNameProduct()}</a> <span class="price">${item.getTotalCurrencyFormat()} VNĐ</span></p>
                                </c:when>
                                    
                                <c:otherwise>
                                    <p><a href="#">${item.getNameProduct()} x ${item.getSoLuongCurrencyFormat()}</a> <span class="price"> ${item.getTotalCurrencyFormat()} VNĐ</span></p>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <hr>
                        <p>Total <span class="price" style="color:black"><b>${totalString} VNĐ</b></span></p>
                    </div>
                </div>
            </div>
        </div>


        <!-- Footer -->
        <footer class="bg3 p-t-32 p-b-0">
            <jsp:include page="footer02.jsp"></jsp:include>
        </footer>
    </body>
</html>
