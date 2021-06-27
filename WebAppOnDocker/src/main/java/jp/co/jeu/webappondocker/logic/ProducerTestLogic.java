/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.logic;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author soyou
 */
public class ProducerTestLogic {

    private EntityManager em;

    public ProducerTestLogic(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEntityManager() {
        Query query = em.createNamedQuery("TodoList.findAll");
        query.getResultList();
        return this.em;
    }
}
