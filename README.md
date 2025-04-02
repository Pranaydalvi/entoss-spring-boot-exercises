# Entoss Spring Boot Exercises

## Overview

This project is a Spring Boot application that includes user authentication using **JWT (JSON Web Token)**. It provides endpoints for user management, authentication, and secure access control.

## Features

- User registration and management
- JWT-based authentication
- Secure endpoints with Spring Security
- RESTful APIs for user CRUD operations
- MySQL database integration

## Technologies Used

- **Java 8+**
- **Spring Boot 2.x**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **JWT (JSON Web Token)**
- **MySQL**
- **Lombok**

## Installation & Setup

### Prerequisites

Ensure you have the following installed:

- Java 8 or later
- MySQL database
- Maven

### Clone the Repository

```sh
git clone https://github.com/Pranaydalvi/entoss-spring-boot-exercises.git
cd entoss-spring-boot-exercises
```

### Configure Database

Update `application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/entoss
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
jwt.secret=MySecretKey
```

### Build & Run the Application

```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints

### User Management

| HTTP Method | Endpoint             | Description         |
| ----------- | -------------------- | ------------------- |
| POST        | `/users/adduser`     | Register a new user |
| GET         | `/users/getallusers` | Retrieve all users  |
| GET         | `/users/{id}`        | Get user by ID      |

### Authentication

| HTTP Method | Endpoint      | Description                        |
| ----------- | ------------- | ---------------------------------- |
| POST        | `/auth/login` | Authenticate user and generate JWT |

### Example Login Request

#### Request (JSON):

```json
{
    "username": "admin",
    "password": "password"
}
```

#### Response:

```json
"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
```

### Accessing Secure Endpoints

Include the JWT token in the **Authorization** header:

```sh
Authorization: Bearer <JWT_TOKEN>
```

## Author

[Pranay Dalvi](https://github.com/Pranaydalvi)

