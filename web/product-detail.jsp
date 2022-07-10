<%-- 
    Document   : product
    Created on : Oct 1, 2021, 10:19:31 PM
    Author     : thanhbao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <title>Thông Tin Sản Phẩm</title>
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
        <!--===============================================================================================-->
    </head>
    <body class="animsition">

        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Product Detail -->
            <section class="sec-product-detail bg0 p-t-65 p-b-60">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-lg-7 p-b-30">
                            <div class="p-l-25 p-r-30 p-lr-0-lg">
                                <div class="wrap-slick3 flex-sb flex-w">
                                    <div class="wrap-slick3-dots"></div>
                                    <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>
                                    <div class="wrap-pic-w pos-relative">
                                        <img src="<c:out value="${detail.hinhAnh}"></c:out>" alt="#">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-5 p-b-30">
                            <div class="p-r-50 p-t-5 p-lr-0-lg">
                                <h4 class="mtext-105 cl2 js-name-detail p-b-14" style="font-family: Roboto;font-size:25px;color: #717fe0">
                                    Thông tin chi tiết: 
                                <c:out value="${detail.tenSanPham}"></c:out>
                                </h4>
                                <span class="mtext-106 cl2">
                                    <pre style="font-family: Roboto;font-size:18px;"> 
Mẫu: ${detail.mau}
Tình trạng :${detail.tinhTrang} hàng</pre>
                                <pre style="font-family: Roboto;font-size:18px;color: gray">
Giá
                                </pre>
                                <pre style="font-family: Roboto;font-size:18px;">
Giá bán: ${detail.giaBan} VNĐ
Giá cho thuê: ${detail.giaThue} VNĐ</pre>

                            </span>
                            <!--  -->
                            <form action="AddToCartCtrl" method="POST">
                                <div class="p-t-33">
                                    <div class="flex-w flex-r-m p-b-10">
                                        <div class="size-203 flex-c-m respon6">
                                            Chọn
                                        </div>

                                        <div class="size-204 respon6-next">
                                            <div class="rs1-select2 bor8 bg0">
                                                <select class="js-select2" name="selectRorB">
                                                    <option value="Thue" selected="selected">Thuê</option>
                                                    <option value="Mua">Mua</option>
                                                </select>
                                                
                                                <div class="dropDownSelect2"></div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="flex-w flex-r-m p-b-10">
                                        <div class="size-204 flex-w flex-m respon6-next">

                                            <div class="wrap-num-product flex-w m-r-20 m-tb-10">
                                                <div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
                                                    <i class="fs-16 zmdi zmdi-minus"></i>
                                                </div>


                                                <input class="mtext-104 cl3 txt-center num-product" type="number" name="numP" value="1">

                                                <div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
                                                    <i class="fs-16 zmdi zmdi-plus"></i>
                                                </div>
                                            </div>

                                            <input type="hidden" name="iDProd" value="${detail.getIDProd()}"/>
                                            <button type="submit" class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js">
                                                Add to cart
                                            </button>

                                        </div>
                                    </div>	
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

        </section>
        <!-- Footer -->
        <footer class="bg3 p-t-32 p-b-0">
            <jsp:include page="footer.jsp"></jsp:include>
        </footer>

    </body>
</html>