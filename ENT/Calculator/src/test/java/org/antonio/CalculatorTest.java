package org.antonio;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeNoException;
public class CalculatorTest {

    @Test
    public void testAdd(){
        Calculator calc = new Calculator();
        assertEquals(5, calc.add(3, 2));
        assertNotEquals(20, calc.add(-10, -10));
        assertTrue(0<=calc.add(4, 2));
        assertFalse(0>=calc.add(4, 2));
    }

    @Test
    public void testSubstract(){
        Calculator calc = new Calculator();
        assertEquals(4, calc.subtract(6, 2));
        assertEquals(-15, calc.subtract(-10, 5));
        assertNotEquals(10, calc.subtract(-5, 5));
        assertFalse(0>=calc.subtract(5, -10));
        assertTrue(0<=calc.subtract(-10, -10));
    }

    @Test
    public void testMultiply(){
        Calculator calc = new Calculator();
        assertEquals(10, calc.multiply(2, 5));
        assertEquals(10, calc.multiply(-2, -5));
        assertNotEquals(25, calc.multiply(5, -5));
        assertTrue(0==calc.multiply(203, 0));
    }

    @Test()
    public void testDivide(){
        Calculator calc = new Calculator();
        assertEquals(4, calc.divide(8, 2),0.0);
        assertEquals(3.33, calc.divide(10, 3),0.1);
        assertNotEquals(5, calc.divide(25, -5),0.0);
        assertEquals(5, calc.divide(-25, -5),0.0);
        assertTrue(calc.divide(10, 10)>0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero(){
        Calculator calc = new Calculator();
        calc.divide(1, 0); 
    }

}
