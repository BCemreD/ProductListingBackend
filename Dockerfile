# Base image
FROM eclipse-temurin:21-jdk-alpine

# Set workdir
WORKDIR /app

# Copy entire project
COPY . .

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Package app
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run app
CMD ["java", "-jar", "target/ProductListingBackend-0.0.1-SNAPSHOT.jar"]
