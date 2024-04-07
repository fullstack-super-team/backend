# IDATT2105 Fullstack project - Backend

## Table of contents
1. [Introduction](#1-introduction)
2. [Technologies used](#2-technologies-used)
3. [Recommended IDE Setup](#3-recommended-ide-setup)
4. [Project Structure](#4-project-structure)
5. [Documentation](#5-documentation)
    - [Javadoc documentation](#javadoc-documentation)
    - [API documentation with Swagger](#API-documentation-with-Swagger)
   - [Database Documentation](#database-documentation)
6. [Installation](#6-installation)
   - [Install dependencies](#install-dependencies)
   - [Compile and Hot-Reload for Development](#compile-and-hot-reload-for-development)
   - [Compile and Minify for Production](#compile-and-minify-for-production)
7. [Contributors](#7-contributors)



## 1. Introduction

Welcome to Quizzebassen! 
This is the backend for the voluntary fullstack project in the course IDATT2105.
We have developed a web application for playing and creating quizzes. Whether you are here to challenge your intellect,
create challenging quizzes or just have fun with trivia, you have come to the right place!

## 2. Technologies used

* Spring Boot
* Spring Framework
* Spring Security
* JWT
* Java v21
* H2 Database
* JPA
* Maven
* Swagger
* Jacoco

## 3. Recommended IDE Setup

While you can use any IDE you prefer, we recommend using [Intellij IDEA](https://www.jetbrains.com/idea/) by JetBrains.
Intellij comes with support for Spring Boot and Java development.

If you're using Intellij IDEA:
   - Take advantage of the built-in Spring Initializr to create your project.
   - Use embedded database tools to view and manage the H2 database.
   - Use Maven to manage dependencies and build the project.

## 4. Project structure

Here follows a brief overview of the project structure:

- `src/main/java/ntnu/fullstacksuperteam/backend`: Root package containing all the Java classes.
   - `controller`: Classes that handle HTTP requests and responses.
   - `dto`: Data Transfer Objects used for encapsulating request/response data.
   - `model`: Java classes that represent the data structure of the application.
   - `repository`: Interfaces for data access operations using Spring Data JPA.
   - `security`: Configuration classes for Spring Security and JWT handling.
   - `service`: Service classes with business logic.
   - `BackendApplication.java`: The main class that runs the Spring Boot application.
- `src/main/resources`: Configuration files and other non-code resources.
- `src/test`: Contains the tests for the application.
- `pom.xml`: Maven project file with the configuration and dependencies.

## 5. Documentation

### Javadoc documentation

The JavaDoc for our project provides detailed information on the classes, methods, and their functionalities, and it's accessible through the link below:
[Quizzebassen JavaDoc Documentation](https://fullstack-super-team.github.io/backend/apidocs/)


### API Documentation with Swagger

To access our API documentation, you'll need to have the backend up and running. 
Follow the instructions in the 'Setting up backend' section to get started. Once the backend API is operational, you can explore the documentation by clicking on the Swagger link below:

- [Setting up backend](LINK_TO_SETUP_INSTRUCTIONS)
- [Swagger API Documentation](LINK_TO_SWAGGER_UI)

### Database Documentation

The database schema and documentation are crucial for understanding the underlying data model. We maintain a comprehensive domain model, which you can view here:
[Domain Model PDF](URL_TO_YOUR_DOMAIN_MODEL_PDF)

## 6. Installation

To get the backend up and running, you'll need to follow these steps:

### Install dependencies

With Maven wrapped in the project, you don't need to install anything globally.
Run the following command to install the project dependencies:

```sh
./mvnw clean install
```

### Run the application for development

Run the following command to start the application:

```sh
./mvnw spring-boot:run
```

### Testing

To run the tests, use the following command:

```sh
./mvnw test
```

## 7. Contributors

This project was developed by: Birthe Emilie Christiansen, Håkon Rene Billingstad, Lotte Kristine Walla Aune and Vemund Ellingsson Røe.
