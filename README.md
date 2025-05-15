# GreatReads Backend

This is the backend for GreatReads — a REST API for storing and managing book data. Built with Spring Boot and deployed on Railway.

---

## 🧠 Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **PostgreSQL** (hosted on Railway)
* **CORS Configuration** for frontend integration
* **Logging** with SLF4J
* **Deployed to Railway** with environment variables

---

## 🧩 Features

* `GET /api/books`: List all books
* `POST /api/books`: Add a new book
* `PUT /api/books/{id}`: Update a book
* `DELETE /api/books/{id}`: Delete a book

Each book includes:

* `title`, `author`, `description`
* `amazonRating`, `genre`, `imageUrl`

---

## ⚙️ Setup Instructions

```bash
git clone https://github.com/your-username/greatreads-backend
cd greatreads-backend
./gradlew build
```

### 📄 Example `application.properties`

```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

Environment variables are set in Railway.

---

## 🧪 Development Notes

* Use pgAdmin or Railway Data tab to view book entries
* `BookController.java` handles all API endpoints
* `Book.java` is the JPA entity mapped to the `books` table
* `BookRepository.java` extends `JpaRepository`
* SQL script available for seeding 100 books

---

## 🛠 CI/CD & Deployment

* Deployed on Railway with GitHub integration
* Logs available in Railway dashboard
* Optional: Add GitHub Actions to run tests or lint on push

---

## 📬 Contact

Made with 💻 by Sam Wolfe
📧 [samgwolfe12@gmail.com](mailto:samgwolfe12@gmail.com)
🔗 [LinkedIn](https://www.linkedin.com/in/sam-wolfe-59465b186/)
