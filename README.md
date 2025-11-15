# Question Quiz Application (Monolithic)
This project is a Spring Boot–based monolithic application for managing quiz questions and creating quizzes dynamically.
It includes complete features for Question Management, Quiz Creation, and Quiz Submission/Result Calculation using a layered architecture:
- **Controller Layer** – REST endpoints
- **Service Layer** – Business logic
- **Repository Layer** – JPA interaction with PostgreSQL
- **Model Layer** – Entities and DTOs

## 📌 Features
### Question Module
- Add, update, and delete questions
- Fetch all questions
- Fetch questions by category (Param/Path)

### Quiz Module
- Create quizzes using random questions from a category
- Fetch quiz questions (without exposing correct answers)
- Submit answers and calculate score

## 🧱 Architecture
All components run inside a single monolithic service, sharing one database.
Controllers → Services → Repositories → PostgreSQL.

This structure makes it easy later to break into separate services like:

- Question Service
- Quiz Service
- Result Service

## 🔗 Microservices Version Available
A complete microservice-based version of this project is also created separately.

**👉 Microservices Repo:**

https://github.com/Hardik-Girdhar/SpringBoot-product-crud-api.git

You can explore that repo to see how the monolithic logic is split into independent microservices.

## 🛠 Tech Stack
- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven
