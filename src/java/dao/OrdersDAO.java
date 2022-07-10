package dao;

import entity.Accounts;
import entity.Orders;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author thanh
 */
public class OrdersDAO {
    private EntityManager em;
    
    public OrdersDAO (EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public Orders searchById(String id) {
        return em.find(Orders.class, id);
    }
    
    public void addOrders(Orders orders){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(orders);
            trans.commit();
        } catch (Exception ex){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
    
    public List<Orders> getAllOrders() {
        Query query = em.createQuery("SELECT p FROM Orders p");
        List<Orders> list = query.getResultList();
        return list;
    }
}
