# Step 1: Use Java 21 base image
FROM openjdk:21-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# 🧪 Run tests
RUN ./mvnw test

# Step 3: Copy your jar into the container
COPY target/testproja-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose port (default for Spring Boot)
EXPOSE 8080

# Step 5: Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

