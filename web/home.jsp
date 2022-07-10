<%-- 
    Document   : product
    Created on : Oct 1, 2021, 10:20:35 PM
    Author     : thanhbao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Diễm My Studio</title>
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
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/slick/slick.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/MagnificPopup/magnific-popup.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <!--===============================================================================================-->
        <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Itim|Lobster|Montserrat:500|Noto+Serif|Nunito|Patrick+Hand|Roboto+Mono:100,100i,300,300i,400,400i,500,500i,700,700i|Roboto+Slab|Saira" rel="stylesheet">

    </head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <body class="animsition">

        <!-- Header -->
        <!-- Header -->
        <header>
            <!-- Header desktop -->
            <div class="container-menu-desktop">
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
                
                <div class="wrap-menu-desktop">
                    <nav class="limiter-menu-desktop container">

                        <!-- Logo desktop -->		
                        <a href="index.jsp" class="logo">
                            <img src="images/icons/Logo_Wedding-14.png" alt="IMG-LOGO">
                        </a>

                        <!-- Menu desktop -->
                        <div class="menu-desktop">
                            <ul class="main-menu">
                                <li>
                                    <a href="index.jsp">Trang Chủ</a>
                                </li>
                                <li>
                                    <a href="productP">Sản Phẩm</a>

                                </li>
                                <li class="label1" data-label1="hot">
                                    <a href="CategoryCtrl">Áo Cưới</a>
                                    <ul class="sub-menu">
                                        <li><a href="AocuoiCtrlDG">Đơn Giản</a></li>
                                        <li><a href="AocuoiCtrlCC">Công Chúa</a></li>
                                        <li><a href="AocuoiCtrlCD">Cổ Điển</a></li>
                                        <li><a href="AocuoiCtrlHD">Hiện Đại</a></li>
                                    </ul>
                                </li>
                                <li class="label1" data-label1="hot">
                                    <a href="CategoryCtrlAoVest">Đồ Vest</a>
                                    <ul class="sub-menu">
                                        <li><a href="AovestCtrlA">Áo Vest</a></li>
                                        <li><a href="AovestCtrlQ">Quần Vest</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="CategoryCtrlAoDai">Áo Dài Cưới</a>

                                </li>

                                <li>
                                    <a href="service.jsp">Dịch Vụ Cưới</a>

                                </li>
                                <li>
                                    <a href="law.jsp">Quy Định</a>
                                </li>

                                <li>
                                    <a href="contact.jsp">Liên Hệ</a>
                                </li>


                            </ul>
                        </div>	
                        <c:if test = "${email != null}">
                            <!-- Icon header -->
                            <div class="wrap-icon-header flex-w flex-r-m">
                                <a href="CartCtrl"><img src="images/icons/icon_cart_shopping.png" height="30px" width="30px"></a>
                            </div>
                        </c:if>
                    </nav>
                </div>	
            </div>

            <!-- Header Mobile -->
            <div class="wrap-header-mobile">
                <!-- Logo moblie -->		
                <div class="logo-mobile">
                    <a href="index.jsp"><img src="images/icons/Logo_Wedding-14.png" alt="IMG-LOGO"></a>
                </div>

                <!-- Icon header -->
                <div class="wrap-icon-header flex-w flex-r-m m-r-15">
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                    </div>
                    <div>
                        <a href="shopping-cart.jsp"><img src="images/icons/icon_cart_shopping.png" height="30px" width="30px"></a>
                    </div>
                </div>

                <!-- Button show menu -->
                <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </div>
            </div>
            <!-- Menu Mobile -->
            <div class="menu-mobile">
                <ul class="topbar-mobile">
                    <li>
                        <div class="left-top-bar">
                        </div>
                    </li>

                    <li>
                        <div class="right-top-bar flex-w h-full">

                            <a href="#" class="flex-c-m p-lr-10 trans-04">
                                ĐĂNG NHẬP
                            </a>

                            <a href="#" class="flex-c-m p-lr-10 trans-04">
                                VN
                            </a>
                        </div>
                    </li>
                </ul>
                <ul class="main-menu-m">
                    <li>
                        <a href="index.jsp">Trang Chủ</a>
                    </li>

                    <li>
                        <a href="productP">Sản Phẩm</a>
                    </li>

                    <li>
                        <a href="CategoryCtrl" class="label1 rs1" data-label1="hot">Áo Cưới</a>
                        <ul class="sub-menu">
                            <li><a href="AocuoiCtrlDG">Đơn Giản</a></li>
                            <li><a href="AocuoiCtrlCC">Công Chúa</a></li>
                            <li><a href="AocuoiCtrlCD">Cổ Điển</a></li>
                            <li><a href="AocuoiCtrlHD">Hiện Đại</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="CategoryCtrlAoVest" class="label1 rs1" data-label1="hot">Đồ Vest</a>
                        <ul class="sub-menu">
                            <li><a href="AovestCtrlA">Áo Vest</a></li>
                            <li><a href="AovestCtrlQ">Quần Vest</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="CategoryCtrlAoDai">Áo Dài Cưới</a>

                    </li>
                    <li>
                        <a href="service.jsp">Dịch Vụ Cưới</a>
                    </li>
                    <li>
                        <a href="law.jsp">Quy Định</a>
                    </li>

                    <li>
                        <a href="contact.jsp">Liên Hệ</a>
                    </li>
                </ul>
            </div>

            <!-- Modal Search -->
            <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
                <div class="container-search-header">
                    <button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
                        <img src="images/icons/icon-close2.png" alt="CLOSE">
                    </button>

                    <form class="wrap-search-header flex-w p-l-15">
                        <button class="flex-c-m trans-04">
                            <i class="zmdi zmdi-search"></i>
                        </button>
                        <input class="plh3" type="text" name="search" placeholder="Search...">
                    </form>
                </div>
            </div>
        </header>
        <!-- Slider -->
        <section class="section-slide">
            <div class="wrap-slick1">
                <div class="slick1">
                    <div class="item-slick1" style="background-image: url(images/Concept_06.jpg);">
                        <div class="container h-full">
                            <div class="flex-col-l-m h-full p-t-100 p-b-30 respon5">
                                <div class="layer-slick1 animated visible-false" data-appear="fadeInDown" data-delay="0">
                                    <span class="ltext-101 cl2 respon2">
                                        VÁY CƯỚI 2021
                                    </span>
                                </div>

                                <div class="layer-slick1 animated visible-false" data-appear="fadeInUp" data-delay="800">
                                    <h2 class="ltext-201 cl2 p-t-19 p-b-43 respon1">
                                        NEW SEASON
                                    </h2>
                                </div>

                                <div class="layer-slick1 animated visible-false" data-appear="zoomIn" data-delay="1600">
                                    <a href="CategoryCtrl" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04">
                                        Shop Now
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="item-slick1" style="background-image: url(images/VetHeader.jpg);">
                        <div class="container h-full">
                            <div class="flex-col-l-m h-full p-t-100 p-b-30 respon5">
                                <div class="layer-slick1 animated visible-false" data-appear="rollIn" data-delay="0">
                                    <span class="ltext-101 cl2 respon2">
                                        ĐỒ VEST 2021
                                    </span>
                                </div>

                                <div class="layer-slick1 animated visible-false" data-appear="lightSpeedIn" data-delay="800">
                                    <h2 class="ltext-201 cl2 p-t-19 p-b-43 respon1">
                                        NEW SEASON
                                    </h2>
                                </div>

                                <div class="layer-slick1 animated visible-false" data-appear="slideInUp" data-delay="1600">
                                    <a href="CategoryCtrlAoVest" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04">
                                        Shop Now
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="item-slick1" style="background-image: url(images/met1.jpg);">
                        <div class="container h-full">
                            <div class="flex-col-l-m h-full p-t-100 p-b-30 respon5">
                                <div class="layer-slick1 animated visible-false" data-appear="rotateInDownLeft" data-delay="0">
                                    <span class="ltext-101 cl2 respon2">
                                        ÁO DÀI 2021
                                    </span>
                                </div>

                                <div class="layer-slick1 animated visible-false" data-appear="rotateInUpRight" data-delay="800">
                                    <h2 class="ltext-201 cl2 p-t-19 p-b-43 respon1">
                                        New arrivals
                                    </h2>
                                </div>

                                <div class="layer-slick1 animated visible-false" data-appear="rotateIn" data-delay="1600">
                                    <a href="CategoryCtrlAoDai" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04">
                                        Shop Now
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <!-- Banner -->
        <div class="sec-banner bg0 p-t-80 p-b-50">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-xl-4 p-b-30 m-lr-auto">
                        <!-- Block1 -->
                        <div class="block1 wrap-pic-w">
                            <img src="images/Vay_Cuoi_2.jpg" alt="IMG-BANNER">

                            <a href="CategoryCtrl" class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
                                <div class="block1-txt-child1 flex-col-l">
                                    <span class="block1-name ltext-102 trans-04 p-b-8">
                                        ÁO CƯỚI
                                    </span>

                                    <span class="block1-info stext-102 trans-04">
                                        Spring 2021
                                    </span>
                                </div>

                                <div class="block1-txt-child2 p-b-4 trans-05">
                                    <div class="block1-link stext-101 cl0 trans-09">
                                        Shop Now
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>

                    <div class="col-md-6 col-xl-4 p-b-30 m-lr-auto">
                        <!-- Block1 -->
                        <div class="block1 wrap-pic-w">
                            <img src="images/Vest.png" alt="IMG-BANNER">

                            <a href="CategoryCtrlAoVest" class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
                                <div class="block1-txt-child1 flex-col-l">
                                    <span class="block1-name ltext-102 trans-04 p-b-8">
                                        VEST
                                    </span>

                                    <span class="block1-info stext-102 trans-04">
                                        Spring 2021
                                    </span>
                                </div>

                                <div class="block1-txt-child2 p-b-4 trans-05">
                                    <div class="block1-link stext-101 cl0 trans-09">
                                        Shop Now
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>

                    <div class="col-md-6 col-xl-4 p-b-30 m-lr-auto">
                        <!-- Block1 -->
                        <div class="block1 wrap-pic-w">
                            <img src="images/Ao_dai.jpg" alt="IMG-BANNER">

                            <a href="CategoryCtrlAoDai" class="block1-txt ab-t-l s-full flex-col-l-sb p-lr-38 p-tb-34 trans-03 respon3">
                                <div class="block1-txt-child1 flex-col-l">
                                    <span class="block1-name ltext-102 trans-04 p-b-8">
                                        ÁO DÀI
                                    </span>

                                    <span class="block1-info stext-102 trans-04">
                                        New Trend
                                    </span>
                                </div>

                                <div class="block1-txt-child2 p-b-4 trans-05">
                                    <div class="block1-link stext-101 cl0 trans-09">
                                        Shop Now
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Product -->
        <div class="bg0 m-t-23 p-b-0">
            <div class="container">
                <h3>Sản Phẩm</h3>
                <br>
                <!--<div class="flex-w flex-sb-m p-b-52">
                        <div class="flex-w flex-l-m filter-tope-group m-tb-10">
                                <a href="product"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter="*"  style="font-family: Roboto;">
                                        Tất cả
                                    </button></a>

                                <a href="CategoryCtrl"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".women"  style="font-family: Roboto;">
                                        Áo Cưới
                                    </button></a>

                                <a href="CategoryCtrlAoVest"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".men" style="font-family: Roboto;">
                                        Đồ Vest
                                    </button></a>

                                <a href="CategoryCtrlAoDai"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".bag" style="font-family: Roboto;">
                                        Áo Dài
                                    </button></a>
                        </div>
                </div>-->

                <div class="row isotope-grid">
                    <c:forEach var ="item" items="${listproduct}">
                        <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                            <!-- Block2 -->
                            <div class="block2">
                                <div class="block2-pic hov-img0">
                                    <a href="ProductDetailCtrl?iDProd=${item.getIDProd()}"><img src="${item.hinhAnh}" alt="#"></a>
                                </div>

                                <div class="block2-txt flex-w flex-t p-t-14">
                                    <div class="block2-txt-child1 flex-col-l ">
                                        <a href="ProductDetailCtrl?iDProd=${item.getIDProd()}" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                            ${item.getTenSanPham()}
                                        </a>

                                        <span class="stext-105 cl3" style="font-family: Roboto; font-size: 13px;">
                                            Giá bán: ${item.giaBan} VNĐ
                                        </span>
                                        <span class="stext-105 cl3" style="font-family: Roboto; font-size: 13px;">
                                            Giá cho thuê: ${item.giaThue} VNĐ
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </div>


            <!-- Footer -->
            <footer class="bg3 p-t-32 p-b-0">
                <jsp:include page="footer.jsp"></jsp:include>
            </footer>
    </body>
</html>