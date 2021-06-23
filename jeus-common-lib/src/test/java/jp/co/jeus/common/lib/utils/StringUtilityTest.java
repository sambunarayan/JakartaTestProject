/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author soyou
 */
public class StringUtilityTest {

    public StringUtilityTest() {
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
     * Test of toMaskedJson method, of class StringUtility.
     */
    @Test
    public void testToMaskedJson() {
        String json = "{\"i_d\":\"a_b-c\",\"a~ge\":\"2#2\",\"customInfo\":{\"addr\":\"fukuoka\",\"tel\":\"080\"}}";
        String result = StringUtility.toMaskedJson(json);
    }

}
