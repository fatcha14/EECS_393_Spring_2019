package com.example.quickoff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ProductUnitTest {
    Product test1 = new Product(false, "test", 123, "test done");
    @Test
    public void getSource_isCorrect() {
        assertEquals(false, test1.getSource());
    }
    @Test
    public void getName_isCorrect() {
        assertEquals("test", test1.getName());
    }
    @Test
    public void getPrice_isCorrect() {
        assertEquals(123, test1.getPrice(), 0.1);
    }
    @Test
    public void getDescription_isCorrect() {
        assertEquals("test done", test1.getDescription());
    }
    @Test
    public void setSource_isCorrect() {
        test1.setSource(true);
        assertEquals(true, test1.getSource());
    }
    @Test
    public void setName_isCorrect() {
        test1.setName("changed");
        assertEquals("changed", test1.getName());
    }
    @Test
    public void setPrice_isCorrect() {
        test1.setPrice(333.0);
        assertEquals(333.0, test1.getPrice(),0.1);
    }
    @Test
    public void setDescription_isCorrect() {
        test1.setDescription("test for set");
        assertEquals("test for set", test1.getDescription());
    }
}