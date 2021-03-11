/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author soyou
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Settings {

    @XmlElement(name = "setting")
    private List<Setting> settingList;

    /**
     * @return the settingList
     */
//    @XmlElementWrapper(name="batch-settings")
//    @XmlElement(name = "setting")
    public List<Setting> getSettingList() {
        return settingList;
    }

    /**
     * @param settingList the settingList to set
     */
    public void setSettingList(List<Setting> settingList) {
        this.settingList = settingList;
    }
}
