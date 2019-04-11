package com.example.quickoff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PreferredListUnitTest {
    @Test
    public void constructor1_isCorrect() {
        PreferredList test1 = new PreferredList();
        assertNull(test1.head);
        assertNull(test1.ptr);
    }

    @Test
    public void constructor2_isCorrect() {
        Product testProduct = new Product(false, "test", 200.0, "test des");
        PreferredList testList = new PreferredList(testProduct);
        assertEquals(testProduct, testList.head.data);
        assertEquals(testProduct, testList.ptr.data);
    }

    @Test
    public void add_isCorrect() {
        Product testProduct1 = new Product(false, "test", 200.0, "test des");
        Product testProduct2 = new Product(false, "test", 200.0, "test des");
        PreferredList testList = new PreferredList();
        testList.add(testProduct1);
        assertEquals(testProduct1, testList.head.data);
        assertEquals(testProduct1, testList.ptr.data);
        testList.add(testProduct2);
        assertEquals(testProduct1, testList.head.data);
        assertEquals(testProduct2, testList.ptr.data);
    }

    @Test
    public void asArray_isCorrect() {
        Product testProduct1 = new Product(false, "test1", 200.0, "test des");
        Product testProduct2 = new Product(false, "test2", 200.0, "test des");
        PreferredList testList = new PreferredList();
        testList.add(testProduct1);
        testList.add(testProduct2);
        String[] expected = new String[2];
        expected[0] = "test1";
        expected[1] = "test2";
        assertEquals(expected, testList.asArray());
    }
}