package controller;

import dao.CartDAO;
import dao.DetailCartDAO;
import entity.Cart;
import entity.DetailCart;
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
@WebServlet(name = "UpdateCartCtrl", urlPatterns = {"/UpdateCartCtrl"})
public class UpdateCartCtrl extends HttpServlet {
    
    private EntityManager em;
    private EntityManagerFactory emf;
    private DetailCartDAO detailCartDAO;
    private CartDAO cartDAO;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        session = request.getSession(true);

        String url = "/CartCtrl";
        String idProd = request.getParameter("iDProdDetail");
        double num = Double.parseDouble(request.getParameter("num-product1"));  
        
        String email = session.getAttribute("email").toString();
        String idCart = "";
        
        emf = Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        detailCartDAO = new DetailCartDAO(emf);
        cartDAO = new CartDAO(emf);
        
        DetailCart detailCartNew = new DetailCart();
        
        List<Cart> listCart = new ArrayList<Cart>();
        listCart = cartDAO.SearchByEmail(email);
        for (Cart item : listCart) {
            idCart = item.getIDCart();
        }
        
        List<DetailCart> listDetailCart = new ArrayList<DetailCart>();
        listDetailCart = detailCartDAO.searchByIdProd(idCart, idProd);
        for (DetailCart item : listDetailCart) {
            detailCartNew.setIDCart(idCart);
            detailCartNew.setIDProd(idProd);
            detailCartNew.setDonGia(item.getDonGia());
            detailCartNew.setSoLuong(num); 
        }
        
        detailCartDAO.updateDetailCart(detailCartNew);
        
        session.setAttribute("num", num);
        
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
