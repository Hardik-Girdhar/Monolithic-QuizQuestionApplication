# 📘 Monolithic-Based Quiz Application
This project is a **Spring Boot–based monolithic application** for managing quiz questions and creating quizzes dynamically.
It includes complete features for **Question Management, Quiz Creation**, and **Quiz Submission/Result Calculation** using a layered architecture:
- **Controller Layer** – REST endpoints
- **Service Layer** – Business logic
- **Repository Layer** – JPA interaction with PostgreSQL
- **Model Layer** – Entities and DTOs


## 📌 Features
#### Question Module
- Add, update, and delete questions
- Fetch all questions
- Fetch questions by category (Param/Path)

#### Quiz Module
- Create quizzes using random questions from a category
- Fetch quiz questions (without exposing correct answers)
- Submit answers and calculate score


## 🧱 Architecture
All components run inside a **single monolithic service**, sharing one database.
Controllers → Services → Repositories → PostgreSQL.

This structure makes it easy later to break into separate services like:

- Question Service
- Quiz Service
- Result Service


## ▶ Running the Project

1) Configure PostgreSQL in application.properties
2) Run the Spring Boot application
3) Access endpoints using Postman or browser
  - Example:
    - http://localhost:8080/question/getQuestions


## 🔗 API Overview

| Module   | Method | Endpoint | Description |
|----------|--------|----------|-------------|
| Question | GET    | `/question/getQuestions`            | Fetch all questions |
| Question | GET    | `/question/getQuestions/{category}` | Fetch questions by category |
| Question | POST   | `/question/addQuestion`             | Add a new question |
| Question | PUT    | `/question/updateQuestion/{id}`     | Update a question by ID |
| Question | DELETE | `/question/deleteQuestion/{id}`     | Delete question |
| Quiz     | POST   | `/quiz/createQuiz`                  | Create quiz |
| Quiz     | GET    | `/quiz/getQuizById/{id}`            | Get quiz questions |
| Quiz     | POST   | `/quiz/submit/{id}`                 | Submit responses & get score |



## 🔗 Microservices Version Available
A complete **microservice-based version** of this project is also created separately.

**👉 Microservices Repo:**

https://github.com/Hardik-Girdhar/Microservice-QuizQuestionApplication.git

You can explore that repo to see how the monolithic logic is split into independent microservices.


## 🛠 Tech Stack
- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
