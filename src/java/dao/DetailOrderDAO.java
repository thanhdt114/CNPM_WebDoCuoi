/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DetailOrder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author thanh
 */
public class DetailOrderDAO {
    private EntityManager em;
    
    public DetailOrderDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public DetailOrder searchById(String id) {
        return em.find(DetailOrder.class, id);
    }
    
    public void addDetailOrder(DetailOrder detailOrder){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(detailOrder);
            trans.commit();
        } catch (Exception ex){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
    
    public List<DetailOrder> getDetailOrderByOrder(String idOrder) {
        Query query = em.createQuery("SELECT p FROM DetailOrder p WHERE p.iDOrder = :iDOrder");
        query.setParameter("iDOrder",idOrder);
        List<DetailOrder> list = query.getResultList();
        return list;
    }

    
    public void updateDetailOrder(DetailOrder detailOrder) {
        em.getTransaction().begin();
        em.merge(detailOrder);
        em.getTransaction().commit();
    }
    
    public void removeDetailOrder(DetailOrder detailOrder) {
        em.getTransaction().begin();
        if (!em.contains(detailOrder)) {
            detailOrder = em.merge(detailOrder);
        }
        em.remove(detailOrder);
        em.getTransaction().commit();
    }
    
    public List<DetailOrder> getAllDetailOrder() {
        Query query = em.createQuery("SELECT p FROM DetailOrder p");
        List<DetailOrder> list = query.getResultList();
        return list;
    }
}
