# E-Commerce Backend Application

A production-style E-Commerce REST API built using Spring Boot, Spring Data JPA, Hibernate, H2 Database, Docker, and Maven.

The application provides complete CRUD operations for products, user management, shopping cart functionality, and order processing while following a layered architecture (Controller → Service → Repository).

---

## Features

### Product Management

* Create products
* Retrieve products
* Update product information
* Delete products
* Inventory management
* Product categorization

### User Management

* User creation and management
* Address management
* User profile storage

### Shopping Cart

* Add products to cart
* Remove products from cart
* View cart contents
* Quantity management
* Cart total calculation

### Order Management

* Create orders from cart
* Order item tracking
* Order status management
* Order history retrieval

### Monitoring & Observability

* Spring Boot Actuator
* Health checks
* Application information endpoint
* Runtime metrics

### Containerization

* Docker image generation
* Docker Hub integration
* Portable deployment

---

## Tech Stack

| Technology           | Purpose               |
| -------------------- | --------------------- |
| Java 21              | Programming Language  |
| Spring Boot          | Backend Framework     |
| Spring Data JPA      | Data Access Layer     |
| Hibernate            | ORM                   |
| H2 Database          | Development Database  |
| Maven                | Dependency Management |
| Docker               | Containerization      |
| Lombok               | Boilerplate Reduction |
| Spring Boot Actuator | Monitoring            |

---

## Project Architecture

```text
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
Database
```

Project Structure:

```text
src/main/java/com/app/ecom

├── controller
├── service
├── repository
├── model
├── dto
└── EcomApplication
```

---

## REST APIs

### Product APIs

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| POST   | /api/products      | Create Product    |
| GET    | /api/products      | Get All Products  |
| GET    | /api/products/{id} | Get Product By ID |
| PUT    | /api/products/{id} | Update Product    |
| DELETE | /api/products/{id} | Delete Product    |

### Cart APIs

| Method | Endpoint                    | Description         |
| ------ | --------------------------- | ------------------- |
| POST   | /api/cart                   | Add Product To Cart |
| GET    | /api/cart/items             | Get Cart            |
| DELETE | /api/cart/items/{productId} | Remove Product      |

### Order APIs

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| POST   | /api/orders      | Place Order       |
| GET    | /api/orders      | Get Orders        |
| GET    | /api/orders/{id} | Get Order Details |

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/<your-username>/<repository-name>.git
cd ecom-application
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

## H2 Database Console

Access:

```text
http://localhost:8080/h2-console
```

Example Configuration:

```text
JDBC URL : jdbc:h2:mem:test
Username : sa
Password :
```

---

## Actuator Endpoints

```text
/actuator
/actuator/health
/actuator/info
```

---

## Docker

### Build Image

```bash
mvn spring-boot:build-image
```

### Run Container

```bash
docker run -p 8080:8080 ecom-application
```

### Docker Hub Repository

```bash
docker pull surajcodes1410/ecom-application:latest
```

---

## Sample Order Response

```json
{
  "id": 1,
  "totalAmount": 2199.80,
  "status": "CONFIRMED",
  "items": [
    {
      "id": 1,
      "productId": 101,
      "quantity": 2,
      "price": 1099.90,
      "subTotal": 2199.80
    }
  ],
  "createdAt": "2026-06-10T16:26:09.462861"
}
```

---

## Future Improvements

* JWT Authentication
* Spring Security
* Role-Based Access Control
* MySQL/PostgreSQL Integration
* Swagger/OpenAPI Documentation
* Product Reviews & Ratings
* Payment Gateway Integration
* Deployment on AWS/Azure

---

## Author

**Suraj**

Java Backend Developer | Spring Boot Enthusiast

Built as a hands-on project to learn enterprise backend development, REST API design, database integration, and Docker-based deployment.
