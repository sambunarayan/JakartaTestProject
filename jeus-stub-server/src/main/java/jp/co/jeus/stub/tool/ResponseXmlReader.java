/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.stub.tool;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXB;
import jp.co.jeus.stub.xml.ResponseDatas;

/**
 *
 * @author soyou
 */
public class ResponseXmlReader {

    public static Map<String, String> get(String xmlUrl) {
        Map<String, String> dataMap = new HashMap<>();
        try {
            ResponseDatas responseData = JAXB.unmarshal(xmlUrl, ResponseDatas.class);
            dataMap.put("description", responseData.getDescription());
            responseData.getData().forEach(xmlData -> {
                dataMap.put(xmlData.getKey(), xmlData.getValue());
            });
            return dataMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> getFromResouce(String xmlUrl) {
        System.out.println(ResponseXmlReader.class.getResource(xmlUrl));
        ResponseDatas responseData = JAXB.unmarshal(ResponseXmlReader.class.getResourceAsStream(xmlUrl), ResponseDatas.class);
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("description", responseData.getDescription());
        responseData.getData().forEach(xmlData -> {
            dataMap.put(xmlData.getKey(), xmlData.getValue());
        });
        return dataMap;
    }
}
