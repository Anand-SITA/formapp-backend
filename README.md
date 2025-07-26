# Form Submission API - Spring Boot + MySQL

This project is a simple backend REST API for submitting form data using Spring Boot and MySQL. It supports form submissions with fields like title, first name, last name, phone number, and email, with validations and uniqueness constraints.

---

## 📁 Features

- 📤 Submit form data via POST request
- 🧪 Validates phone number and email formats
- 🛑 Rejects duplicate phone numbers and emails
- 📦 Stores submissions in MySQL database
- ✅ API tested via Postman

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Postman (for API testing)

---

## 📂 Project Structure

formapp/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/com/example/formapp/
│   │   │   ├── FormAppApplication.java
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       └── application.properties



---

## ⚙️ Setup Instructions

### 1. 🧰 Prerequisites

- Java 17+ installed
- Maven installed (`mvn -v`)
- MySQL installed and running
- Postman (optional for testing)

---

### 2. 🛠️ Create MySQL Database

Open MySQL terminal or CMD:

```sql
CREATE DATABASE formdb;
```
# 3. 📄 Configure application.properties
Inside src/main/resources/application.properties, update the following:

spring.datasource.url=jdbc:mysql://localhost:3306/formdb
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update

# 4. 🚀 Run the Application
mvn spring-boot:run
The app will start at: http://localhost:8080

#🔌 API Usage
🔸 POST /api/form
Submit a form.

Request URL:
http://localhost:8080/api/form

Method: POST
Body Type: raw → JSON
{
  "title": "Dr.",
  "firstName": "Ankit",
  "lastName": "Sharma",
  "phoneNumber": "9876543210",
  "email": "ankit@example.com"
}

# Response:

201 Created: Form submitted successfully
400 Bad Request: Duplicate phone/email or invalid input
