<%-- 
    Document   : login
    Created on : Nov 21, 2021, 11:36:10 AM
    Author     : thanh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Đăng Nhập</title>
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
    <body>
        <c:if test = "${isLogin == 0}">
            <script>
                window.alert("Tên tài khoản hoặc mật khẩu không đúng!");
            </script>
        </c:if>
        <!-- Header -->
        <header class="header-v4">
            <!-- Header desktop -->
            <div>
                <div class="wrap-menu-desktop fix-header">
                    <nav class="limiter-menu-desktop container">
                        <!-- Logo desktop -->		
                        <a href="index.jsp" class="logo" style="margin-right: 20px">
                            <img src="images/icons/Logo_Wedding-14.png" alt="IMG-LOGO">
                        </a>

                        <h2 class="fs-24" style="color: black">
                            Chào mừng đến với Diễm My. Đăng nhập ngay!
                        </h2>
                    </nav>
                </div>	
            </div>
        </header>

        <div class="login-body" style="background-image: url('images/login_background_2.png')">
            <!--Đăng Nhập-->
            <div class="login-position">
                <form class="form-login" action="LoginCtrl?iDProd=${param.iDProd}" method="post">
                    <div class="imgcontainer">
                        <p>
                            Đăng Nhập
                        </p>
                    </div>

                    <div class="container-login">  
                        <div class="d_username"> 
                            <label class="lableInput"><b>Tài khoản</b></label>
                            <input type="username" placeholder="Nhập tài khoản" name="username" requied> 
                        </div>
                        
                        <div class="d_password"> 
                            <label class="lableInput"><b>Mật khẩu</b></label> 
                            <input type="password" placeholder="Nhập mật khẩu" name="password" requied>
                        </div>
                        
                        <button class="login-button" type="submit">Đăng nhập</button>
                    </div>

                    <div class="container-login" style="background-color:#f1f1f1">
                        <p>
                            Hãy đăng nhập để chúng tôi biết bạn là ai! <br>
                            Bạn có thể nhận được những ưu đãi từ Diễm My
                        </p> 
                        <br>
                        <p class="cancle">
                            Trở lại mua sắm 
                            <a href="
                                <c:url value="ProductDetailCtrl">
                                    <c:param name="iDProd" value="${param.iDProd}"></c:param>
                                </c:url>">
                                <button type="button" class="cancelbtn">Hủy</button>
                            </a>
                        </p>

                        
                        
                    </div>


                </form>
            </div>
        </div>




        <!-- Footer -->
        <footer class="bg3 p-t-32 p-b-0">
            <jsp:include page="footer.jsp"></jsp:include>
        </footer>

    </body>
</html>
