# Base image
FROM eclipse-temurin:21-jdk-alpine

# Set workdir
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copy source code
COPY . .

# Package app
RUN ./mvnw package -DskipTests

# Expose port
EXPOSE 8080

# Run app
CMD ["java", "-jar", "target/ProductListingBackend-0.0.1-SNAPSHOT.jar"]
