package com.example.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CalculatorService
 */
@ExtendWith(MockitoExtension.class)
@DisplayName("Calculator Service Tests")
class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("Should add two positive numbers correctly")
    void testAddPositiveNumbers() {
        // Given
        double a = 5.0;
        double b = 3.0;
        double expected = 8.0;

        // When
        double result = calculatorService.add(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should add positive and negative numbers correctly")
    void testAddPositiveAndNegativeNumbers() {
        // Given
        double a = 10.0;
        double b = -3.0;
        double expected = 7.0;

        // When
        double result = calculatorService.add(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should add two negative numbers correctly")
    void testAddNegativeNumbers() {
        // Given
        double a = -5.0;
        double b = -3.0;
        double expected = -8.0;

        // When
        double result = calculatorService.add(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should add decimal numbers correctly")
    void testAddDecimalNumbers() {
        // Given
        double a = 2.5;
        double b = 3.7;
        double expected = 6.2;

        // When
        double result = calculatorService.add(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should add zero correctly")
    void testAddWithZero() {
        // Given
        double a = 5.0;
        double b = 0.0;
        double expected = 5.0;

        // When
        double result = calculatorService.add(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should subtract two positive numbers correctly")
    void testSubtractPositiveNumbers() {
        // Given
        double a = 10.0;
        double b = 3.0;
        double expected = 7.0;

        // When
        double result = calculatorService.subtract(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should subtract resulting in negative number")
    void testSubtractResultingInNegative() {
        // Given
        double a = 3.0;
        double b = 10.0;
        double expected = -7.0;

        // When
        double result = calculatorService.subtract(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should subtract negative numbers correctly")
    void testSubtractNegativeNumbers() {
        // Given
        double a = -5.0;
        double b = -3.0;
        double expected = -2.0;

        // When
        double result = calculatorService.subtract(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should subtract decimal numbers correctly")
    void testSubtractDecimalNumbers() {
        // Given
        double a = 7.5;
        double b = 2.3;
        double expected = 5.2;

        // When
        double result = calculatorService.subtract(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should subtract zero correctly")
    void testSubtractWithZero() {
        // Given
        double a = 5.0;
        double b = 0.0;
        double expected = 5.0;

        // When
        double result = calculatorService.subtract(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should multiply two positive numbers correctly")
    void testMultiplyPositiveNumbers() {
        // Given
        double a = 4.0;
        double b = 3.0;
        double expected = 12.0;

        // When
        double result = calculatorService.multiply(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should multiply positive and negative numbers correctly")
    void testMultiplyPositiveAndNegativeNumbers() {
        // Given
        double a = 5.0;
        double b = -3.0;
        double expected = -15.0;

        // When
        double result = calculatorService.multiply(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should multiply two negative numbers correctly")
    void testMultiplyNegativeNumbers() {
        // Given
        double a = -4.0;
        double b = -3.0;
        double expected = 12.0;

        // When
        double result = calculatorService.multiply(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should multiply decimal numbers correctly")
    void testMultiplyDecimalNumbers() {
        // Given
        double a = 2.5;
        double b = 4.0;
        double expected = 10.0;

        // When
        double result = calculatorService.multiply(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should multiply by zero correctly")
    void testMultiplyByZero() {
        // Given
        double a = 5.0;
        double b = 0.0;
        double expected = 0.0;

        // When
        double result = calculatorService.multiply(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }

    @Test
    @DisplayName("Should multiply by one correctly")
    void testMultiplyByOne() {
        // Given
        double a = 7.0;
        double b = 1.0;
        double expected = 7.0;

        // When
        double result = calculatorService.multiply(a, b);

        // Then
        assertEquals(expected, result, 0.001);
    }
}