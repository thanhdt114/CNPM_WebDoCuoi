/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import entity.Accounts;
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
@WebServlet(name = "LoginCtrl", urlPatterns = {"/LoginCtrl"})
public class LoginCtrl extends HttpServlet {

    private EntityManager em;
    private EntityManagerFactory emf;
    private AccountDAO userDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Kiểm tra email
        
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        
        String iDProd = request.getParameter("iDProd");
        String url = "/ProductDetailCtrl";
        int isLogin = 0;

        emf = Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        userDAO = new AccountDAO(emf);

        Accounts account = new Accounts();
        //user = userDAO.searchByAccount(userName, passWord);
        List<Accounts> listUsers = new ArrayList<Accounts>();
        listUsers = userDAO.searchByAccount(userName, passWord);
        for (Accounts item : listUsers) {
            account.setIDAccount(item.getIDAccount());
            account.setEmail(item.getEmail());
            account.setUserName(item.getUserName());
            account.setPassWord1(item.getPassWord1());
            account.setQuyen(item.getQuyen());
            }

        // Load lại trang login nếu người dùng chưa nhập gì
        if (userName == "" | passWord == "") {
            url = "/login.jsp";
        }
        // Load lại trang nếu tài khoản chưa được đăng ký
        else if (listUsers.isEmpty()) {
            url = "/login.jsp";
        }
        else {
            if (account.getQuyen().equals("admin")) {
                url = "/adminOrderMNG.jsp"; 
            }
            else {
                isLogin = 1;
                if (iDProd == ""){
                    url="/productP";
                }
            }
            
            // Tạo session để duy trì đăng nhập cho tài khoản
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(1800);
            session.setAttribute("email", account.getEmail());
            request.setAttribute("iDProd", iDProd); 
        } 

        request.setAttribute("isLogin", isLogin);
            
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
