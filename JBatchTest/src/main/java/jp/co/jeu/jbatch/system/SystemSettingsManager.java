/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXB;
import jp.co.jeu.jbatch.xml.Settings;

/**
 *
 * @author soyou
 */
public final class SystemSettingsManager {
    
    private static final String DEFAULT_FILE_PATH = "/META-INF/settings.xml";
    
    private static Map<String, String> SETTINGS_MAP = new HashMap<>();
    
    private static boolean initialized = false;
    
    public static void load() {
        if (!initialized) {
            load(DEFAULT_FILE_PATH);
            initialized = true;
        }
    }
    
    public static void load(List<String> filePaths) {
        filePaths.forEach(path -> load(path));
    }
    
    public static void load(String filePath) {
        Settings settings = JAXB.unmarshal(SystemSettingsManager.class.getResourceAsStream(filePath), Settings.class);
        
        if (settings != null) {
            SETTINGS_MAP.put("description", settings.getDescription());
            settings.getSettingList().forEach(s -> {
                SETTINGS_MAP.put(s.getKey(), s.getValue());
            });
        }
    }
    
    public static String get(String key) {
        return SETTINGS_MAP.get(key);
    }
}
