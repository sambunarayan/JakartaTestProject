/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.ejbremote.service;

import javax.ejb.embeddable.EJBContainer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author soyou
 */
public class EJBServiceTest {
    
    public EJBServiceTest() {
    }

    /**
     * Test of call method, of class EJBService.
     */
    @Test
    public void testCall() throws Exception {
        System.out.println("call");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EJBService instance = (EJBService)container.getContext().lookup("java:global/classes/EJBService");
        instance.call();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
