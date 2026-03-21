# First Job Application

A RESTful API built with Spring Boot for managing job listings.

## Tech Stack

- Java 17
- Spring Boot 4.0.4
- Spring Web MVC
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

## Job Model

```json
{
  "id": 1,
  "title": "Backend Developer",
  "description": "Java Spring Boot developer role",
  "minSalary": "50000",
  "maxSalary": "80000",
  "location": "Remote"
}
```
