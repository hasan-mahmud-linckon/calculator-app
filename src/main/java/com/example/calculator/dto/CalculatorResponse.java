package com.example.calculator.dto;

/**
 * Response DTO for calculator operations
 */
public class CalculatorResponse {
    
    private double result;
    private String operation;
    private double operandA;
    private double operandB;

    public CalculatorResponse() {}

    public CalculatorResponse(double result, String operation, double operandA, double operandB) {
        this.result = result;
        this.operation = operation;
        this.operandA = operandA;
        this.operandB = operandB;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getOperandA() {
        return operandA;
    }

    public void setOperandA(double operandA) {
        this.operandA = operandA;
    }

    public double getOperandB() {
        return operandB;
    }

    public void setOperandB(double operandB) {
        this.operandB = operandB;
    }

    @Override
    public String toString() {
        return "CalculatorResponse{" +
                "result=" + result +
                ", operation='" + operation + '\'' +
                ", operandA=" + operandA +
                ", operandB=" + operandB +
                '}';
    }
}