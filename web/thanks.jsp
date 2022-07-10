<%-- 
    Document   : thanks
    Created on : Nov 28, 2021, 9:37:53 AM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<!DOCTYPE html>
<html>
    <head>
        <title>Checkout</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
        <link rel="stylesheet" type="text/css" href="css/thanks.css">
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
                                    <a class="flex-c-m trans-04 p-lr-25" href="#">Đơn Mua</a>
                                    <a class="flex-c-m trans-04 p-lr-25" href="LogoutCtrl">Đăng Xuất</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </header>

        <div class="logo-top">
            <a href="index.jsp" >
                <img src="images/icons/Logo_Wedding-14.png" class="logoDM">
            </a>
            <br>
            <p class="thanks">
                Đặt hàng thành công
            </p>
        </div>



        <div class="detailP">
                <table class="table-detail">
                    <tr>
                        <td>
                            <h3>
                                Chi tiết đơn hàng
                            </h3>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Mã đơn hàng
                        </td>
                        
                        <td></td>

                        <td class="sl">
                            ${idOrders}
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Ngày đặt hàng
                        </td>
                        
                        <td></td>

                        <td class="sl">
                            ${date}
                        </td>
                    </tr>
                    
                    <tr>
                        <td height="10" style="font-size:1px; line-height:0.1px;">&nbsp;</td>
                        
                    </tr>
                    
                    <tr>
                        <td height="10" style="height: 1px; font-size:1px; line-height:1px; background: lightgray">&nbsp;</td>
                        <td height="10" style="height: 1px; font-size:1px; line-height:1px; background: lightgray">&nbsp;</td>
                        <td height="10" style="height: 1px; font-size:1px; line-height:1px; background: lightgray">&nbsp;</td>
                    </tr>
                    
                    <tr>
                        <td height="10" style="font-size:1px; line-height:1px;">&nbsp;</td>
                        
                    </tr>

                    <tr>
                        <td>
                            Tên sản phẩm
                        </td>
                        
                        <td class="sl-fix">
                            Số lượng
                        </td>

                        <td class="sl">
                            Giá
                        </td>
                    </tr>
                    
                    <c:forEach var="item" items="${listCartProduct}">
                        <tr>
                        <td>
                            ${item.getNameProduct()}
                        </td>
                        
                        <td>
                            ${item.getSoLuongCurrencyFormat()}
                        </td>

                        <td class="sl">
                            ${item.getTotalCurrencyFormat()}
                        </td>
                    </tr>
                    </c:forEach>
                    
                    
                    <tr>
                        <td height="10" style="font-size:1px; line-height:0.1px;">&nbsp;</td>
                        
                    </tr>
                    
                    <tr>
                        <td height="10" style="height: 1px; font-size:1px; line-height:1px; background: lightgray">&nbsp;</td>
                        <td height="10" style="height: 1px; font-size:1px; line-height:1px; background: lightgray">&nbsp;</td>
                        <td height="10" style="height: 1px; font-size:1px; line-height:1px; background: lightgray">&nbsp;</td>
                    </tr>
                    
                    <tr>
                        <td height="10" style="font-size:1px; line-height:0.1px;">&nbsp;</td>
                        
                    </tr>
                    
                    <tr>
                        <td class="col1-fix">
                            Tổng thanh toán
                        </td>
                        
                        <td>
                            
                        </td>

                        <td class="sl">
                            ${totalString}
                        </td>
                    </tr>
                </table>
        </div>
        
        <div class="detailP">
            <table class="table-detail">
                <tr>
                    <td class="button-end">
                        <a href="index.jsp">
                            <button class="w3-button w3-white w3-border w3-round-large">
                                Trang chủ
                            </button>
                        </a>
                        
                    </td>
                    
                    <td class="button-end">
                        <a href="product.jsp">
                            <button class="w3-button w3-white w3-border w3-round-large">
                            Tiếp tục mua hàng
                            </button>
                        </a>
                        
                    </td>
                </tr>
            </table>
        </div>

        <div class="place">
            
        </div>

    </body>

    <!-- Footer -->
    <footer class="bg3 p-t-32 p-b-0">
        <jsp:include page="footer02.jsp"></jsp:include>
    </footer>
</html>
