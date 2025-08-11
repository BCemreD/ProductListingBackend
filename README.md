# ProductListingBackend
This project is a Java-based backend application for managing and listing products. It integrates with Supabase (PostgreSQL) to store and manage product data.

## Technologies Used
Java 17
Spring Boot
Supabase (PostgreSQL)
Docker
Maven

## Getting Started
### Prerequisites
Java 17 or higher
Maven
Docker (optional)

### Installation
Clone the repository:
```bash
git clone https://github.com/BCemreD/ProductListingBackend.git
cd ProductListingBackend
```
Install dependencies:

```bash
mvn install
```
Run the application:
```bash
mvn spring-boot:run
The application will run by default at http://localhost:8080.
```

## API Endpoints
GET /products - Retrieves all products

POST /products - Adds a new product

PUT /products/{id} - Updates a product by ID

DELETE /products/{id} - Deletes a product by ID

