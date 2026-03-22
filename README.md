# First Job Application

A RESTful API built with Spring Boot for managing job listings, companies, and reviews.

## Tech Stack

- Java 17
- Spring Boot 4.0.4
- Spring Web MVC
- Spring Data JPA
- H2 Database (in-memory)
- Maven

## Getting Started

### Prerequisites

- Java 17+
- Maven

### Run the application

```bash
./mvnw spring-boot:run
```

The server starts at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint      | Description         |
|--------|---------------|---------------------|
| GET    | `/jobs`       | Get all jobs        |
| GET    | `/jobs/{id}`  | Get job by ID       |
| POST   | `/jobs`       | Create a new job    |
| PUT    | `/jobs/{id}`  | Update a job by ID  |
| DELETE | `/jobs/{id}`  | Delete a job by ID  |

### Companies

| Method | Endpoint          | Description              |
|--------|-------------------|--------------------------|
| GET    | `/companies`      | Get all companies        |
| GET    | `/companies/{id}` | Get company by ID        |
| POST   | `/companies`      | Create a new company     |
| PUT    | `/companies/{id}` | Update a company by ID   |
| DELETE | `/companies/{id}` | Delete a company by ID   |

### Reviews

| Method | Endpoint                                        | Description                          |
|--------|-------------------------------------------------|--------------------------------------|
| GET    | `/companies/{companyId}/reviews`                | Get all reviews for a company        |
| POST   | `/companies/{companyId}/reviews`                | Create a review for a company        |
| GET    | `/companies/{companyId}/reviews/{reviewId}`     | Get a specific review                |
| PUT    | `/companies/{companyId}/reviews/{reviewId}`     | Update a review by ID                |

## Models

### Job

```json
{
  "id": 1,
  "title": "Backend Developer",
  "description": "Java Spring Boot developer role",
  "minSalary": "50000",
  "maxSalary": "80000",
  "location": "Remote",
  "company": {
    "id": 1,
    "name": "EnterSlice Private Limited",
    "address": "B-60 NOIDA",
    "description": "X company"
  }
}
```

### Company

```json
{
  "id": 1,
  "name": "EnterSlice Private Limited",
  "address": "B-60 NOIDA",
  "description": "X company"
}
```

### Review

```json
{
  "id": 1,
  "reviewerName": "Test",
  "comment": "Test Review",
  "rating": 2
}
```
