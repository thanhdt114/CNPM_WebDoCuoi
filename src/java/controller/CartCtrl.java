package controller;

import dao.CartDAO;
import dao.DetailCartDAO;
import dao.ProductDAO;
import entity.Cart;
import entity.DetailCart;
import entity.Product;
import java.io.IOException;
import java.text.DecimalFormat;
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
import support.CartSP;

/**
 *
 * @author thanh
 */
@WebServlet(name = "CartCtrl", urlPatterns = {"/CartCtrl"})
public class CartCtrl extends HttpServlet {

    private EntityManager em;
    private EntityManagerFactory emf;
    private DetailCartDAO detailCartDAO;
    private CartDAO cartDAO;
    private ProductDAO productDAO;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        session = request.getSession(true);
        String email = session.getAttribute("email").toString();
        String url = "/shopping-cart.jsp";
        String idCart = "";
        double total = 0;
        String totalString = "";

        emf = Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        detailCartDAO = new DetailCartDAO(emf);
        cartDAO = new CartDAO(emf);
        productDAO = new ProductDAO(emf);

        List<Cart> listCart = new ArrayList<Cart>();
        listCart = cartDAO.SearchByEmail(email);
        for (Cart item : listCart) {
            idCart = item.getIDCart();
        }
        

        List<DetailCart> listdetailCart = new ArrayList<DetailCart>();
        listdetailCart = detailCartDAO.getDetailCartById(idCart);

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
            total += item.getSoLuong() * item.getDonGia();
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        totalString = formatter.format((total));

        session.setAttribute("listCartProduct", listCartProduct);
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
