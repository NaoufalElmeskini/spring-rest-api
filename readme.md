# Spring REST API

A minimal REST API built with Spring Boot 3 and Java 21. Serves as a straightforward reference for REST conventions, request mapping, and project structure in the Spring ecosystem.

---

## Run

**From your IDE**

Run [`SpringRestApiApplication.java`](src/main/java/io/lacrobate/spring_rest_api/SpringRestApiApplication.java) as a standard Java application.

**With Docker Compose** (recommended)
```sh
docker compose up -d
```

**With Docker**
```sh
mvn clean package
docker build -t spring-rest-api .
docker run -p 8080:8080 spring-rest-api
```

Base URL: `http://localhost:8080/rest-api`

---

## API

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users` | List all users |
| GET | `/users/exists/{name}` | Check if a user exists |
| POST | `/users` | Add a new user |

**Examples**
```sh
curl http://localhost:8080/rest-api/users

curl http://localhost:8080/rest-api/users/exists/aicha

curl -X POST http://localhost:8080/rest-api/users \
  -H 'Content-Type: application/json' \
  -d 'alia'
```

---

## Docs

Interactive API explorer (Swagger UI): `http://localhost:8080/rest-api/swagger-ui/index.html`

OpenAPI spec (JSON): `http://localhost:8080/rest-api/v3/api-docs`
