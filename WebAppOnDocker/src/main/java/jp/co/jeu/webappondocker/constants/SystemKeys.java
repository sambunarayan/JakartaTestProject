package jp.co.jeu.webappondocker.constants;

import jp.co.jeus.common.lib.system.SystemKey;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soyou
 */
public enum SystemKeys implements SystemKey {

    RESPONSE_TIMEOUT_MILLISECOND,
    TIMEOUT_SERVER_URL,;

    @Override
    public String getKey() {
        return this.name();
    }

}
