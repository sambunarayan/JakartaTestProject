/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jeus.stub.tool;

import javax.xml.bind.JAXB;
import jp.co.jeu.jeus.stub.xml.ResponseDatas;

/**
 *
 * @author soyou
 */
public class ResponseXmlReader {

    public static ResponseDatas get(String xmlUrl) {
        try {
            ResponseDatas responseData = JAXB.unmarshal(xmlUrl, ResponseDatas.class);
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
