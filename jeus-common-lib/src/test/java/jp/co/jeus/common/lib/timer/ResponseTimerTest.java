/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.timer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author soyou
 */
public class ResponseTimerTest {

    public ResponseTimerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of regist method, of class ResponseTimer.
     */
    @Test
    public void testRegist() {
        System.out.println("regist");
        ResponseTimer.regist(Thread.currentThread(), 10000L);
        try {
            System.out.println("start Thread id : " + Thread.currentThread().getId());
            System.out.println(ResponseTimer.getStartedTime(Thread.currentThread()));
            new Thread(() -> {
                System.out.println("Runnable Thread id : " + Thread.currentThread().getId());
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                }
//                ResponseTimer.registForThreadMap(Thread.currentThread());
//                ResponseTimer.showMap();
            }).start();
            System.out.println("After Runnable Thread id : " + Thread.currentThread().getId());
            TimeUnit.SECONDS.sleep(1);
            ResponseTimer.showMap();
            CompletableFuture f = CompletableFuture.supplyAsync(() -> {
                System.out.println("start Thread id : " + Thread.currentThread().getId());
                System.out.println(ResponseTimer.getStartedTime(Thread.currentThread()));
                return false;
            });
            try {
                System.out.println("start Thread id : " + Thread.currentThread().getId());
                System.out.println(ResponseTimer.getStartedTime(Thread.currentThread()));
                f.get(2, TimeUnit.SECONDS);
            } catch (ExecutionException | TimeoutException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                System.out.println("start Thread id : " + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ResponseTimer.getStartedTime(Thread.currentThread()));
        System.out.println(ResponseTimer.getStartedTime(Thread.currentThread()));
        System.out.println(ResponseTimer.getRemaingTime(Thread.currentThread()));
        System.out.println(ResponseTimer.getRemaingTime(Thread.currentThread()));
    }

    @Test
    public void testRegist2() {
        ResponseTimer.regist(Thread.currentThread(), 10000L);
        System.out.println(Thread.currentThread().getId() + " -> " + ResponseTimer.getRemaingTime(Thread.currentThread()));
        CompletableFuture future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future was started");
            System.out.println(Thread.currentThread().getId() + " -> " + ResponseTimer.getRemaingTime(Thread.currentThread()));
            try {
                TimeUnit.SECONDS.sleep(9);
            } catch (InterruptedException ex) {
                Logger.getLogger(ResponseTimerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        });
        try {
            System.out.println(future.get(10L, TimeUnit.SECONDS));
            System.out.println("After " + Thread.currentThread().getId() + " -> " + ResponseTimer.getRemaingTime(Thread.currentThread()));
            
            TimeUnit.SECONDS.sleep(11);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException ex) {
        } catch (TimeoutException ex) {
        }
    }

    private void test() {

    }

}
