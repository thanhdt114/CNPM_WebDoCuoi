package controller;

import dao.CartDAO;
import dao.DetailCartDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.DetailCart;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thanh
 */
@WebServlet(name = "AddToCartCtrl", urlPatterns = {"/AddToCartCtrl"})
public class AddToCartCtrl extends HttpServlet {

    private EntityManager em;
    private EntityManagerFactory emf;
    private CartDAO cartDAO;
    private DetailCartDAO detailCartDAO;
    private ProductDAO productDAO;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = "/CartCtrl";
        String iDProd = request.getParameter("iDProd");

        emf = Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        cartDAO = new CartDAO(emf);
        detailCartDAO = new DetailCartDAO(emf);
        productDAO = new ProductDAO(emf);

        session = request.getSession(true);

        if (session.getAttribute("email") == null) {
            url = "/login.jsp";
        } else {
            String email = session.getAttribute("email").toString();
            String selectRorB = request.getParameter("selectRorB");
            String idCart ="";
            double num = Double.parseDouble(request.getParameter("numP"));

            List<Cart> listCart = new ArrayList<Cart>();
            List<DetailCart> listDetailCart = new ArrayList<DetailCart>();
            
            listCart = cartDAO.SearchByEmail(email);

            Product product = new Product();
            product = productDAO.searchById(iDProd);

            Cart cartNew = new Cart();
            double total = 0;
            
            // Nếu giỏ hàng còn trống
            if (listCart.isEmpty()) {
                // Tạo Cart mới
                listCart = cartDAO.getAll();
                int idCartInt = 0;
                for (Cart item : listCart) {
                    idCartInt = Integer.parseInt(item.getIDCart());
                }
                idCartInt++;
                String idCartString = String.valueOf(idCartInt);

                cartNew.setIDCart(idCartString);
                cartNew.setEmail(email);
                cartNew.setTongTien(total);
                cartDAO.addCart(cartNew);
            }

            double soluong = 0;
            listCart = cartDAO.SearchByEmail(email);
            for (Cart item : listCart) {
                cartNew.setIDCart(item.getIDCart());
            }
            listDetailCart = detailCartDAO.searchByIdProd(cartNew.getIDCart(), iDProd);
            if (!listDetailCart.isEmpty()) {
                DetailCart detailCartNew = new DetailCart();
                for (DetailCart item : listDetailCart) {
                    detailCartNew.setIDDetailCart(item.getIDDetailCart());
                    detailCartNew.setIDCart(item.getIDCart());
                    detailCartNew.setIDProd(item.getIDProd());
                    detailCartNew.setDonGia(item.getDonGia());
                    detailCartNew.setSoLuong(item.getSoLuong()); 
                }
                soluong = detailCartNew.getSoLuong() + num;
                detailCartNew.setSoLuong(soluong);
                detailCartDAO.updateDetailCart(detailCartNew);
            } else {
                int index = 0;
                String indexString = "";
                
                listDetailCart = detailCartDAO.getAllDetailCart();
                for (DetailCart item : listDetailCart) {
                    indexString = item.getIDDetailCart();
                }
                index = Integer.parseInt(indexString);
                index++;
                indexString = String.valueOf(index);
                
                // Gán giá trị cho Detail Cart
                DetailCart detailCartNew = new DetailCart();
                detailCartNew.setIDDetailCart(indexString);
                detailCartNew.setIDCart(cartNew.getIDCart());
                detailCartNew.setIDProd(iDProd);
                if (selectRorB.equals("Thue")) {
                    detailCartNew.setDonGia(product.getGiaThue());
                } else {
                    detailCartNew.setDonGia(product.getGiaBan());
                }
                detailCartNew.setSoLuong(num);
                detailCartDAO.addDetailCart(detailCartNew);
            }

            // Tính tổng tiền cho Cart
            listDetailCart = detailCartDAO.getDetailCartById(cartNew.getIDCart());
            for (DetailCart item : listDetailCart) {
                total += item.getDonGia() * item.getSoLuong();
            }
            
            listCart = cartDAO.SearchByEmail(email);
            for (Cart item : listCart) {
                cartNew.setIDCart(item.getIDCart());
                cartNew.setEmail(item.getEmail());
                cartNew.setTongTien(item.getTongTien()); 
            }
            
            cartNew.setTongTien(total);
            cartDAO.updateCart(cartNew);
        }

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
