# EmployeeManagementSystemUsingSpringBOOTandReact

# Employee Management System

A full-stack Employee Management System built using **Spring Boot** for the backend and **React** for the frontend. This application allows you to **create, read, update, and delete employees** via a REST API with a responsive user interface.

---

## Features

- **Add Employee** – Create new employee records  
- **Get Employee** – Retrieve employee details by ID  
- **Get All Employees** – List all employees  
- **Update Employee** – Modify existing employee details  
- **Delete Employee** – Remove employees from the system  
- **Frontend** – Responsive UI built with React.js  
- **Backend** – RESTful API built with Spring Boot  
- **Cross-Origin Support** – API accessible from any frontend  

---

## Technologies Used

- **Backend:** Java, Spring Boot, Spring Web, Spring Data JPA, Lombok  
- **Frontend:** React, Bootstrap  
- **Database:** PostgreSQL  
- **Version Control:** Git & GitHub  

---

## REST API Endpoints

The backend exposes the following REST endpoints:

| Method | Endpoint                | Description              |
|--------|------------------------|--------------------------|
| POST   | `/api/employees`       | Create a new employee    |
| GET    | `/api/employees/{id}`  | Get employee by ID       |
| GET    | `/api/employees`       | Get all employees        |
| PUT    | `/api/employees/{id}`  | Update employee by ID    |
| DELETE | `/api/employees/{id}`  | Delete employee by ID    |

---

## Sample Request & Response

**POST /api/employees**  

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}

Response:
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}

