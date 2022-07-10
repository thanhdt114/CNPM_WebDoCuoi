<%-- 
    Document   : product
    Created on : Oct 1, 2021, 10:20:35 PM
    Author     : thanhbao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
	<title>Sản Phẩm</title>
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
<link href="https://fonts.googleapis.com/css?family=Dancing+Script|Itim|Lobster|Montserrat:500|Noto+Serif|Nunito|Patrick+Hand|Roboto+Mono:100,100i,300,300i,400,400i,500,500i,700,700i|Roboto+Slab|Saira" rel="stylesheet">
</head>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body class="animsition">
	
	<!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Product -->
        <section class="bg-img1 txt-center p-lr-15 p-tb-140" style="background-image: url('images/Bg-01_1.jpg');">
		<h2 class="ltext-105 cl0 txt-center">
			Product
		</h2>
	</section>
	<div class="bg0 m-t-23 p-b-0">
		<div class="container">
			<div class="flex-w flex-sb-m p-b-52">
				<div class="flex-w flex-l-m filter-tope-group m-tb-10">
                                        <a href="productP#Hinh"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter="*"  style="font-family: Roboto;">
						Tất cả
                                            </button></a>

					<a href="AocuoictrlP#Hinh"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".women"  style="font-family: Roboto;">
						Áo Cưới
                                            </button></a>

					<a href="AovestctrlP#Hinh"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".men"  style="font-family: Roboto;">
						Đồ Vest
                                            </button></a>

					<a href="AodaictrlP#Hinh"><button class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5" data-filter=".bag"  style="font-family: Roboto;">
						Áo Dài
                                            </button></a>
				</div>

				<div class="flex-w flex-c-m m-tb-10">
					<div class="flex-c-m stext-106 cl6 size-105 bor4 pointer hov-btn3 trans-04 m-tb-4 js-show-search">
						<i class="icon-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-search"></i>
						<i class="icon-close-search cl2 m-r-6 fs-15 trans-04 zmdi zmdi-close dis-none"></i>
						Search
					</div>
				</div>
				
				<!-- Search product -->
				<div class="dis-none panel-search w-full p-t-10 p-b-15">
					<form action="SearchAocuoiP" method="post">
					<div class="bor8 dis-flex p-l-15">
						<button class="size-113 flex-c-m fs-16 cl2 hov-cl1 trans-04" type="submit">
							<i class="zmdi zmdi-search"></i>
						</button>

						<input class="mtext-107 cl2 size-114 plh2 p-r-15" value="<c:out value="${txtsearch}"></c:out>" type="text" name="search" placeholder="Search...">
					</div>	
                                        </form>	
				</div>
			</div>

			<div class="row isotope-grid" id="Hinh">
                            <c:forEach var ="item" items="${listvaycuoi}">
                           <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
					<!-- Block2 -->
					<div class="block2">
						<div class="block2-pic hov-img0">
							<a href="ProductDetailCtrl?iDProd=${item.getIDProd()}"><img src="${item.hinhAnh}" alt="IMG-PRODUCT"></a>
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
                             <c:forEach var ="item" items="${listaodai}">
                           <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
					<!-- Block2 -->
					<div class="block2">
						<div class="block2-pic hov-img0">
							<a href="ProductDetailCtrl?iDProd=${item.getIDProd()}"><img src="${item.hinhAnh}" alt="IMG-PRODUCT"></a>
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
                            <c:forEach var ="item" items="${listaovest}">
                           <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
					<!-- Block2 -->
					<div class="block2">
						<div class="block2-pic hov-img0">
							<a href="ProductDetailCtrl?iDProd=${item.getIDProd()}"><img src="${item.hinhAnh}" alt="IMG-PRODUCT"></a>
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