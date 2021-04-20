/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import jp.co.jeu.jbatch.rest.StubRestClient;

/**
 *
 * @author soyou
 */
@Named
@Dependent
public class RestClientProducer {

    private StubRestClient stubClient;

    public RestClientProducer() {
        stubClient = new StubRestClient();
    }

    @Produces
    public StubRestClient getStubRestClient() {
        return this.stubClient;
    }
}
