/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.co.jeu.webappondocker.logic.ProducerTestLogic;

/**
 *
 * @author soyou
 */
@Dependent
public class TestProducer {

    @PersistenceContext(name = "jp.co.jeu_WebAppOnDocker_war_1.0.0PU")
    private EntityManager em;

    private ProducerTestLogic testLogic;

    @Produces
    public ProducerTestLogic getProducerTestLogic() {
        if (testLogic == null) {
            this.testLogic = new ProducerTestLogic(this.em);
        }
        return this.testLogic;
    }
}
