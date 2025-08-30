package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorRequest;
import com.example.calculator.dto.CalculatorResponse;
import com.example.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for calculator operations
 */
@RestController
@RequestMapping("/api/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * Addition endpoint
     * @param request containing two numbers to add
     * @return response with the sum
     */
    @PostMapping("/add")
    public ResponseEntity<CalculatorResponse> add(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.add(request.getA(), request.getB());
        CalculatorResponse response = new CalculatorResponse(result, "addition", request.getA(), request.getB());
        return ResponseEntity.ok(response);
    }

    /**
     * Subtraction endpoint
     * @param request containing two numbers to subtract
     * @return response with the difference
     */
    @PostMapping("/subtract")
    public ResponseEntity<CalculatorResponse> subtract(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.subtract(request.getA(), request.getB());
        CalculatorResponse response = new CalculatorResponse(result, "subtraction", request.getA(), request.getB());
        return ResponseEntity.ok(response);
    }

    /**
     * Multiplication endpoint
     * @param request containing two numbers to multiply
     * @return response with the product
     */
    @PostMapping("/multiply")
    public ResponseEntity<CalculatorResponse> multiply(@Valid @RequestBody CalculatorRequest request) {
        double result = calculatorService.multiply(request.getA(), request.getB());
        CalculatorResponse response = new CalculatorResponse(result, "multiplication", request.getA(), request.getB());
        return ResponseEntity.ok(response);
    }

    /**
     * Health check endpoint
     * @return simple status message
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Calculator service is running!");
    }
}