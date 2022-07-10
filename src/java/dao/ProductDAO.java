package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import entity.*;

public class ProductDAO {
    private EntityManager em;

    public ProductDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    public Product searchById(String id) {
        return em.find(Product.class, id);
    }
    public List<Product> searchByPrice(String priceSearch) {
        Double price=Double.parseDouble(priceSearch);
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.price like :price");
        query.setParameter("price","%"+priceSearch+"%");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public void updateProduct(Product product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }
   
    public List<Product> getAllProduct() {
        Query query = em.createQuery("SELECT p FROM Product p");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> getProductById(String cid) {
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.iDProd = :id");
        query.setParameter("id",cid);
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> searchByNameDetail(String ten) {
        String q="SELECT p FROM Product p WHERE p.tenSanPham like ?1";
        Query query = em.createQuery(q);
        query.setParameter(1,"%"+ten+"%");     
        List<Product> list = query.getResultList();
        return list;
    }
    
    public void removeProduct(Product product) {
        em.getTransaction().begin();
        em.remove(product);
        em.getTransaction().commit();
    }
    
    public List<Product> categoryVayCuoi(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.iDCat='CAT01'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> categoryAoVest(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.iDCat='CAT02'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> categoryAoDai(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.iDCat='CAT03'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> listAoCuoiCD(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.thuoctinh='CD'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> listAoCuoiDG(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.thuoctinh='DD'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> listAoCuoiCC(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.thuoctinh='CC'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> listAoCuoiHD(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.thuoctinh='HD'");
        List<Product> list = query.getResultList();
        return list;
    }
    public List<Product> listAoVest(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.thuoctinh='AO'");
        List<Product> list = query.getResultList();
        return list;
    }
    
    public List<Product> listQuanVest(){
        Query query = em.createQuery("SELECT p FROM Product p Where p.thuoctinh='Q'");
        List<Product> list = query.getResultList();
        return list;
    }

    public void close() {
        em.close();
    }
}
