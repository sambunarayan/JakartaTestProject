/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jakarta.logic;

import java.math.BigInteger;
import javax.ejb.EJB;
import jp.co.jeu.jakarta.dao.TestDao;
import jp.co.jeu.jakarta.shared.entity.Test;

/**
 *
 * @author soyou
 */
public class TestLogic {
    
    @EJB
    private TestDao testDao;
    
    public void doTest() {
        Test test = new Test();
        test.setName("Test1");
        test.setAge(BigInteger.valueOf(11L));
        testDao.insertTest(test);
    }
}
