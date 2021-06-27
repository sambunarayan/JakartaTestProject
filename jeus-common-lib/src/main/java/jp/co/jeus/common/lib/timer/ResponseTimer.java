/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.timer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author soyou
 */
public final class ResponseTimer {

    private enum Keys {
        START_TIME,
        TIMEOUT_MILISECONDS;
    }

    private static ConcurrentMap<Long, Map<Keys, Long>> timeoutMap = new ConcurrentHashMap<>();

    private static ConcurrentMap<Thread, Long> timeoutMapForThread = new ConcurrentHashMap<>();

    private ResponseTimer() {

    }

    public static void registForThreadMap(Thread t) {
        timeoutMapForThread.put(t, System.currentTimeMillis());
    }

    public static void regist(Thread t, Long timeout) {
//        timeoutMap.put(t.getId(), Map.of(Keys.START_TIME, System.currentTimeMillis(), Keys.TIMEOUT_MILISECONDS, timeout));
        Map<Keys, Long> tempMap = new HashMap<>();
        tempMap.put(Keys.START_TIME, System.currentTimeMillis());
        tempMap.put(Keys.TIMEOUT_MILISECONDS, timeout);
        timeoutMap.put(t.getId(), tempMap);
    }

    public static void remove(Thread t) {
        timeoutMap.remove(t.getId());
    }

    public static long getStartedTime(Thread t) {
        return timeoutMap.get(t.getId()).get(Keys.START_TIME);
    }

    public static long getRemaingTime(Thread t) {
        return getRemaingTime(t.getId());

    }

    public static long getRemaingTime(long tId) {
        return timeoutMap.get(tId).get(Keys.TIMEOUT_MILISECONDS)
                - (System.currentTimeMillis() - timeoutMap.get(tId).get(Keys.START_TIME));

    }

    public static void showMap() {
        System.out.println("TimeoutMap --> " + timeoutMap);
    }
}
