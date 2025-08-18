# Base image
FROM eclipse-temurin:21-jdk-alpine

# Set workdir
WORKDIR /app

# Copy pom.xml, mvnw and .mvn folder
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# Make mvnw executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Package app
RUN ./mvnw package -DskipTests

# Expose port
EXPOSE 8080

# Run app
CMD ["java", "-jar", "target/ProductListingBackend-0.0.1-SNAPSHOT.jar"]
