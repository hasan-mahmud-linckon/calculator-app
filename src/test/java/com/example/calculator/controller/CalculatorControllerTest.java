package com.example.calculator.controller;

import com.example.calculator.dto.CalculatorRequest;
import com.example.calculator.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for CalculatorController
 */
@WebMvcTest(CalculatorController.class)
@DisplayName("Calculator Controller Integration Tests")
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Should return health status")
    void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/calculator/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Calculator service is running!"));
    }

    @Test
    @DisplayName("Should perform addition successfully")
    void testAddEndpoint() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(5.0, 3.0);
        when(calculatorService.add(5.0, 3.0)).thenReturn(8.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8.0))
                .andExpect(jsonPath("$.operation").value("addition"))
                .andExpect(jsonPath("$.operandA").value(5.0))
                .andExpect(jsonPath("$.operandB").value(3.0));
    }

    @Test
    @DisplayName("Should perform subtraction successfully")
    void testSubtractEndpoint() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(10.0, 3.0);
        when(calculatorService.subtract(10.0, 3.0)).thenReturn(7.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(7.0))
                .andExpect(jsonPath("$.operation").value("subtraction"))
                .andExpect(jsonPath("$.operandA").value(10.0))
                .andExpect(jsonPath("$.operandB").value(3.0));
    }

    @Test
    @DisplayName("Should perform multiplication successfully")
    void testMultiplyEndpoint() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(4.0, 3.0);
        when(calculatorService.multiply(4.0, 3.0)).thenReturn(12.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(12.0))
                .andExpect(jsonPath("$.operation").value("multiplication"))
                .andExpect(jsonPath("$.operandA").value(4.0))
                .andExpect(jsonPath("$.operandB").value(3.0));
    }

    @Test
    @DisplayName("Should return bad request for invalid input - null values")
    void testAddEndpointWithNullValues() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(null, 3.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should return bad request for invalid JSON")
    void testAddEndpointWithInvalidJson() throws Exception {
        // When & Then
        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{invalid json}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Should handle negative numbers in addition")
    void testAddEndpointWithNegativeNumbers() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(-5.0, 3.0);
        when(calculatorService.add(-5.0, 3.0)).thenReturn(-2.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(-2.0))
                .andExpect(jsonPath("$.operation").value("addition"))
                .andExpect(jsonPath("$.operandA").value(-5.0))
                .andExpect(jsonPath("$.operandB").value(3.0));
    }

    @Test
    @DisplayName("Should handle decimal numbers in multiplication")
    void testMultiplyEndpointWithDecimals() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(2.5, 4.0);
        when(calculatorService.multiply(2.5, 4.0)).thenReturn(10.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(10.0))
                .andExpect(jsonPath("$.operation").value("multiplication"))
                .andExpect(jsonPath("$.operandA").value(2.5))
                .andExpect(jsonPath("$.operandB").value(4.0));
    }

    @Test
    @DisplayName("Should handle zero in subtraction")
    void testSubtractEndpointWithZero() throws Exception {
        // Given
        CalculatorRequest request = new CalculatorRequest(5.0, 0.0);
        when(calculatorService.subtract(5.0, 0.0)).thenReturn(5.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5.0))
                .andExpect(jsonPath("$.operation").value("subtraction"))
                .andExpect(jsonPath("$.operandA").value(5.0))
                .andExpect(jsonPath("$.operandB").value(0.0));
    }
}