# Fluo API 💰

**Fluo API** is a robust, production-ready personal finance backend application designed to help users track their income, expenses, and overall financial health. Built using **Java 21** and **Spring Boot 3**, the project follows industry-standard best practices, making it an excellent demonstration of clean code, automated testing, and scalable architecture.

---

## 🚀 Project Overview

Managing personal finances effectively requires clear visibility into earnings and spending. This API provides the backend infrastructure to:
* **Track Transactions**: Register, list, update, and delete income and expense items.
* **Categorize Expenses**: Map transactions to distinct categories (e.g., *Food, Transport, Salary, Leisure*) for better insights.
* **Calculate Net Balance**: Automatically compute current financial status (Total Income - Total Expenses).
* **Filter Data**: Quickly search transactions by category, month, and year.

This project is built using a progressive roadmap, starting from a solid MVP (Minimum Viable Product) and evolving towards containerized microservices, high-coverage testing, and secure, stateless authentication.

---

## 🛠️ Technologies

* **Language**: Java 21
* **Framework**: Spring Boot 4.1.0 (Spring Web, Spring Data JPA, Spring Boot Actuator)
* **Database**: 
  * H2 Database (In-Memory for rapid testing/development)
  * PostgreSQL (For robust production persistence)
* **API Documentation**: Springdoc OpenAPI (Swagger UI v2.6.0)
* **Database Migrations**: Flyway (to version control database schemas)
* **Security**: Spring Security & JSON Web Tokens (JWT) for stateless authentication
* **Testing**: JUnit 5, Mockito, and MockMVC
* **Containerization**: Docker & Docker Compose

---

## 📐 Architecture

The application is built around a **layered architecture** to enforce a strict separation of concerns:

1. **Controller Layer (`@RestController`)**: Exposes RESTful endpoints, manages HTTP responses (`ResponseEntity`), and handles request validation.
2. **Service Layer (`@Service`)**: Encapsulates core business logic, transaction boundaries, and orchestrates data mapping.
3. **Repository Layer (`@Repository`)**: Communicates with the persistence layer using Spring Data JPA.

### Key Practices:
* **DTO Pattern**: `@Entity` structures are never exposed directly to the REST Controllers. Request and Response Data Transfer Objects (DTOs) are mapped in the service layer to prevent tight coupling.
* **Global Exception Handling**: Standardized error response objects are returned gracefully using `@ControllerAdvice` and `@ExceptionHandler`.
* **Conventional Commits**: Commit messages follow semantic conventions (e.g., `feat:`, `fix:`, `test:`, `docs:`) to maintain a clean git history.

---

## 🗺️ Roadmap & Current Progress

To showcase step-by-step professional growth, the project is structured in five progressive phases:

### 🟩 Phase 1: Setup & Initial Structure (Current Phase 🚀)
* [x] Set up project metadata and Maven dependencies (Spring Boot, Lombok, Springdoc).
* [x] Create core package structure (`controller`, `service`, `repository`, `model`).
* [x] Implement initial health check endpoint (`GET /api/v1/health-check`) to verify configuration.

### ⬜ Phase 2: REST API & Data Persistence
* [ ] Configure H2/PostgreSQL database profiles.
* [ ] Define JPA Entities (`User`, `Category`, `Transaction`) and their relationships (`@ManyToOne`, `@OneToMany`).
* [ ] Set up database version control using Flyway.
* [ ] Implement full CRUD operations for Transactions and Categories with global error handling.

### ⬜ Phase 3: Authentication & Security
* [ ] Implement Spring Security for basic authentication.
* [ ] Integrate stateless JWT (JSON Web Tokens) authentication.
* [ ] Enforce user isolation (Users should only read/modify their own financial data).

### ⬜ Phase 4: Automated Testing
* [ ] Write unit tests for the service layer using JUnit 5 and Mockito.
* [ ] Develop integration tests for controllers using MockMVC.
* [ ] Add automated testing pipelines.

### ⬜ Phase 5: Advanced Features, Containerization & CI/CD
* [ ] Create `@Scheduled` tasks to compile and email monthly financial summaries.
* [ ] Implement Spring `@Cacheable` for slow-moving data (like static category lists).
* [ ] Build a `Dockerfile` and a `docker-compose.yml` file to spin up the API and PostgreSQL in one click.
* [ ] Set up a GitHub Actions workflow to run the test suite on every commit or PR.
* [ ] Configure Spring Boot Actuator for health monitoring.

---

## ⚙️ Getting Started

### Prerequisites
* **Java Development Kit (JDK) 21**
* **Apache Maven 3.9+** (or use the included wrapper `./mvnw`)

### Running the Application Locally

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/fluo-api.git
   cd fluo-api
   ```

2. **Build the project**:
   ```bash
   ./mvnw clean install
   ```

3. **Start the server**:
   ```bash
   ./mvnw spring-boot:run
   ```

The server will start on port **`8080`**. You can verify it is running by calling the health endpoint:
```bash
curl http://localhost:8080/api/v1/health-check
```

---

## 📄 License

This project is **proprietary**. All rights reserved to the author.

You are welcome to view, download, clone, and run this application locally for **educational review, personal testing, or portfolio evaluation purposes**.

Commercial use, unauthorized distribution, or re-publishing of this source code (in whole or in part) is strictly prohibited.
