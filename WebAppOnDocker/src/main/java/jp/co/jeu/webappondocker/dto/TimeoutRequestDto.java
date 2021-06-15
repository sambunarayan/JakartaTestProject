/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.webappondocker.dto;

import java.io.Serializable;

/**
 *
 * @author soyou
 */
public class TimeoutRequestDto implements Serializable {

    /**
     * ID
     */
    private String id;
    /**
     * Delay Time
     */
    private Long delayTime;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the delayTime
     */
    public Long getDelayTime() {
        return delayTime;
    }

    /**
     * @param delayTime the delayTime to set
     */
    public void setDelayTime(Long delayTime) {
        this.delayTime = delayTime;
    }
}
