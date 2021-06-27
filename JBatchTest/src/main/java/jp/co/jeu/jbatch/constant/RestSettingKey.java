/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.constant;

/**
 *
 * @author soyou
 */
public enum RestSettingKey implements SettingKey {

    STUB_URL("STUB_URL"),
    REST_CONNECT_TIMEOUT("REST_CONNECT_TIMEOUT"),
    REST_READ_TIMEOUT("REST_READ_TIMEOUT"),;

    private final String value;

    private RestSettingKey(String value) {
        this.value = value;
    }

    @Override
    public String keyValue() {
        return this.value;
    }

}
