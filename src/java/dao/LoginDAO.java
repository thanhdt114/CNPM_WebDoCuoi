/**
 *
 * @author thanh
 */
package dao;

import entity.Accounts;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class LoginDAO {
    private EntityManager em;
    

    public LoginDAO(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public Accounts searchById(String id) {
        return em.find(Accounts.class, id);
    }
    
    public void addUser(Accounts account){
        EntityTransaction trans = em.getTransaction();
        try{
            trans.begin();
            em.persist(account);
            trans.commit();
        } catch (Exception ex){
            if (trans != null && trans.isActive()) {
                trans.rollback();
            }
        }
    }
    
    public void close() {
        em.close();
    }
}
