/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.timer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author soyou
 */
public final class ResponseTimer {

    private static ConcurrentMap<Long, Long> timeoutMap = new ConcurrentHashMap<>();

    private static ConcurrentMap<Thread, Long> timeoutMapForThread = new ConcurrentHashMap<>();

    private ResponseTimer() {

    }

    public static void registForThreadMap(Thread t) {
        timeoutMapForThread.put(t, System.currentTimeMillis());
    }

    public static void regist(Thread t) {
        timeoutMap.put(t.getId(), System.currentTimeMillis());
    }

    public static void remove(Thread t) {
        timeoutMap.remove(t.getId());
    }

    public static long getStartedTime(Thread t) {
        return timeoutMap.get(t.getId());
    }

    public static long getPassedTime(Thread t) {
        return System.currentTimeMillis() - timeoutMap.get(t.getId());
    }

    public static void showMap() {
        System.out.println(timeoutMapForThread);
    }
}
