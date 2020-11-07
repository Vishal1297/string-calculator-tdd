package com.tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void init() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void destroy() {
        stringCalculator = null;
    }

    @Test
    @DisplayName("Test Empty String")
    public void testEmptyString() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @DisplayName("Test One Number")
    public void testAddOneNumber() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    @DisplayName("Test Multiple Numbers")
    public void testAddMultipleNumbers() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    @DisplayName("Test New Line")
    public void testNewLine() {
        assertEquals(10, stringCalculator.add("1\n2,3\n4"));
    }

    @Test
    @DisplayName("Test Negative Number")
    public void testNegativeNumber() {
        try {
            stringCalculator.add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }
        try {
            stringCalculator.add("1,-2,3,-5");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negatives not allowed: -2,-5");
        }
    }

    @Test
    @DisplayName("Test Over Thousand")
    public void testOverThousand() {
        assertEquals(10, stringCalculator.add("1000,10"));
    }

    @Test
    @DisplayName("Test Other Delimiter")
    public void testOtherDelimiter() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

}
