/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.ejbclient;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author soyou
 */
public class EJBClient {
    
    public static void main(String[] args) {
        Properties prop = new Properties();
        prop.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        
        try {
            InitialContext ic = new InitialContext(prop);
            EJBInterface ejb = (EJBInterface) ic.lookup("java:global/EJBRemote-1.0.0/EjbService!jp.co.jeu.ejbclient.EJBInterface");
            System.out.println(ejb.getName("EJBClient "));
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
}
