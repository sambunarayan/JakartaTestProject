/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import jp.co.jeu.jbatch.system.SystemSettingsManager;

/**
 *
 * @author soyou
 */
public class BatchAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        String systemFilePath = event.getServletContext().getInitParameter("SYSTEM_FILE_PATH");
        if (systemFilePath == null) {
            SystemSettingsManager.load();
        } else {
            System.out.println("context initialize [SystemSettingFilePath] : " + systemFilePath);
            SystemSettingsManager.load(systemFilePath);
        }
        System.out.println("context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("contextDestroyed()");
    }
}
