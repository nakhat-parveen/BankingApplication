# Banking Application

A backend system that simulates core banking operations, built with Java and Spring Boot. The project is structured as two separate modules: a core banking service for account management, and a payment microservice inspired by UPI/GPay style payment (via mobile numbers) flows.

This project was built independently to deepen my understanding of enterprise banking domain logic, microservice communication, and REST API design.

---

## Features

**BankApplication (Core Banking Service)**
- Create and manage customer accounts
- Deposit, withdraw, and transfer funds between accounts
- View account balance and transaction history
- Input validation and exception handling

**PaymentSystem-gpay-microservice (Payment Service)**
- Initiate payments between accounts via REST
- Simulates UPI style payment (through phone numbers) request and response flow
- Communicates with the core banking service via REST API

---

## Architecture

```
┌─────────────────────────┐        REST        ┌──────────────────────────────┐
│   BankApplication       │ ◄───────────────► │  PaymentSystem Microservice  │
│   (Core Banking API)    │                    │  (GPay style Payments)       │
│   Port: 8080            │                    │  Port: 8081                  │
└─────────────────────────┘                    └──────────────────────────────┘
           │
           ▼
      MySQL Database
```

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL |
| Build Tool | Maven |
| API Style | RESTful |

---

## Getting Started

### Prerequisites

- Java 17+
- MySQL 8+
- Maven 3.8+

### 1. Clone the repository

```bash
git clone https://github.com/nakhat-parveen/BankingApplication.git
cd BankingApplication
```

### 2. Configure the database

Create a MySQL database and update `application.properties` in both modules:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the core banking service

```bash
cd BankApplication
mvn spring-boot:run
```

### 4. Run the payment microservice

```bash
cd PaymentSystem-gpay-microservice
mvn spring-boot:run
```

---

## API Endpoints

### Core Banking Service (`http://localhost:8080`)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/accounts` | Create a new account |
| GET | `/api/accounts/{id}` | Get account details |
| GET | `/api/accounts/{id}/balance` | Get account balance |
| POST | `/api/accounts/{id}/deposit` | Deposit funds |
| POST | `/api/accounts/{id}/withdraw` | Withdraw funds |
| POST | `/api/accounts/transfer` | Transfer between accounts |

### Payment Microservice (`http://localhost:8081`)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/payments/initiate` | Initiate a payment |
| GET | `/api/payments/{id}` | Get payment status |

---

## What I learned building this

- How core banking domain logic maps to object-oriented design
- Inter service REST communication in a microservice setup
- JPA entity relationships and transactional operations
- Input validation and meaningful error handling in Spring Boot

---

## Planned improvements

- [ ] Add Spring Security with JWT authentication
- [ ] Write JUnit 5 + Mockito unit tests
- [ ] Dockerise both services with docker-compose
- [ ] Add Swagger/OpenAPI documentation

---

## Author

**Nakhat Parveen** — Java Software Engineer, Berlin  
[LinkedIn](https://www.linkedin.com/in/nakhat-parveen-915483129) · [GitHub](https://github.com/nakhat-parveen)
