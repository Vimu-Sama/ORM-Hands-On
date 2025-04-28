# 📚 ORM in Java: Learning and Understanding

This project is focused on understanding the **concepts of ORM (Object Relational Mapping)** in Java, and exploring the nuances it offers.

---

## 📖 What I Learned

### 1) **JPA (Jakarta Persistence API)**
- JPA is the *rulebook* that ORM tools must follow.
- Before JPA, every ORM tool worked differently, making projects harder to maintain.
- JPA provides a **uniform way** of performing database operations.

### 2) **JDBC (Java Database Connectivity)**
- JDBC is the *basic* way to connect Java applications to databases.
- It works well for **small/simple projects**.
- However, for complex projects, maintaining JDBC code becomes **difficult and costly**.
- That's why we prefer **ORM tools** in large applications.

### 3) **Hibernate**
- Hibernate is a popular and **reliable ORM tool**.
- It simplifies database interactions greatly.
- Although Hibernate has many features, **this project mainly uses its ORM capabilities**.

### 4) **ORM (Object Relational Mapping)**
- ORM refers to mapping Java Objects to **Relational Databases** (like MySQL, PostgreSQL).
- In this project, **PostgreSQL** has been used.
- ORM helps in achieving tasks **with fewer lines of code** compared to JDBC.

---

## 🔧 How Changes Are Made to the Database (Using Hibernate ORM)

When using Hibernate, there are **four key steps**:

### ➡️ 1) Configuration
- Set up the database connection: type, URL, username, password, etc.
- Define `hibernate.hbm2ddl.auto` to specify whether to create/update the database schema.
- Add the annotated entity classes.
- Typically, configuration is loaded from a `hibernate.cfg.xml` file (default).

```java
Configuration configuration = new Configuration();
configuration.configure("hibernate.cfg.xml");
configuration.addAnnotatedClass(User.class);
