/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.stub.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soyou
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response-setting")
public class ResponseDatas {

    @XmlElement(name = "description")
    private String description;

    @XmlElementWrapper(name = "response-data")
    @XmlElement(name = "data")
    private List<ResponseXml> data;

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
     * @return the data
     */
    public List<ResponseXml> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<ResponseXml> data) {
        this.data = data;
    }
}
