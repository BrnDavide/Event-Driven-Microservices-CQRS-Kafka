# Event-Driven-Microservices-CQRS-Kafka
Project developed to study Event Driven Microservices + Kafka + CQRS pattern
# 🧩 Microservices Demo

A hands-on project building a **production-like microservices architecture** with Spring Boot, Apache Kafka, Elasticsearch, and more — applying real-world patterns step by step.

---

🎯 Overview

This project covers the full lifecycle of a microservices system: from data ingestion with AI-generated content, through stream processing and search, to security, monitoring, and distributed tracing.

---

🛠️ Tech Stack

| Area | Tools |
|------|-------|
| Language | Java 24 |
| Framework | Spring Boot 4.x, Spring Cloud |
| Messaging | Apache Kafka, Kafka Streams |
| Search | Elasticsearch |
| Database | PostgreSQL |
| Security | Keycloak, OAuth2 / OpenID Connect, JWT |
| Service Discovery | Eureka |
| API Gateway | Spring Cloud Gateway |
| Resilience | Resilience4J (circuit breaker, rate limiting) |
| Caching | Redis |
| Monitoring | Prometheus, Micrometer, Grafana, Spring Boot Actuator |
| Logging & Tracing | ELK Stack, Logstash, Kibana, Zipkin |
| AI | Spring AI, Generative AI (LLMs) |
| Containerization | Docker, Docker Compose |
| Build | Maven |

---

🧱 Microservices

| Service | Description |
|---------|-------------|
| 🤖 **ai-generated-tweet-to-kafka-service** | Generates tweet content via Spring AI and publishes it to a Kafka topic |
| 🔄 **kafka-to-elastic-service** | Consumes from Kafka and indexes documents into Elasticsearch |
| 🔍 **elastic-query-service** | REST API for querying Elasticsearch — implements CQRS query side |
| 🌐 **elastic-query-web-client** | Thymeleaf frontend that calls the query service via Spring WebClient |
| 📊 **kafka-streams-service** | Aggregates the Kafka stream and writes results to a new topic |
| 📈 **analytics-service** | Consumes the aggregated topic and persists data to PostgreSQL |

---

📐 Patterns Implemented

- **Externalized Configuration** — Spring Cloud Config with Git backend and encrypted secrets
- **CQRS** — command side (tweet ingest) separated from query side (Elasticsearch queries)
- **Event Sourcing** — Kafka as the event store
- **Service Discovery** — Eureka server with high-availability setup
- **API Gateway** — Spring Cloud Gateway with load balancing and circuit breaker
- **Log Aggregation** — ELK Stack (Logstash → Elasticsearch → Kibana)
- **Distributed Tracing** — Micrometer + Zipkin

---

🚀 Getting Started

**Prerequisites:** Java 24, Maven, Docker

```bash
# Start infrastructure (Kafka, Elasticsearch, PostgreSQL, Redis, Keycloak...)
docker-compose up -d

# Build all modules
mvn clean install

# Run a specific service
cd microservices-demo/<service-name>
mvn spring-boot:run
```

---

👤 Author

Davide Bruno — built as a learning project for mastering microservices in Java.
