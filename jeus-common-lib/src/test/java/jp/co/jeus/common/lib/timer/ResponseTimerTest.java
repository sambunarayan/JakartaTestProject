/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.timer;

import java.util.concurrent.CompletableFuture;
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
        ResponseTimer.regist(Thread.currentThread(), 10000);

//        CompletableFuture exec = CompletableFuture.supplyAsync(()->test());
    }

    private void test() {

    }

}
