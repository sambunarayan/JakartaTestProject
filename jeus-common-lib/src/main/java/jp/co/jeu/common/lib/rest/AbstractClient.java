/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.common.lib.rest;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author soyou
 */
public abstract class AbstractClient {

    protected abstract WebTarget getWebTarget();

    public int get(String path) {
        Response response = getWebTarget()
                .path(path)
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .get();
        return response.getStatus();
    }
}
