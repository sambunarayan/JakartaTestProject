/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jsftest.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author soyou
 */
@Named
@RequestScoped
public class User {

    private String name;
    private String addr;

    public User() {
        this.addr = "Fukuoka";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }

    /**
     * @param addr the addr to set
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
}
