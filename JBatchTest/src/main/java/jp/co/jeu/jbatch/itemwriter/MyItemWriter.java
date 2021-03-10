/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.itemwriter;

import java.io.Serializable;
import java.util.List;
import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

/**
 *
 * @author soyou
 */
@Named
@Dependent
public class MyItemWriter implements ItemWriter {

    @Inject
    private JobContext jobContext;

    @Inject
    private EntityManager em;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        System.out.println("ItemWriter open.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("ItemWriter close.");
    }

    @Override
    @Transactional(rollbackOn = {Exception.class})
    public void writeItems(List<Object> items) throws Exception {
//        Query query = em.createNativeQuery("JbatchTest.findById");
//        query.setParameter("id", 9999);
//        JbatchTest jbatch = (JbatchTest) query.getSingleResult();

        System.out.println("ItemWriter writeItem : " + items);
//        items.forEach(item -> em.persist(item));
        try {
            update(items.get(0));
        } catch (Exception e) {

        }
    }

    @Transactional(rollbackOn = {Exception.class})
    public void update(Object item) throws Exception {
        em.persist(item);
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        System.out.println("ItemWriter checkpoint.");
        return null;
    }

}
