# ProductListingBackend
This project is a robust, Java-based backend application designed to power a dynamic product listing and favoritization system. It provides secure user authentication, efficient product management, and a dedicated favorite product feature, built with modern Spring Boot practices.

## Features
- User Authentication & Authorization: Secure user registration, login, and JWT-based authentication for protected endpoints.
- Product Management: RESTful APIs for retrieving, adding, updating, and deleting product listings.
- Favorite Product Management: Users can add and remove products from their favorites list. Optimized database queries ensure efficient fetching of favorites.
- Modular Architecture: Clean, layered design separating concerns (Controller, Service, Repository).
- Database Management: Utilizes Flyway for seamless database migrations.
- Global Error Handling: Robust error management for clear API responses.

## Technologies Used
- Java 21: The core programming language.
- Spring Boot 3.x: Framework for building robust, stand-alone, production-grade Spring applications.
- Spring Security: Comprehensive security services for the backend, including authentication and authorization.
- JWT (JSON Web Tokens): For stateless, token-based authentication.
- PostgreSQL: Relational database for persistent data storage (e.g., via Supabase, Render PostgreSQL).
- Hibernate / Spring Data JPA: Object-Relational Mapping (ORM) and simplified data access layer.
- Flyway: Database migration tool to manage schema changes.
- Lombok: Library to reduce boilerplate code (getters, setters, constructors).
- Maven: Dependency management and build automation tool.
- Docker: For containerized deployment.
- ModelMapper: For easy object-to-object mapping (e.g., Entity to DTO).

## Getting Started
These instructions will get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
- Java Development Kit (JDK) 21 or higher
- Maven
- PostgreSQL Database: A running PostgreSQL instance (local or hosted, e.g., Supabase, Render PostgreSQL).
- Docker (Optional, for containerization)
- 
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
POST	/api/auth/register	Registers a new user.	None
POST	/api/auth/login	Logs in a user and returns a JWT token and user details.	None
GET	/api/auth/me	Retrieves current authenticated user's details.	JWT Required

### Product
GET	/api/products	Retrieves a list of all products.	None
GET	/api/products/{id}	Retrieves a product by its ID.	None
POST	/api/products	Adds a new product to the database.	JWT Required
PUT	/api/products/{id}	Updates an existing product by ID.	JWT Required
DELETE	/api/products/{id}	Deletes a product by its ID.	JWT Required

### Favorite
GET	/api/favorites/{userId}	Retrieves all favorite products for a user.	JWT Required
POST	/api/favorites/{userId}/{productId}	Adds a product to a user's favorites.	JWT Required
DELETE	/api/favorites/{userId}/{productId}	Removes a product from a user's favorites.	JWT Required

## Frontend Integration
This backend serves as the API for the Product Listing App Frontend.

Frontend Code: [Frontend Code Linkiniz Buraya Gelecek] (e.g., https://github.com/BCemreD/ProductListingFrontend.git)

> [Contributing]   
Contributions are welcome! Please feel free to open issues or submit pull requests.

