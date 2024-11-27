# QR Generator API

## English Version

## Description

QR Generator API is a project developed with Spring Boot to generate QR codes in various ways. It allows generating QR codes from data stored in a database, user-provided data, or directly from text/URLs. The project also includes detailed documentation generated with Swagger and a Postman collection to facilitate testing.

### Features

- **Generate QR from the database**: Retrieves data by its ID and generates a QR in JSON format.
- **Generate QR from user-provided data**: Allows users to send key-value pairs and generates a QR based on them.
- **Generate QR from text or URL**: Converts text or URL directly into a QR code.
- **Swagger Documentation**: Interactive interface to explore and test the endpoints.
- **Postman Collection**: Includes predefined examples to test the API.

---

### Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/qr-generator.git
   cd qr-generator

2. Configure the `.env` file with your database credentials:

   ```env
   MYSQL_DATABASE=YOUR-DATABASE
   DB_USERNAME=YOUR-USER
   DB_PASSWORD=YOUR-PASSWORD
   DB_URL=YOUR-DATABASE-URL

3. Build and run the project:

   ```bash
   mvn clean install
   mvn spring-boot:run

## Swagger Documentation

This API uses **Swagger** to document and test the endpoints interactively. Although the project is not running, you can explore and understand the API structure with the following resources:

- **Swagger UI (local)**: When the project is running locally, you can access the graphical interface at `http://localhost:8080/swagger-ui.html`.
- **Swagger OpenAPI**: To learn more about how Swagger works, check out the [official Swagger documentation](https://swagger.io/docs/).

---

## Postman Collection

A Postman collection is available to quickly and easily test the endpoints. Download and import it into Postman to get started.

---

## Endpoint Functionality

| **Method** | **Endpoint**       | **Description**                          |
|------------|--------------------|------------------------------------------|
| `GET`      | `/qr/from-db/{id}` | Generates a QR from data stored in the database. |
| `POST`     | `/qr/from-input`   | Generates a QR from user-provided key-value data. |
| `POST`     | `/qr/from-text`    | Generates a QR from user-provided text or URL.    |

---

## Resources

- **[Swagger YAML File](resources/api-docs.yaml)**: OpenAPI document with the API specification.
- **[Postman Collection](resources/qr-generator.postman_collection.json)**: JSON file to import into Postman and test the endpoints.

---

**↓ Español / Spanish Version Below ↓**

---

# QR Generator API

## Versión en Español

## Descripción

QR Generator API es un proyecto desarrollado con Spring Boot para generar códigos QR de diversas maneras. Permite generar códigos QR a partir de datos almacenados en una base de datos, datos proporcionados por el usuario, o texto/URL directamente. El proyecto también incluye documentación detallada generada con Swagger y una colección de Postman para facilitar su prueba.

### Características

- **Generar QR desde la base de datos**: Obtiene datos por su ID y genera un QR en formato JSON.
- **Generar QR desde datos proporcionados**: Permite al usuario enviar pares clave-valor y genera un QR basado en ellos.
- **Generar QR desde texto o URL**: Convierte texto o URL directamente en un código QR.
- **Documentación Swagger**: Interfaz interactiva para explorar y probar los endpoints.
- **Colección de Postman**: Incluye ejemplos predefinidos para probar la API.

---

### Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/qr-generator.git
   cd qr-generator
   
2. Configura el archivo `.env` con tus credenciales de base de datos:

   ```env
   MYSQL_DATABASE=YOUR-DATABASE
   DB_USERNAME=YOUR-USER
   DB_PASSWORD=YOUR-PASSWORD
   DB_URL=YOUR-DATABASE-URL

3. Construye y ejecuta el proyecto:

   ```bash
   mvn clean install
   mvn spring-boot:run


## Documentación Swagger

Esta API utiliza **Swagger** para documentar y probar los endpoints de manera interactiva. Aunque el proyecto no está en ejecución, puedes explorar y entender la estructura de la API con los siguientes recursos:

- **Swagger UI (local)**: Al ejecutar el proyecto localmente, puedes acceder a la interfaz gráfica en `http://localhost:8080/swagger-ui.html`.
- **Swagger OpenAPI**: Si deseas aprender más sobre cómo funciona Swagger, consulta la [documentación oficial de Swagger](https://swagger.io/docs/).

---

## Colección de Postman

Una colección de Postman está disponible para probar los endpoints de manera rápida y sencilla. Descárgala e impórtala en Postman para comenzar.

---

## Funcionalidad de los Endpoints

| **Método** | **Endpoint**       | **Descripción**                                                           |
|------------|--------------------|---------------------------------------------------------------------------|
| `GET`      | `/qr/from-db/{id}` | Genera un QR desde los datos almacenados en la base de datos.             |
| `POST`     | `/qr/from-input`   | Genera un QR desde datos clave-valor proporcionados por el usuario.       |
| `POST`     | `/qr/from-text`    | Genera un QR desde texto o URL proporcionados por el usuario.             |

---

## Recursos

- **[Archivo Swagger YAML](resources/api-docs.yaml)**: Documento OpenAPI con la especificación de la API.
- **[Colección de Postman](resources/qr-generator.postman_collection.json)**: Archivo JSON para importar en Postman y probar los endpoints.
