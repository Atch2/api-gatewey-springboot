# Práctica de microservicios con Spring Boot

Este repositorio contiene una práctica de arquitectura de microservicios desarrollada con Spring Boot y Spring Cloud. La solución está compuesta por cuatro módulos independientes que trabajan juntos para resolver un escenario básico de catálogo de productos y categorías.

## ¿En qué consiste la práctica?

La idea principal es demostrar cómo se comunican varios servicios dentro de una arquitectura distribuida usando:

- **Eureka Server** para el registro y descubrimiento de servicios.
- **API Gateway** como punto de entrada único para el sistema.
- **Microservicio de categorías** para gestionar categorías.
- **Microservicio de productos** para gestionar productos.

Cada microservicio se registra en Eureka y expone sus propios endpoints REST. El Gateway recibe las peticiones y las redirige al servicio correspondiente usando balanceo basado en nombres de servicio.

## Estructura del proyecto

- `eurekaserver`: servidor de descubrimiento.
- `apigateway`: puerta de entrada a los microservicios.
- `categorias`: servicio REST para categorías.
- `productos`: servicio REST para productos.

## Tecnologías utilizadas

- Java 25
- Spring Boot 3.5.14
- Spring Cloud 2025.0.2
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- Spring Data JPA
- Spring Validation
- H2 y PostgreSQL como dependencias de base de datos

## Configuración general

- El servidor Eureka corre en el puerto **8761**.
- El API Gateway corre en el puerto **8080**.
- Los microservicios de categorías y productos usan **puerto dinámico** (`server.port=0`) y se registran en Eureka con un identificador único.

## Endpoints principales

### Categorías

- `GET /api/categorias`
- `GET /api/categorias/{id}`
- `POST /api/categorias`

### Productos

- `GET /api/productos`
- `GET /api/productos/{id}`
- `POST /api/productos`

## Rutas del API Gateway

El gateway expone las rutas siguientes y las redirige a los microservicios registrados en Eureka:

- `/api/categorias/**` -> servicio `CATEGORIAS`
- `/api/productos/**` -> servicio `PRODUCTOS`

## Cómo ejecutar la práctica

1. Levantar primero el servidor Eureka.
2. Levantar después los microservicios `categorias` y `productos`.
3. Finalmente levantar `apigateway`.

Cada módulo se puede ejecutar desde su carpeta con Gradle:

```bash
./gradlew bootRun
```

En Windows también puedes usar:

```bash
gradlew.bat bootRun
```

## Flujo de funcionamiento

1. Eureka mantiene el registro de los servicios activos.
2. Los microservicios se registran automáticamente al iniciar.
3. El Gateway consulta Eureka para localizar cada servicio por nombre.
4. Las peticiones llegan al Gateway y este las enruta al microservicio correcto.

## Objetivo de aprendizaje

Esta práctica sirve para reforzar conceptos clave de microservicios, como registro de servicios, descubrimiento dinámico, enrutamiento centralizado y separación de responsabilidades entre componentes.