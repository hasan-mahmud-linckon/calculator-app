package com.example.calculator;

import com.example.calculator.dto.CalculatorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Full integration tests for the Calculator Application
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Calculator Application Integration Tests")
class CalculatorApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @Test
    @DisplayName("Should load application context")
    void contextLoads() {
        // This test ensures that the Spring context loads successfully
    }

    @Test
    @DisplayName("Should perform end-to-end addition test")
    void testEndToEndAddition() throws Exception {
        // Setup
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        // Given
        CalculatorRequest request = new CalculatorRequest(15.5, 4.5);

        // When & Then
        mockMvc.perform(post("/api/calculator/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(20.0))
                .andExpect(jsonPath("$.operation").value("addition"))
                .andExpect(jsonPath("$.operandA").value(15.5))
                .andExpect(jsonPath("$.operandB").value(4.5));
    }

    @Test
    @DisplayName("Should perform end-to-end subtraction test")
    void testEndToEndSubtraction() throws Exception {
        // Setup
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        // Given
        CalculatorRequest request = new CalculatorRequest(20.0, 7.5);

        // When & Then
        mockMvc.perform(post("/api/calculator/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(12.5))
                .andExpect(jsonPath("$.operation").value("subtraction"))
                .andExpect(jsonPath("$.operandA").value(20.0))
                .andExpect(jsonPath("$.operandB").value(7.5));
    }

    @Test
    @DisplayName("Should perform end-to-end multiplication test")
    void testEndToEndMultiplication() throws Exception {
        // Setup
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        // Given
        CalculatorRequest request = new CalculatorRequest(6.0, 7.0);

        // When & Then
        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(42.0))
                .andExpect(jsonPath("$.operation").value("multiplication"))
                .andExpect(jsonPath("$.operandA").value(6.0))
                .andExpect(jsonPath("$.operandB").value(7.0));
    }

    @Test
    @DisplayName("Should return health status in integration test")
    void testHealthEndpointIntegration() throws Exception {
        // Setup
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        mockMvc.perform(get("/api/calculator/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("Calculator service is running!"));
    }
}