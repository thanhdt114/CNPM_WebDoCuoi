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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thanh
 */
@WebServlet(name = "UpdateProductCtrl", urlPatterns = {"/UpdateProductCtrl"})
public class UpdateProductCtrl extends HttpServlet {
    private ProductDAO productDAO;
    
    HttpSession session;
    
    private EntityManager em;
    private EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/DetailProductMNGCtrl";
        
        String idProduct = "";
        String tenSanPham = "";
        String hinhAnh = "";
        double giaBan = -1;
        double giaThue = -1;
        String iDCat = "";
        String thuoctinh = "";
        String mau = "";
        String tinhTrang = "";
        
        String giaBanString = "";
        String giaThueString = "";
        
        idProduct = request.getParameter("idProduct");
        tenSanPham = request.getParameter("tenSanPham");
        hinhAnh = request.getParameter("hinhAnh");
        giaBanString = request.getParameter("giaBan");
        
        giaThueString = request.getParameter("giaThue");
        iDCat = request.getParameter("iDCat");
        thuoctinh = request.getParameter("thuoctinh");
        mau = request.getParameter("mau");
        tinhTrang = request.getParameter("tinhTrang");

        emf=Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        productDAO = new ProductDAO(emf);
        session = request.getSession();
        
        Product product = new Product();
        
        product = productDAO.searchById(idProduct);
        
        if (!tenSanPham.equals("")) {
            product.setTenSanPham(tenSanPham);
        }
        if (!hinhAnh.equals("")) {
            product.setHinhAnh(hinhAnh);
        }
        if (!giaBanString.equals("")) {
            giaBan = Double.valueOf(request.getParameter("giaBan"));
            product.setGiaBan(giaBan);
        }
        if (!giaThueString.equals("")) { 
            giaThue = Double.valueOf(request.getParameter("giaThue"));
            product.setGiaThue(giaThue);
        }
        if (!iDCat.equals("")) {
            product.setIDCat(iDCat);
        }
        if (!thuoctinh.equals("")) {
            product.setThuoctinh(thuoctinh);
        }
        if (!mau.equals("")) {
            product.setMau(mau);
        }
        if (!tinhTrang.equals("")) {
            product.setTinhTrang(tinhTrang);
        }
        
        productDAO.updateProduct(product);
        
        session.setAttribute("idProduct", idProduct);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
