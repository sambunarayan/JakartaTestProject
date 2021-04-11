/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.logic;

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import jp.co.jeu.jbatch.entity.JbatchTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author soyou
 */
@Stateless
public class TransactionTestLogic {

    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    @Inject
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Transactional(rollbackOn = RuntimeException.class)
    public void execute() {
        int id = (int) (Math.random() * 100000);
        logger.info("execute start");
        JbatchTest testEntity = new JbatchTest();
        testEntity.setId(BigDecimal.valueOf(id));
        testEntity.setName("Test " + testEntity.getName());
        logger.info("persiste : " + testEntity.getId());
        em.persist(testEntity);

        if (testEntity.getId() == BigDecimal.valueOf(3)) {
            throw new RuntimeException();
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Transactional(rollbackOn = RuntimeException.class)
    public int update(int id) {
        Query query = em.createNamedQuery("JbatchTest.updateByKey");
        query.setParameter("id", id);
        return query.executeUpdate();
    }
}
