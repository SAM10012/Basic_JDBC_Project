# 💾 LearnJDBC – JDBC Operations with MySQL (Java Console Project)

A beginner-to-intermediate level Java console project demonstrating how to interact with a **MySQL** database using **JDBC (Java Database Connectivity)**. This project includes full CRUD support, batch inserts, and a simulated **bank transaction system** with transaction handling and balance validation.

---

## 🚀 Features

- ✅ **JDBC Setup** with MySQL connector
- ✅ Perform **CRUD operations** on a `students` table
- ✅ Use of **Statements** and **PreparedStatements**
- ✅ **Batch Processing** (both Statement and PreparedStatement)
- ✅ **Transaction Handling** with `commit()` and `rollback()`
- ✅ **Bank Transfer Simulation** between two accounts
- ✅ **Balance Check Logic** with query-based validation
- ✅ Modular, well-commented Java code
- 🔐 No hardcoded passwords (placeholders used)

---

## 📁 Structure

- `LearnJDBC.java` – Contains:
  - Database connection setup
  - CRUD logic (create, read, update, delete)
  - Batch insert using loop
  - Transfer between accounts with balance check
  - Transaction commit/rollback logic
  - Commented-out sections for clarity and reuse

---

## 🧠 Concepts Demonstrated

- JDBC Boilerplate (Driver, URL, username/password)
- SQL Queries with Java
- Statement vs PreparedStatement
- Parameter binding
- Using ResultSet to read query results
- Batch inserts
- ACID properties in transaction handling

---

## 🛠 Technologies Used

| Tool      | Purpose                      |
|-----------|------------------------------|
| Java      | Core application logic       |
| JDBC      | Database communication       |
| MySQL     | Backend database             |
| IntelliJ / Eclipse | IDE support          |

---

## ⚙️ Database Setup

Create a MySQL database named `Bank` with the following tables:

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    marks DOUBLE
);

CREATE TABLE customers (
    acc_no INT PRIMARY KEY,
    name VARCHAR(50),
    balance DOUBLE
);

🔐 Important: Update your actual DB credentials in the code before running locally. The password field uses "YOUR_DB_PASSWORD" as a placeholder and is safe for public repositories.

📌 Disclaimer
This project is for educational purposes only. No real banking logic or security features are implemented beyond JDBC concepts.

📚 Author
Made with ❤️ by Samadrita Paul as part of Java project learning.

📎 License
This project is open-source under the MIT License.
