/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.rest;

import java.util.concurrent.TimeUnit;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import jp.co.jeu.common.lib.rest.AbstractClient;
import jp.co.jeu.jbatch.constant.RestSettingKey;
import jp.co.jeu.jbatch.system.SystemSettingsManager;

/**
 *
 * @author soyou
 */
@Dependent
@Named
public class StubRestClient extends AbstractClient {

    private WebTarget webTarget;

    /**
     * initialize
     */
    private void init() {
        Client client = ClientBuilder.newBuilder()
                .connectTimeout(Long.parseLong(SystemSettingsManager.get(RestSettingKey.REST_CONNECT_TIMEOUT)), TimeUnit.MILLISECONDS)
                .readTimeout(Long.parseLong(SystemSettingsManager.get(RestSettingKey.REST_READ_TIMEOUT)), TimeUnit.MILLISECONDS)
                .build();
        this.webTarget = client.target(SystemSettingsManager.get(RestSettingKey.STUB_URL));
    }

    @Override
    protected WebTarget getWebTarget() {
        if (webTarget == null) {
            init();
        }
        return webTarget;
    }

}
