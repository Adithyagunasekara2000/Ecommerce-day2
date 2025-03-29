# Ecommerce-day2
# Spring Boot Student Management API

## Overview
This is a simple Spring Boot REST API that manages student records. It allows adding, updating, deleting, and retrieving student information, including filtering and sorting based on attributes like age and GPA.

## Technologies Used
- Java
- Spring Boot
- RESTful API

## Project Structure
```
/src/main/java/lk/ac/vau/fas/ict/
│── demo/
│   ├── DemoApplication.java
│   ├── StudentController.java
│── model/
│   ├── Student.java
```


## API Endpoints

### Base URL
```
http://localhost:8080/app
```

### Endpoints
| Method | Endpoint                | Description |
|--------|-------------------------|-------------|
| GET    | `/msg`                  | Returns a welcome message |
| GET    | `/name`                 | Returns a name message |
| GET    | `/age/{age}`            | Returns the given age |
| GET    | `/student`              | Returns a single student object |
| GET    | `/students`             | Returns a list of all students |
| GET    | `/student/{id}`         | Retrieves a student by their registration number |
| GET    | `/age-range`            | Retrieves students within the age range of 20-23 |
| GET    | `/sorted-by-gpa`        | Returns students sorted by GPA in descending order |
| GET    | `/`                     | Retrieves all students |
| POST   | `/`                     | Adds a new student |
| PUT    | `/{id}`                 | Updates an existing student by registration number |
| DELETE | `/{id}`                 | Deletes a student by registration number |


### output

![Screenshot 2025-03-29 160011](https://github.com/user-attachments/assets/06e167d4-9c6a-42fb-a37b-1e55416e746f)



![Screenshot 2025-03-29 155920](https://github.com/user-attachments/assets/aecacc2c-966c-4bef-8c1c-35f29a09b661)

