
package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

@WebServlet(name = "ProductP", urlPatterns = {"/productP"})
public class ProductP extends HttpServlet {
    private ProductDAO productDao;
    HttpSession session;
    
    private EntityManager em;
    private EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/product.jsp";
        //String action = request.getParameter("action");
        
       
        emf=Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        productDao = new ProductDAO(emf);
        session = request.getSession();
        List<Product> listProduct = new ArrayList<Product>();
        listProduct = productDao.getAllProduct();

        session.setAttribute("listproductP", listProduct);
      
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
