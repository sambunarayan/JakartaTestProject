/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.rest;

import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jp.co.jeu.webappondocker.constants.SystemKeys;
import jp.co.jeu.webappondocker.dto.TimeoutRequestDto;
import jp.co.jeus.common.lib.rest.AbstractClient;
import jp.co.jeus.common.lib.system.SystemSettingsManager;
import jp.co.jeus.common.lib.timer.ResponseTimer;

/**
 *
 * @author soyou
 */
public class TimeoutTestClient extends AbstractClient {

    private static final String servicePath = "/timeout";

    private WebTarget webTarget;

    private void initialize() {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(ResponseTimer.getRemaingTime(Thread.currentThread()), TimeUnit.MILLISECONDS)
                .readTimeout(ResponseTimer.getRemaingTime(Thread.currentThread()), TimeUnit.MILLISECONDS)
                .build();
        this.webTarget = client.target(SystemSettingsManager.get(SystemKeys.TIMEOUT_SERVER_URL));
    }

    @Override
    protected WebTarget getWebTarget() {
        if (this.webTarget == null) {
            initialize();
        }
        return this.webTarget;
    }

    public void post(TimeoutRequestDto reqDto) {
        Response response = getWebTarget()
                .path(servicePath)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.<String>entity(new Gson().toJson(reqDto), MediaType.APPLICATION_JSON));
    }
}
