package com.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        StringCalculator simpleCalculator = new StringCalculator();
        assertEquals(0, simpleCalculator.add(""));
        assertEquals(1, simpleCalculator.add("1"));
        assertEquals(2, simpleCalculator.add("2"));
    }

}
