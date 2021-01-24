/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jakarta.dao;

import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jp.co.jeu.jakarta.shared.entity.Test;

/**
 *
 * @author soyou
 */
public class TestDao {
    
    public void insertTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jp.co.jeu_JakartaEETest_war_1.0.0PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Test test = new Test();
        test.setName("Test1");
        test.setAge(BigInteger.valueOf(11L));
        
        tx.begin();
        em.persist(test);
        tx.commit();
    }
}
