package controller;

import MailUtil.Gmail;
import dao.CartDAO;
import dao.DetailCartDAO;
import dao.DetailOrderDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.DetailCart;
import entity.DetailOrder;
import entity.Orders;
import entity.Product;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import support.CartSP;

/**
 *
 * @author thanh
 */
@WebServlet(name = "CheckoutCtrl", urlPatterns = {"/CheckoutCtrl"})
public class CheckoutCtrl extends HttpServlet {
    
    private EntityManager em;
    private EntityManagerFactory emf;
    private OrdersDAO ordersDAO;
    private DetailCartDAO detailCartDAO;
    private DetailOrderDAO detailOrderDAO;
    private CartDAO cartDAO;
    private ProductDAO productDAO;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        session = request.getSession(true);

        String fName = request.getParameter("fname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Date date = Calendar.getInstance().getTime();
        double total = Double.valueOf(request.getParameter("total"));
        String idCart = "";
        String url = "/thanks.jsp";
        String idOrders = "1";
        int idOrdersInt = 0;
        String totalString = "";
        
        int idDetailOrder = 0;
        
        emf = Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        ordersDAO = new OrdersDAO(emf);
        detailCartDAO = new DetailCartDAO(emf);
        detailOrderDAO = new DetailOrderDAO(emf);
        cartDAO = new CartDAO(emf);
        productDAO = new ProductDAO(emf);
        
        Orders ordersNew = new Orders();
        
        List<Orders> listOders = new ArrayList<Orders>();
        listOders = ordersDAO.getAllOrders();
        
        if (!listOders.isEmpty()) {
            for (Orders item : listOders) {
                idOrdersInt = Integer.parseInt(item.getIDOrder());
            }
            idOrdersInt++;
            idOrders = String.valueOf(idOrdersInt);
        }
        
        ordersNew.setIDOrder(idOrders);
        ordersNew.setEmail(email);
        ordersNew.setTenNguoiNhan(fName);
        ordersNew.setDiaChi(address);
        ordersNew.setSoDienThoai(phone);
        ordersNew.setNgayDatHang(date);
        ordersNew.setThanhTien(total);
        ordersNew.setTinhtrang("Chưa thanh toán"); 
        
        ordersDAO.addOrders(ordersNew);
        
        /*----- Xóa tất cả sản phẩm trong dỏ hàng -----*/
        
        // Lấy idCart
        List<Cart> listCart = new ArrayList<Cart>();
        listCart = cartDAO.SearchByEmail(email);
        for (Cart item : listCart) {
            idCart = item.getIDCart();
        }
        
        // Lấy sản phẩm trong giỏ hàng
        List<DetailCart> listdetailCart = new ArrayList<DetailCart>();
        listdetailCart = detailCartDAO.getDetailCartById(idCart);
        
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        
        /*----- Gửi mail cho khách hàng -----*/
            // send email to user
            String to = email;
            String from = "StoreDiemMy";
            String subject = "Order Success";

            String body = "<div>\n" +
"            <table width=\"560\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                <tbody>\n" +
"\n" +
"                    <tr>\n" +
"                        <td align=\"center\">\n" +
"                            <img src=\"https://lh6.googleusercontent.com/Av7NIyklypyIIqjE3dyddXhM55bAiLTOsxuOReUgyNQySklx9nB-f2M7kASsaiurEBLCqqArAQDX0bwbz_nW=w1858-h927\" width=\"140\"  style=\"width:25%;height:auto;\" alt=\"\">\n" +
"                        </td>\n" +
"                    </tr>\n" +
"\n" +
"                    <tr>\n" +
"                        <td height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                    </tr>\n" +
"\n" +
"                </tbody>\n" +
"            </table>\n" +
"\n" +
"            <table bgcolor=\"#ffffff\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
"                <tbody>\n" +
"\n" +
"                    <tr>\n" +
"                        <td height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                    </tr>\n" +
"\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <table width=\"560\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                                <tbody>\n" +
"                                    <tr>\n" +
"                                        <td style=\"font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;text-align:left;line-height:18px\">\n" +
"                                            DIEM MY STUDIO, Thanks for your order\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td width=\"100%\" height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td style=\"font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;text-align:left;line-height:18px\">\n" +
"                                            You ordered succeed. Your order will be processed as soon as possible<br><br>\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td width=\"100%\" height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td width=\"100%\" height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                </tbody>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td width=\"100%\" height=\"1\" bgcolor=\"#ffffff\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"\n" +
"            <div style=\"width:100%;height:1px;display:block\" align=\"center\">\n" +
"                <div style=\"width:100%;max-width:600px;height:1px;border-top:1px solid #e0e0e0\"></div>\n" +
"            </div>\n" +
"\n" +
"            <table bgcolor=\"#ffffff\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
"                <tbody>\n" +
"\n" +
"                    <tr>\n" +
"                        <td height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                    </tr>\n" +
"\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <table width=\"560\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                                <tbody>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td colspan=\"2\" style=\"text-align:left;font-family:Helvetica,arial,sans-serif;color:#1f1f1f;font-size:16px;font-weight:bold;height:10px\"></td>\n" +
"                                    </tr>\n" +
"                                    <tr>\n" +
"                                        <td colspan=\"2\" style=\"text-align:left;font-family:Helvetica,arial,sans-serif;color:#1f1f1f;font-size:13px;font-weight:bold\">\n" +
"                                            ORDER DETAILS\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td height=\"\" style=\"font-size:1px;line-height:1px\" width=\"100%\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                </tbody>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td width=\"100%\" height=\"1\" bgcolor=\"#ffffff\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"\n" +
"            <table bgcolor=\"#ffffff\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
"                <tbody>\n" +
"\n" +
"                    <tr>\n" +
"                        <td height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                    </tr>\n" +
"\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <table width=\"560\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                                <tbody>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td style=\"word-break:break-word;text-align:left;font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;vertical-align:top\" width=\"280\">Order code:\n" +
"                                        </td>\n" +
"                                        <td style=\"word-break:break-word;text-align:left;font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;vertical-align:top\" width=\"280\">\n" +
"\n" +
"                                            "+ idOrders +"\n" +
"\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"                                    <tr>\n" +
"                                        <td style=\"word-break:break-word;text-align:left;font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;vertical-align:top\" width=\"280\">Order time:\n" +
"                                        </td>\n" +
"                                        <td style=\"word-break:break-word;text-align:left;font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;vertical-align:top\" width=\"280\">" + date + "\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td style=\"word-break:break-word;text-align:left;font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;vertical-align:top\" width=\"280\">the total amount paid:\n" +
"                                        </td>\n" +
"                                        <td style=\"word-break:break-word;text-align:left;font-family:Helvetica,arial,sans-serif;font-size:13px;color:#000000;vertical-align:top\" width=\"280\">" + formatter.format((total)) + " d" + "\n" +
"                                        </td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"                                    <tr>\n" +
"                                        <td height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                </tbody>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"\n" +
"                </tbody>\n" +
"            </table>\n" +
"\n" +
"            <div style=\"width:100%;height:1px;display:block\" align=\"center\">\n" +
"                <div style=\"width:100%;max-width:600px;height:1px;border-top:1px solid #e0e0e0\"></div>\n" +
"            </div>\n" +
"\n" +
"            <div style=\"width:100%;height:15px;display:block\" align=\"center\">\n" +
"                <div style=\"width:100%;max-width:600px;height:1px;border-top:1px solid #e0e0e0\">\n" +
"                    &nbsp;\n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"            <table bgcolor=\"#ffffff\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>\n" +
"                            <table width=\"560\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"                                <tbody>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td width=\"100%\" height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td style=\"font-family:Helvetica,arial,sans-serif;font-size:11px;color:#747474;text-align:center;line-height:100%\">This is an automated email. Please do not respond to this email. Add <a href=\"mailto:storediemmy@gmail.com\" style=\"text-decoration:none;color:#ff5722\" target=\"_blank\">storediemmy@gmail.com</a> to your email directory to make sure you always receive emails from us.</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td width=\"100%\" height=\"10\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td style=\"font-family:Helvetica,arial,sans-serif;font-size:11px;color:#747474;text-align:center;line-height:100%\">1 Vo Van Ngan, Thu Duc City, Ho Chi Minh City</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                    <tr>\n" +
"                                        <td width=\"100%\" height=\"40\" style=\"font-size:1px;line-height:1px\">&nbsp;</td>\n" +
"                                    </tr>\n" +
"\n" +
"                                </tbody>\n" +
"                            </table>\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </div>";
            
            
            boolean isBodyHTML = true;
            try {
                Gmail send = new Gmail();
                send.sendEmail(to, from, subject, body, isBodyHTML);
            } catch (MessagingException e) {
                String errorMessage = "ERROR";
                session.setAttribute("errorMessage", e);
            }
        
            
            // List sản phẩm cần thiết
        List<CartSP> listCartProduct = new ArrayList<CartSP>();
        
        for (DetailCart item : listdetailCart) {
            Product product = new Product();
            CartSP cartSP = new CartSP();
            product = productDAO.searchById(item.getIDProd());
            cartSP.setImage(product.getHinhAnh());
            cartSP.setNameProduct(product.getTenSanPham());
            cartSP.setDonGia(item.getDonGia());
            cartSP.setSoLuong(item.getSoLuong());
            cartSP.setIDProduct(product.getIDProd()); 
            listCartProduct.add(cartSP);
        }
        
        totalString = formatter.format((total));

        DetailCart detailCartNew = new DetailCart();
        DetailOrder detailOrder = new DetailOrder();
        
        List<DetailOrder> listDetailOrders = new ArrayList<DetailOrder>();
        listDetailOrders = detailOrderDAO.getAllDetailOrder();
        for (DetailOrder item : listDetailOrders) {
            idDetailOrder = Integer.parseInt(item.getIDDetailOrder());
        }
        
        for (DetailCart item : listdetailCart) {
            detailCartNew.setIDDetailCart(item.getIDDetailCart());
            detailCartNew.setIDCart(item.getIDCart());
            detailCartNew.setIDProd(item.getIDProd());
            detailCartNew.setDonGia(item.getDonGia());
            detailCartNew.setSoLuong(item.getSoLuong());
            
            idDetailOrder++;
            
            detailOrder.setIDDetailOrder(String.valueOf(idDetailOrder)); 
            detailOrder.setIDOrder(ordersNew.getIDOrder());
            detailOrder.setIDProd(item.getIDProd());
            detailOrder.setDonGia(item.getDonGia());
            detailOrder.setSoLuong(item.getSoLuong()); 
            
            detailOrderDAO.addDetailOrder(detailOrder); 
            detailCartDAO.removeDetailCart(detailCartNew);
        }
        
        Cart cart = new Cart();
        cart.setIDCart(idCart);
        cart.setEmail(email);
        cart.setTongTien(total);
        cartDAO.removeCart(cart);
        
        
        session.setAttribute("listdetailCart", listdetailCart);
        session.setAttribute("listCartProduct", listCartProduct);
        session.setAttribute("idOrders", idOrders);
        session.setAttribute("date", date);
        session.setAttribute("totalString", totalString);
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
