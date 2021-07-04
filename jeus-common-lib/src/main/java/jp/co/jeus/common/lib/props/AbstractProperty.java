/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.props;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import jp.co.jeus.common.lib.dto.annotation.PropertyAnnotation;

/**
 *
 * @author soyou
 */
public abstract class AbstractProperty {

    private static final Map<Class<? extends AbstractProperty>, ResourceBundle> PROP_HOLDER = new HashMap<>();

    protected static void setBundle(Class<? extends AbstractProperty> clazz) {
        for (Annotation anno : clazz.getAnnotations()) {
            if (anno instanceof PropertyAnnotation) {
                Properties pro = new Properties();
                PropertyAnnotation propAnno = clazz.getAnnotation(PropertyAnnotation.class);
                if (propAnno == null) {
                    return;
                }
                PROP_HOLDER.put(clazz, PropertyResourceBundle.getBundle(propAnno.bundle()));
            }
        }
    }

    protected static String get(Class<? extends AbstractProperty> clazz, String key) {
        return PROP_HOLDER.get(clazz).getString(key);
    }
}
