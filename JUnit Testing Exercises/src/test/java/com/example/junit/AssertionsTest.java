package com.example.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise 3: Assertions in JUnit.
 * Demonstrates the most commonly used JUnit 5 assertions.
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());

        // Assert arrays are equal
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        // Assert that an exception is thrown
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        });
    }
}
