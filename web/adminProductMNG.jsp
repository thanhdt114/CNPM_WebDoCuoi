<%-- 
    Document   : product
    Created on : Oct 1, 2021, 10:20:35 PM
    Author     : thanhbao
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<title>ProductMNG</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
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
        <link rel="stylesheet" type="text/css" href="css/adminMNG.css">
<!--===============================================================================================-->
<link href="https://fonts.googleapis.com/css?family=Dancing+Script|Itim|Lobster|Montserrat:500|Noto+Serif|Nunito|Patrick+Hand|Roboto+Mono:100,100i,300,300i,400,400i,500,500i,700,700i|Roboto+Slab|Saira" rel="stylesheet">
</head>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body class="animsition">
	
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
    
    <table>
        <tr>
            <td style="background-color: #F1F1F1; vertical-align: top;" >
                <div class="w3-container" >

                <div class="w3-bar-block w3-light-grey">
                    <!-- Logo desktop -->	
                    <a href="adminProductMNG.jsp" class="logo">
                        <img src="images/icons/Logo_Wedding-14.png" alt="IMG-LOGO" style="margin-left: 25px; width: 70%;">
                    </a>
                    
                    <a href="OrderMNGCtrl" class="w3-bar-item w3-button">
                        <i class='fas icon-nav'>&#xf015;</i>Home</a>
                    <a href="OrderMNGCtrl" class="w3-bar-item w3-button ">
                        <i class='fas icon-nav'>&#xf187;</i>Quản lý đơn hàng</a>
                    <a href="ProductMNGCtrl" class="w3-bar-item w3-button ">
                        <i class='fas icon-nav'>&#xf1b2;</i>Quản lý sản phẩm</a>
                    <a href="AccountMNGCtrl" class="w3-bar-item w3-button ">
                        <i class="fa icon-nav">&#xf2b9;</i>Quản lý tài khoản</a>
                </div>

                </div>
            </td>
            
            <td style="padding-top: 90px; padding-bottom: 50px; vertical-align: top;" >
                <div class='edit-ad' style="position: unset;">
                    <h2>Danh sách sản phẩm:</h2> <br>
                    
                    <table class="tb-edit">
                    <tr>
                        <th class="col-edit">ID</th>
                        <th class="col-edit">Tên sản phẩm</th>
                        <th class="col-edit">Hình ảnh</th>
                        <th class="col-edit">Giá bán</th>
                        <th class="col-edit">Giá thuê</th>
                        <th class="col-edit">ID Category</th>
                        <th class="col-edit">Thuộc tính</th>
                        <th class="col-edit">Màu</th>
                        <th class="col-edit">Tình trạng</th>
                        <th class="col-edit">Chi tiết</th>
                    </tr>
                    <c:forEach var ="item" items="${listProducts}">
                        <tr>
                            <td class="col-edit">${item.getIDProd()}</td>
                            <td class="col-edit">${item.getTenSanPham()}</td>
                            <td class="col-edit">
                                <div class="img-mng">
                                    <img src=${item.getHinhAnh()} alt="IMG"> 
                                </div>
                                
                            </td>
                            <td class="col-edit">${item.getGiaBan()}</td>
                            <td class="col-edit">${item.getGiaThue()}</td>
                            <td class="col-edit">${item.getIDCat()}</td>
                            <td class="col-edit">${item.getThuoctinh()}</td>
                            <td class="col-edit">${item.getMau()}</td>
                            <td class="col-edit">${item.getTinhTrang()}</td>
                            <td class="col-edit">
                                <a href="DetailProductMNGCtrl?idProduct=${item.getIDProd()}">
                                    <i class='fas icon-nav' >&#xf044;</i>
                                </a>
                                
                            </td>
                        </tr>
                    </c:forEach>
                    
                    
                  </table>
                </div>
                
            </td>
        </tr>
    </table>

    

    <!-- Footer -->
    <div class="p-t-40" style='background-color: #222;'>
        <p class="stext-107 cl6 txt-center" style="margin-top: -32px; background-color: #222;" >
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> &amp; distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
        </p>
    </div>
    
    
</body>
</html>