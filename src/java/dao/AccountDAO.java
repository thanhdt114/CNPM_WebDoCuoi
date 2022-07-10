/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DetailCart;
import entity.Product;
import entity.Accounts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AccountDAO {
    private EntityManager em;
    

    public AccountDAO(EntityManagerFactory emf) {
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
    
    public List<Accounts> searchByAccount(String userName, String passWord) {
        Query query = em.createQuery("SELECT p FROM Accounts p WHERE p.userName = ?1 and p.passWord1 = ?2");
        query.setParameter(1,userName);
        query.setParameter(2,passWord);
        List<Accounts> listUser = query.getResultList();
        return listUser;
    }
    
    public List<Accounts> getAllAccounts() {
        Query query = em.createQuery("SELECT p FROM Accounts p");
        List<Accounts> list = query.getResultList();
        return list;
    }
    
    public void updateAccount(Accounts account) {
        em.getTransaction().begin();
        em.merge(account);
        em.getTransaction().commit();
    }
    
    public void close() {
        em.close();
    }
}
