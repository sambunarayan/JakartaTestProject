/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.timer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author soyou
 */
public final class ResponseTimer {

    private static Map<Long, Long> timeoutMap = new HashMap<>();

    private ResponseTimer() {

    }

    public static void regist(Thread t, long timeout) {
        timeoutMap.put(t.getId(), timeout);
    }

    public static void remove(Thread t) {
        timeoutMap.remove(t.getId());
    }
}
