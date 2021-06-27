/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.jeus.common.lib.immutable;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author soyou
 */
public class ImmutableByteArrayTest {

    private ImmutableByteArray instance;
    private ImmutableByteArray instance2;

    public ImmutableByteArrayTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        instance = new ImmutableByteArray("abc");
        instance2 = new ImmutableByteArray("bcd");
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of concat method, of class ImmutableByteArray.
     */
    @Test
    public void testConcat() {
        System.out.println("concat");
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        assertArrayEquals(instance.concat(instance2.getBytes()), "abcbcd".getBytes());
        assertEquals(new String(instance.concat(instance2.getBytes())), "abcbcd");
        assertNotEquals(new String(instance.concat(instance2.getBytes())), "abcbc");
    }

    /**
     * Test of getBytes method, of class ImmutableByteArray.
     */
    @Test
    public void testGetBytes() {
        System.out.println("getBytes");
        assertArrayEquals(instance.getBytes(), instance.getBytes());
        assertNotEquals(instance.getBytes().hashCode(), instance.getBytes().hashCode());
    }

    /**
     * Test of getLength method, of class ImmutableByteArray.
     */
    @Test
    public void testGetLength() {
        System.out.println("getLength");
        assertEquals(instance.getLength(), instance.getBytes().length);
    }

    /**
     * Test of equalsArray method, of class ImmutableByteArray.
     */
    @Test
    public void testEqualsArray() {
        assertEquals(instance.equalsArray(null), false);
        assertEquals(instance.equalsArray("ab".getBytes()), false);
        assertEquals(instance.equalsArray("abcd".getBytes()), false);
        assertEquals(instance.equalsArray("abc".getBytes()), true);
    }

    /**
     * Test of equals method, of class ImmutableByteArray.
     */
    @Test
    public void testEquals() {
        assertEquals(instance.equals(null), false);
        assertEquals(instance.equals("abc".getBytes()), false);
        assertEquals(instance.equals(new ImmutableByteArray("abd".getBytes())), false);
        assertEquals(instance.equals(new ImmutableByteArray("abc".getBytes())), true);
    }

}
