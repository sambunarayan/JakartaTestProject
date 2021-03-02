/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jakarta.dao;

import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import jp.co.jeu.jakarta.shared.entity.Test;

/**
 *
 * @author soyou
 */
@Stateless
public class TestDao {
    
    @PersistenceContext(unitName = "jp.co.jeu_JakartaEETest_war_1.0.0PU")
    private EntityManager em;
    
    public void insertTest(Test test) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jp.co.jeu_JakartaEETest_war_1.0.0PU");
//        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(test);
        tx.commit();
    }
}
