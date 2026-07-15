package com.example.junit;

import com.example.model.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise 2: Writing Basic JUnit Tests.
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and
 * Teardown Methods in JUnit.
 *
 * @BeforeEach / @AfterEach are the JUnit 5 equivalents of JUnit 4's @Before / @After.
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Runs before every test method - creates a fresh fixture
        calculator = new Calculator();
        System.out.println("Setting up Calculator instance");
    }

    @AfterEach
    public void tearDown() {
        // Runs after every test method - cleans up the fixture
        calculator = null;
        System.out.println("Tearing down Calculator instance");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 6;
        int b = 7;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(42, result);
    }

    @Test
    public void testDivide() {
        // Arrange
        int a = 20;
        int b = 4;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testDivideByZeroThrows() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
    }
}
