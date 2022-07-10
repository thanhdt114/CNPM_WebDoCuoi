package dao;

import entity.DetailCart;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author thanh
 */
public class DetailCartDAO {
    
    private EntityManager em;
    
    public DetailCartDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public DetailCart searchById(String id) {
        return em.find(DetailCart.class, id);
    }
    
    public void addDetailCart(DetailCart detailCart){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(detailCart);
            trans.commit();
        } catch (Exception ex){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
    
    public List<DetailCart> getDetailCartById(String cid) {
        Query query = em.createQuery("SELECT p FROM DetailCart p WHERE p.iDCart = :iDCart");
        query.setParameter("iDCart",cid);
        List<DetailCart> list = query.getResultList();
        return list;
    }
    
    public List<DetailCart> searchByIdProd(String cid, String pid) {
        Query query = em.createQuery("SELECT p FROM DetailCart p WHERE p.iDCart = ?1 and p.iDProd = ?2");
        query.setParameter(1,cid);
        query.setParameter(2,pid);
        List<DetailCart> list = query.getResultList();
        return list;
    }
    
    public void updateDetailCart(DetailCart detailCart) {
        em.getTransaction().begin();
        em.merge(detailCart);
        em.getTransaction().commit();
    }
    
    public void removeDetailCart(DetailCart detailCart) {
        em.getTransaction().begin();
        if (!em.contains(detailCart)) {
            detailCart = em.merge(detailCart);
        }
        em.remove(detailCart);
        em.getTransaction().commit();
    }
    
    public List<DetailCart> getAllDetailCart() {
        Query query = em.createQuery("SELECT p FROM DetailCart p");
        List<DetailCart> list = query.getResultList();
        return list;
    }
}
