# Complete SOAP Project

This repository contains a complete SOAP setup with both **Java** and **PHP** clients and servers, including **database integration** with MySQL.

---

## Database Setup

```sql
-- Run this in MySQL
CREATE DATABASE soap_db;
USE soap_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50)
);

INSERT INTO users (name, email) VALUES
('Alice', 'alice@example.com'),
('Bob', 'bob@example.com');


Java SOAP Project
Build & Run
cd java-soap
mvn clean package
mvn exec:java -Dexec.mainClass="com.example.soap.Publisher"


Access WSDL: http://localhost:8080/ws/users?wsdl

Test Client

Add a Java SOAP client or use wsimport to generate one.

PHP SOAP Project
Run Server
cd php-soap
php -S localhost:8081 server.php

Run Client
php client.php
