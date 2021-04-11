/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.resourcelocaltest.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author soyou
 */
@Dependent
@Named
public class JpaProducer {

    private EntityManager em;

    public JpaProducer() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jp.co.jeu_ResourceLocalTest_war_1.0.0PU");
        em = emf.createEntityManager();
    }

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }
}
