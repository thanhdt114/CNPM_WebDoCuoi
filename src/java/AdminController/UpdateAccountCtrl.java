/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.*;
import dao.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thanh
 */
@WebServlet(name = "UpdateAccountCtrl", urlPatterns = {"/UpdateAccountCtrl"})
public class UpdateAccountCtrl extends HttpServlet {
    private AccountDAO accountDAO;
    HttpSession session;
    
    private EntityManager em;
    private EntityManagerFactory emf;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/DetailAccountMNGCtrl";
        
        String idAccount = "";
        String email = "";
        String username = "";
        String password = "";
        String quyen = "";
        
        idAccount = request.getParameter("idAccount");
        email = request.getParameter("email");
        username = request.getParameter("username");
        password = request.getParameter("password");
        quyen = request.getParameter("quyen");

        emf=Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        accountDAO = new AccountDAO(emf);
        session = request.getSession();

        Accounts account = new Accounts();
        
        account = accountDAO.searchById(idAccount);
        
        if (!email.equals("")) {
            account.setEmail(email);
        }
        if (!username.equals("")) {
            account.setUserName(username);
        }
        if (!password.equals("")) { 
            account.setPassWord1(password);
        }
        if (!quyen.equals("")) {
            account.setQuyen(quyen);
        }
        
        accountDAO.updateAccount(account);
        
        session.setAttribute("idAccount", idAccount);

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
