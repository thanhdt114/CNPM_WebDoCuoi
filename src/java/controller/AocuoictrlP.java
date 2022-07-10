package controller;

import dao.ProductDAO;
import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet(name = "AocuoictrlP", urlPatterns = {"/AocuoictrlP"})
public class AocuoictrlP extends HttpServlet {
    
    private EntityManager em;
    private EntityManagerFactory emf;
    private ProductDAO productDao;
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/aocuoiP.jsp";
        
        
        emf=Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        productDao = new ProductDAO(emf);
       
        List<Product> listProduct = new ArrayList<Product>();
        listProduct = productDao.categoryVayCuoi();
        request.setAttribute("listvaycuoi", listProduct);
           
        
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
