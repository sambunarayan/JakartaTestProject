/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.dao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

/**
 *
 * @author soyou
 */
@Transactional(TxType.REQUIRED)
@Dependent
public class TransactionTestDao {

    @Inject
    private EntityManager em;

    public int updateName(long id, String name) {
        Query query = em.createNamedQuery("JBatchTest.updateName");
//        String nativeQuery = "UPDATE JABATCH_TEST SET NAME = ? WHERE ID = ?";
//        Query query = em.createNativeQuery(nativeQuery);
        query.setParameter(1, name);
        query.setParameter(2, id);
        return query.executeUpdate();
    }
}
