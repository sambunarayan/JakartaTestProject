/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.etc;

import jp.co.jeus.common.lib.utils.*;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author soyou
 */
public class JvmMemoryTest {

    public JvmMemoryTest() {
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

    @Test
    public void test() {
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
        try {
            List<String> list = new ArrayList<>();
            while (true) {
                list.add("out of memory test");
            }
        } catch (Throwable e) {
            System.out.println(ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
            e.printStackTrace();
        }
    }

}
