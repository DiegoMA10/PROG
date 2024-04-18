package org.antonio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorIntegrationTest {
    @Test
    public void testAddAndSubstract(){
        Calculator calc = new Calculator();
        assertEquals(0, calc.add(calc.subtract(5, -6), -11));
        assertTrue(calc.add(5, calc.subtract(10, 5))==calc.subtract(20, 10));
        assertFalse(calc.subtract(10, 10)>calc.add(10, 10));
    }

    @Test
    public void testAddWithZero(){
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(5, 0));
        assertNotEquals(6, calc.add(5, 0));
        assertTrue(calc.add(10, 0)<calc.add(10, 1));
    }

    @Test 
    public void testSubstractWithZero(){
        Calculator calc = new Calculator();
        assertEquals(5, calc.subtract(5, 0));
        assertNotEquals(10, calc.subtract(20, 0));
        assertTrue(-25==calc.subtract(0, 25) );
    }

    @Test
    public void testMultiplyAndDivide(){
        Calculator calc = new Calculator();
        assertEquals(25, calc.multiply(5, (int)calc.divide(25, 5)));
        assertNotEquals(1, (int)calc.divide(calc.multiply(5, 5), 1));
        assertTrue(calc.multiply(10, (int)calc.divide(100, 10))==100);
        assertFalse(calc.multiply(0, (int)calc.divide(123, 123))==1);
    }


    @Test
    public void testMultiplyWithZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.multiply(1, 0));
        assertNotEquals(1, calc.multiply(0, 5));
        assertTrue((calc.multiply(0, 25)) == 0);
        assertFalse((calc.multiply(0,-25)) == 25);
    }
    
    @Test
    public void testDivideWithZero() {
        Calculator calc = new Calculator();
        assertEquals(0, calc.divide(0, 5), 0);
        assertNotEquals(5, calc.divide(0, 5));
        assertTrue((calc.divide(0, 25)) == 0);
        assertFalse((calc.divide(0,-25)) == 25);
    }
}
