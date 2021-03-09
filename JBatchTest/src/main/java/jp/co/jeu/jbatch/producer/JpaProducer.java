/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author soyou
 */
@Dependent
public class JpaProducer {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }
}
