/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jeus.stub.dto;

import java.io.Serializable;

/**
 *
 * @author soyou
 */
public class DelayConfigDto implements Serializable {

    private long delayTyime;

    /**
     * @return the delayTyime
     */
    public long getDelayTyime() {
        return delayTyime;
    }

    /**
     * @param delayTyime the delayTyime to set
     */
    public void setDelayTyime(long delayTyime) {
        this.delayTyime = delayTyime;
    }

}
