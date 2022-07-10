package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import entity.Cart;
import entity.DetailCart; 
import entity.Product;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author thanh
 */
public class CartDAO {
    private EntityManager em;
    
    public CartDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public Cart searchById(String id) {
        return em.find(Cart.class, id);
    }
    
    public void addCart(Cart cart){
        
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(cart);
            trans.commit();
        } catch (Exception ex){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
    
    public void updateCart(Cart cart) {
        em.getTransaction().begin();
        em.merge(cart);
        em.getTransaction().commit();
    }
    
    public List<Cart> getAll() {
        Query query = em.createQuery("SELECT p FROM Cart p");
        List<Cart> list = query.getResultList();
        return list;
    }
    
    public List<Cart> SearchByEmail(String email) {
        Query query = em.createQuery("SELECT p FROM Cart p WHERE p.email = :email");
        query.setParameter("email",email);
        List<Cart> list = query.getResultList();
        return list;
    }
    
    public void removeCart(Cart cart) {
        em.getTransaction().begin();
        if (!em.contains(cart)) {
            cart = em.merge(cart);
        }
        em.remove(cart);
        em.getTransaction().commit();
    }
    
    public void close() {
        em.close();
    }
}
