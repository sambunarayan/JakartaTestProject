/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jakarta.logic;

import jp.co.jeu.jakarta.dao.TestDao;

/**
 *
 * @author soyou
 */
public class TestLogic {
    
    public static void main(String[] args) {
        TestDao dao = new TestDao();
        dao.insertTest();
        
    }
}
