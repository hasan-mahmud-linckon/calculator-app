package com.example.calculator.service;

import org.springframework.stereotype.Service;

/**
 * Calculator service that provides basic mathematical operations
 */
@Service
public class CalculatorService {

    /**
     * Adds two numbers
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts second number from first number
     * @param a first number (minuend)
     * @param b second number (subtrahend)
     * @return difference of a and b
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public double multiply(double a, double b) {
        return a * b;
    }
}