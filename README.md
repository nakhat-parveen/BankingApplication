# Banking Application — Microservices System

A microservices based banking system built with Spring Boot and Spring Cloud. Two independently deployable services handle different payment flows, with **Feign Client** for inter-service communication, **Eureka** for service discovery, and an **API Gateway** as the single entry point for all clients.

Supports two distinct fund transfer flows: direct account to account transfers handled entirely by the core banking service, and UPI/GPay style phone number based payments routed through a dedicated payment microservice which delegates the actual transaction to the core banking service via Feign.

---

## Architecture

```
                         ┌──────────────────────────┐
              Client ───►│       API Gateway        │  Port 8080
                         │   Spring Cloud Gateway   │
                         └────────────┬─────────────┘
                                      │ routes via Eureka
                    ┌─────────────────┴──────────────────┐
                    │                                     │
       ┌────────────▼──────────────┐      ┌──────────────▼───────────────────┐
       │      BankApplication      │      │   PaymentSystem (GPay Service)   │
       │   (Core Banking Service)  │      │                                  │
       │        Port 8089          │      │   POST /gpay/transaction/        │
       │                           │◄─────┤        via/gpay                  │
       │  POST /Registration/**    │      │   GET  /gpay/latest-transactions │
       │  POST /transaction/       │      │   GET  /gpay/transaction-details │
       │    via/account-numbers    │      │                                  │
       │  POST /transaction/       │      │   (calls BankApplication via     │
       │    via/                   │      │     Feign to process payment)    │
       │    phone-numbers          │      │        Port 8010                 │
       └───────────────────────────┘      └──────────────────────────────────┘
                    │
             MySQL Database

                         ┌──────────────────────────┐
                         │      Eureka Server        │  Port 8761
                         │    Service Registry       │
                         │  (all services register)  │
                         └──────────────────────────┘
```

---

## Payment Flows

### Flow 1 — Transfer via account numbers
Direct transfer. BankApplication handles everything itself.

```
Client
  └─► API Gateway :8080
        └─► BankApplication :8089  POST /transaction/via/account-numbers
              └─► validates accounts, debits sender, credits receiver
                    └─► TransactionResponseDto returned to client
```

### Flow 2 — Transfer via phone numbers (GPay style)
Phone number based UPI style transfer. PaymentSystem acts as the entry point and delegates the actual fund movement to BankApplication via Feign Client.

```
Client
  └─► API Gateway :8080
        └─► PaymentSystem :8010  POST /gpay/transaction/via/gpay
              └─► Feign Client ──► BankApplication :8089
                                     POST /bankapi/transaction/via/phone-numbers
                                           └─► resolves phone to account,
                                               processes transfer
                                                 └─► TransactionResponseDto
                                                       returned up the chain
```

---

## Services

### 1. BankApplication (Core Banking Service) — Port 8089

The source of truth for all account data and money movement. Handles both direct account transfers and acts as the downstream processor for phone-based payments coming from PaymentSystem.

#### Customer Controller — `/Registration`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/Registration/...` | Register a new customer and create a bank account |

#### Transaction Controller — `/transaction` and `/bankapi/transaction`

| Method | Endpoint | Description | Called by |
|---|---|---|---|
| POST | `/transaction/via/account-numbers`         | Transfer funds using account numbers | Client via Gateway |
| POST | `/bankapi/transaction/via/phone-numbers`   | Transfer funds using phone numbers | PaymentSystem via Feign |

---

### 2. PaymentSystem-gpay-microservice (GPay Payment Service) — Port 8010

Handles UPI/GPay style phone number based payments. Acts as the entry point for phone transfers and delegates the actual fund movement to BankApplication via Feign Client.

#### GPay Controller — `/gpay`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/gpay/transaction/via/gpay` | Initiate a phone number based payment (calls BankApplication internally) |
| GET | `/gpay/latest-transactions` | Get the most recent GPay transactions |
| GET | `/gpay/transaction-details?phoneNo={phone}` | Get all transactions for a specific phone number |

#### Feign Client (internal)

PaymentSystem uses a Feign Client to call BankApplication for the actual fund transfer:

```java
@FeignClient(name = "BANK-SERVICE", path = "/bankapi/transaction")
public interface BankFeign {
    @PostMapping("/via/phone-numbers")
    TransactionResponseDto fundTransferThroughPhoneNos(@RequestBody TransactionDto dto);
}
```

---

### 3. Eureka Server — Port 8761

Service registry. All services register on startup and discover each other by name (no hardcoded URLs between services).

Dashboard available at: `http://localhost:8761`

---

### 4. API Gateway — Port 8080

Single entry point for all client requests. Routes `/Registration/**` and `/transaction/**` to BankApplication, and `/gpay/**` to PaymentSystem.

---

## Tech Stack

| Component | Technology |
|---|---|
| Language | Java  |
| Framework | Spring Boot |
| Service Discovery | Spring Cloud Netflix Eureka |
| API Gateway | Spring Cloud Gateway |
| Inter-service Communication | OpenFeign (Feign Client) |
| Persistence | Spring Data JPA, Hibernate |
| Database | MySQL |
| Build Tool | Maven |

---

## Getting Started

### Prerequisites

- Java 8+
- MySQL 8+
- Maven 3.8+

### Start services in this order

```bash
# 1. Eureka Server: must be first
cd eureka-server && mvn spring-boot:run

# 2. BankApplication: must be up before PaymentSystem makes Feign calls
cd BankApplication && mvn spring-boot:run

# 3. PaymentSystem
cd PaymentSystem-gpay-microservice && mvn spring-boot:run

# 4. API Gateway : last
cd api-gateway && mvn spring-boot:run
```

### Configure MySQL

Update `application.properties` in BankApplication:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## Planned improvements

- [ ] Add Spring Security with JWT authentication
- [ ] Write JUnit 5 + Mockito unit tests
- [ ] Dockerise all services with docker-compose
- [ ] Add Swagger/OpenAPI documentation

---

## Author

**Nakhat Parveen** — Java Software Engineer, Berlin
[LinkedIn](https://www.linkedin.com/in/nakhat-parveen-915483129) · [GitHub](https://github.com/nakhat-parveen)
