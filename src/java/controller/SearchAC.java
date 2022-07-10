/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 *
 * @author thanhbao
 */
@WebServlet(name = "SearchAC", urlPatterns = {"/SearchAC"})
public class SearchAC extends HttpServlet {
    private ProductDAO productDao;
    HttpSession session;
    private EntityManager em;
    private EntityManagerFactory emf;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url="/aocuoi.jsp";
        
        String txtsearch=request.getParameter("search");

        emf=Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        productDao = new ProductDAO(emf);
        
        
        List<Product> listProductFound = new ArrayList<Product>();
        listProductFound = productDao.searchByNameDetail(txtsearch);
        if(listProductFound.isEmpty()){
            String message="NO RESULTS FOUND";
            request.setAttribute("notfoundtxt",message);
        }
        request.setAttribute("listvaycuoi", listProductFound);
        request.setAttribute("txtsearch",txtsearch);
        
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
