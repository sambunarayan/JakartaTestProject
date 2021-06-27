/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeu.jbatch.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author soyou
 */
public final class UserInfoIdCeator {

    private static final String SERIAL_FORMAT = "%03d";

    private static AtomicInteger SERIAL = new AtomicInteger();

    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyMMddHHmmssSSS");

    private UserInfoIdCeator() {
        throw new IllegalStateException();
    }

    public static String create() {
        return new StringBuilder()
                .append(LocalDateTime.now().format(format))
                .append(getSerial())
                .toString();
    }

    private static String getSerial() {
        return String.format(SERIAL_FORMAT,
                SERIAL.accumulateAndGet(999, (n, m) -> {
                    return n <= 999 ? n + 1 : 1;
                }));
    }
}
