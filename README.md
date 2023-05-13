# Employee Management System  

## Tech Stack
Java, Spring / Spring Boot, JPA, Hibernate, MySQL, Spring Security, JWT, Maven, JUnit.

---

### Endpoints

* ```GET /users/token```
### Required request body
```
{
    "username":"test",
    "password":"PWD"
}
```
  Generates a bearer token with **Username** = "test" and **Password** = "PWD" for authentication.

**APIs that require authentication:**

* ```GET /employees/{id}```   
  Returns a specific employee by id.


* ```PUT /employees/{id}```   
  Updates an existing employee by id.


* ```DELETE /employees/{id}```    
  Deletes an employee by id.

**APIs that does not require authentication:**

* ```GET /employees```    
  Returns a list of all employees.


* ```POST /employees```    
  Creates a new employee.

---

## Postman Collection
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/1c0b0b0b6b0b0b0b0b0b)
https://schema.postman.com/json/collection/v2.1.0/collection.json
---

## How to run?

### Install JDK 11

### Clone the repository

```
git clone <repository URL>
```

### Build the application

```
./mvnw.cmd clean install
```
This will build the application and generate a .jar file in the target directory.

### Configure application.properties
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true

```

### Run the application

```
java -jar target/<application-name>.jar
```
Replace <application-name> with the name of the .jar file that was generated.

### Access the application
```
Once the application is running, you can access it by navigating to http://localhost:8080
```
