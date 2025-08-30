package com.example.calculator.dto;

import jakarta.validation.constraints.NotNull;

/**
 * Request DTO for calculator operations
 */
public class CalculatorRequest {
    
    @NotNull(message = "First number cannot be null")
    private Double a;
    
    @NotNull(message = "Second number cannot be null")
    private Double b;

    public CalculatorRequest() {}

    public CalculatorRequest(Double a, Double b) {
        this.a = a;
        this.b = b;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "CalculatorRequest{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}