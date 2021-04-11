/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.common.lib.rest;

import jakarta.ws.rs.client.WebTarget;

/**
 *
 * @author soyou
 */
public abstract class AbstractClient {

    protected abstract WebTarget getWebTarget();
}
