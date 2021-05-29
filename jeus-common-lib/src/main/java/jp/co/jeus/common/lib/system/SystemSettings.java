/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.system;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import jp.co.jeus.common.lib.constants.Environment;

/**
 *
 * @author soyou
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "system-setting")
public class SystemSettings {

    @XmlElement(name = "environment")
    private Environment environment;
    @XmlElement(name = "description")
    private String description;

    @XmlElementWrapper(name = "settings")
    @XmlElement(name = "setting")
    private List<Setting> settings;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "setting")
    public class Setting {

        @XmlElement(name = "key")
        private String key;
        @XmlElement(name = "value")
        private String value;

        /**
         * @return the key
         */
        public String getKey() {
            return key;
        }

        /**
         * @param key the key to set
         */
        public void setKey(String key) {
            this.key = key;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + key + "," + value + "]";
        }
    }

    /**
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * @param environment the environment to set
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the settings
     */
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     * @param settings the settings to set
     */
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

}
