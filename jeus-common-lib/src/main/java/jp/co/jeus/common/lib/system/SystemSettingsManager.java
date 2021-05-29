/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.system;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXB;
import jp.co.jeus.common.lib.constants.Environment;
import jp.co.jeus.common.lib.system.SystemSettings.Setting;

/**
 *
 * @author soyou
 */
public class SystemSettingsManager {

    private static Map<String, String> settingsMap = new HashMap<>();
    private static Environment environment;

    public static void load() {
        SystemSettings settings = JAXB.unmarshal(SystemSettings.class.getResourceAsStream("/META-INF/SystemSettings.xml"), SystemSettings.class);

        if (environment != null && environment != settings.getEnvironment()) {
            return;
        }
        environment = settings.getEnvironment();
        for (Setting s : settings.getSettings()) {
            settingsMap.put(s.getKey(), s.getValue());
        }
    }

    public static void load(String xml) {
        SystemSettings settings = JAXB.unmarshal(SystemSettings.class.getResourceAsStream(xml), SystemSettings.class);

        if (environment != null && environment != settings.getEnvironment()) {
            return;
        }
        environment = settings.getEnvironment();
        for (Setting s : settings.getSettings()) {
            settingsMap.put(s.getKey(), s.getValue());
        }
    }

    public static String get(String key) {
        return settingsMap.get(key);
    }
}
