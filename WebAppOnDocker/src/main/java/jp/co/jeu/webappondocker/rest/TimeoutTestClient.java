/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.rest;

import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import jp.co.jeus.common.lib.rest.AbstractClient;
import jp.co.jeus.common.lib.timer.ResponseTimer;

/**
 *
 * @author soyou
 */
public class TimeoutTestClient extends AbstractClient {

    private WebTarget webTarget;

    private void initialize() {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(ResponseTimer.getRemaingTime(Thread.currentThread()), TimeUnit.MILLISECONDS)
                .readTimeout(ResponseTimer.getRemaingTime(Thread.currentThread()), TimeUnit.MILLISECONDS)
                .build();
        this.webTarget = client.target("");
    }

    @Override
    protected WebTarget getWebTarget() {
        if (this.webTarget == null) {
            initialize();
        }
        return this.webTarget;
    }

    public void post() {

    }
}
