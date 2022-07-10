<%-- 
    Document   : header
    Created on : Nov 18, 2021, 8:57:46 PM
    Author     : thanhbao
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/login.css">
    </head>
    <body>
        <!-- Header -->
        <header class="header-v4">
            <!-- Header desktop -->
            <div class="container-menu-desktop">
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
        </header>
    </body>
</html>
