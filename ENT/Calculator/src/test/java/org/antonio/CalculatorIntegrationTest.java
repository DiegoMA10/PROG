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
        assertNotEquals(, 0);
    }
}
