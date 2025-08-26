# =========================
# Stage 1: Build with Maven
# =========================
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies first (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Run with JDK
# =========================
FROM eclipse-temurin:17-jdk-jammy

# Set working directory
WORKDIR /app

# Copy only the JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Run as non-root user for security
RUN useradd -m appuser && chown -R spring:spring /app
USER appuser

# Expose application port
EXPOSE 8080

# Set entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]