/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.ejbremote.service;

import javax.ejb.Stateless;

/**
 *
 * @author soyou
 */
@Stateless
public class EJBService {
    
    public void call() {
        System.out.println("EJBService called.");
    }
}
