/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.xml;

import java.io.StringReader;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author soyou
 */
public class XmlReader {

    public XmlReader() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<batch-settings>"
                + "    <setting>"
                + "        <key>1</key>"
                + "        <value>a</value>"
                + "    </setting>"
                + "    <setting>"
                + "        <key>2</key>"
                + "        <value>b</value>"
                + "    </setting>"
                + "</batch-settings>"
                + "";

        try {
            Settings settings = JAXB.unmarshal(new StringReader(xml), Settings.class);
            settings.getSettingList().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
