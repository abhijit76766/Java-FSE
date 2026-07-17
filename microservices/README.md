# Microservices Hands-On Solutions

This folder contains Spring Boot 3 / Spring Cloud solutions for the microservices exercises:

- Account and loan microservices with REST endpoints.
- Eureka discovery server and Eureka clients.
- Spring Cloud Gateway with routing, path rewriting, request logging, local rate limiting, load-balanced routes, and fallback routes.
- User/order management microservices with OpenFeign communication and JPA repositories.
- Product/inventory services with Eureka and centralized configuration through Spring Cloud Config Server.
- Customer/billing services for API gateway routing.
- Payment service with Resilience4j circuit breaker and fallback logging.
- OAuth2/OIDC client, OAuth2 resource server, and JWT-secured sample services.

## Build

Maven is required.

```bash
mvn clean package
```

## Suggested Run Order

1. `config-server` - `http://localhost:8888`
2. `eureka-discovery-server` - `http://localhost:8761`
3. Business services: `account-service`, `loan-service`, `greet-service`, `customer-service`, `billing-service`, `user-service`, `order-service`, `product-service`, `inventory-service`
4. `api-gateway` - `http://localhost:9090`

## Key Endpoints

- `GET http://localhost:8080/accounts/00987987973432`
- `GET http://localhost:8081/loans/H00987987972342`
- `GET http://localhost:8085/greet`
- `GET http://localhost:9090/greet-service/greet`
- `GET http://localhost:9090/account-service/accounts/00987987973432`
- `GET http://localhost:9090/loan-service/loans/H00987987972342`
- `GET http://localhost:8087/orders`
- `POST http://localhost:8093/payments/PAY-100/authorize`
- `POST http://localhost:8096/auth/token?username=abhijit`
- `GET http://localhost:8096/secure` with header `Authorization: Bearer <token>`
