# Calculator Spring Boot Application

A simple REST API calculator application built with Spring Boot that provides basic mathematical operations: addition, subtraction, and multiplication.

## Features

- **Addition**: Add two numbers
- **Subtraction**: Subtract one number from another
- **Multiplication**: Multiply two numbers
- **Input Validation**: Validates input parameters
- **Comprehensive Testing**: Unit tests and integration tests
- **Health Check**: Endpoint to check service status

## Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Maven** for dependency management
- **JUnit 5** for testing
- **Mockito** for mocking in tests
- **Spring Boot Test** for integration testing

## Project Structure

```
calculator-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/calculator/
│   │   │   ├── CalculatorApplication.java          # Main application class
│   │   │   ├── controller/
│   │   │   │   └── CalculatorController.java       # REST controller
│   │   │   ├── service/
│   │   │   │   └── CalculatorService.java          # Business logic
│   │   │   └── dto/
│   │   │       ├── CalculatorRequest.java          # Request DTO
│   │   │       └── CalculatorResponse.java         # Response DTO
│   │   └── resources/
│   │       └── application.properties              # Configuration
│   └── test/
│       └── java/com/example/calculator/
│           ├── CalculatorApplicationTest.java      # Integration tests
│           ├── controller/
│           │   └── CalculatorControllerTest.java   # Controller tests
│           └── service/
│               └── CalculatorServiceTest.java      # Service unit tests
├── pom.xml                                         # Maven configuration
└── README.md                                       # This file
```

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. **Clone or navigate to the project directory**
   ```bash
   cd calculator-app
   ```

2. **Build the project**
   ```bash
   mvn clean compile
   ```

3. **Run the tests**
   ```bash
   mvn test
   ```

4. **Start the application**
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`

### Building JAR

```bash
mvn clean package
java -jar target/calculator-app-1.0.0.jar
```

## API Endpoints

### Health Check
- **GET** `/api/calculator/health`
- **Response**: `"Calculator service is running!"`

### Addition
- **POST** `/api/calculator/add`
- **Request Body**:
  ```json
  {
    "a": 5.0,
    "b": 3.0
  }
  ```
- **Response**:
  ```json
  {
    "result": 8.0,
    "operation": "addition",
    "operandA": 5.0,
    "operandB": 3.0
  }
  ```

### Subtraction
- **POST** `/api/calculator/subtract`
- **Request Body**:
  ```json
  {
    "a": 10.0,
    "b": 3.0
  }
  ```
- **Response**:
  ```json
  {
    "result": 7.0,
    "operation": "subtraction",
    "operandA": 10.0,
    "operandB": 3.0
  }
  ```

### Multiplication
- **POST** `/api/calculator/multiply`
- **Request Body**:
  ```json
  {
    "a": 4.0,
    "b": 3.0
  }
  ```
- **Response**:
  ```json
  {
    "result": 12.0,
    "operation": "multiplication",
    "operandA": 4.0,
    "operandB": 3.0
  }
  ```

## Testing with cURL

### Health Check
```bash
curl -X GET http://localhost:8080/api/calculator/health
```

### Addition
```bash
curl -X POST http://localhost:8080/api/calculator/add \
  -H "Content-Type: application/json" \
  -d '{"a": 5.0, "b": 3.0}'
```

### Subtraction
```bash
curl -X POST http://localhost:8080/api/calculator/subtract \
  -H "Content-Type: application/json" \
  -d '{"a": 10.0, "b": 3.0}'
```

### Multiplication
```bash
curl -X POST http://localhost:8080/api/calculator/multiply \
  -H "Content-Type: application/json" \
  -d '{"a": 4.0, "b": 3.0}'
```

## Testing

The application includes comprehensive testing:

### Unit Tests
- **CalculatorServiceTest**: Tests all mathematical operations with various scenarios
  - Positive numbers
  - Negative numbers
  - Decimal numbers
  - Zero values
  - Edge cases

### Integration Tests
- **CalculatorControllerTest**: Tests REST endpoints with mocked service
- **CalculatorApplicationTest**: Full end-to-end integration tests

### Running Tests

```bash
# Run all tests
mvn test

# Run only unit tests
mvn test -Dtest="*ServiceTest"

# Run only integration tests
mvn test -Dtest="*ControllerTest,*ApplicationTest"

# Run tests with coverage report
mvn test jacoco:report
```

## Error Handling

The application handles various error scenarios:

- **400 Bad Request**: Invalid input (null values, malformed JSON)
- **500 Internal Server Error**: Unexpected server errors

## Configuration

The application can be configured via `application.properties`:

```properties
# Server configuration
server.port=8080

# Application name
spring.application.name=calculator-app

# Logging levels
logging.level.com.example.calculator=INFO
logging.level.org.springframework.web=DEBUG

# JSON formatting
spring.jackson.serialization.indent-output=true
```

## Future Enhancements

Potential improvements for the calculator application:

1. **Division Operation**: Add division with zero-division error handling
2. **Advanced Operations**: Square root, power, logarithm
3. **History**: Store calculation history
4. **Swagger Documentation**: API documentation with Swagger/OpenAPI
5. **Database Integration**: Persist calculations
6. **Security**: Add authentication and authorization
7. **Rate Limiting**: Prevent API abuse
8. **Metrics**: Add application metrics and monitoring

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## License

This project is licensed under the MIT License.