/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author soyou
 */
public final class StringUtility {

    private StringUtility() {
        throw new IllegalStateException("Utility Class");
    }

    public static String toMaskedJson(String json) {
        Set<String> target = new HashSet<>();
        target.add("addr");
        Map<String, Integer> keyMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = json.toCharArray();
        boolean isKey = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '{' || arr[i] == ',') {
                isKey = true;
            } else if (arr[i] == '\"') {
                continue;
            } else if (arr[i] == ':') {
                isKey = false;
                String key = sb.toString().toLowerCase().replaceAll("[^a-z0-9]", "");
                System.out.println(key);
                if (target.contains(key)) {
                    keyMap.put(key, i + 2);
                }
                sb = new StringBuilder();
            } else if (isKey) {
                sb.append(arr[i]);
            }
        }
        return json;
    }
}
