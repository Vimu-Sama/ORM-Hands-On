# ORM in Java: Learning and Understanding

This project focuses on understanding the concepts of ORM (Object Relational Mapping) in Java and exploring the important aspects it offers.

---

## What I Learned

### 1) JPA (Jakarta Persistence API)
- JPA defines a standard set of rules that ORM tools must follow.
- Before JPA, each ORM tool had different ways of performing database operations, making projects harder to maintain.
- JPA provides a uniform way to interact with databases across different tools.

### 2) JDBC (Java Database Connectivity)
- JDBC is the basic API used to connect Java applications directly to databases.
- It is suitable for small or simple projects.
- For complex projects, JDBC becomes hard to maintain and more error-prone, making ORM tools a better choice.

### 3) Hibernate
- Hibernate is a widely-used, reliable ORM tool.
- It simplifies database interactions significantly.
- In this project, Hibernate is used mainly for its ORM capabilities.

### 4) ORM (Object Relational Mapping)
- ORM is the technique of mapping Java objects to relational database tables.
- In this project, PostgreSQL is used as the relational database.
- ORM reduces boilerplate code and makes data handling more efficient compared to JDBC.

---

## How Changes Are Made to the Database Using Hibernate ORM

When using Hibernate, there are four main components involved:

### 1) Configuration
- Sets up database connection parameters: URL, username, password, and other settings.
- Specifies options like `hibernate.hbm2ddl.auto` to manage the database schema.
- Loads the entity classes annotated with JPA annotations.
- Typically uses a `hibernate.cfg.xml` configuration file.

```java
Configuration configuration = new Configuration();
configuration.configure("hibernate.cfg.xml");
configuration.addAnnotatedClass(User.class);
```

### 2) SessionFactory
- `SessionFactory` is a heavyweight object that manages database connections.
- It is created once and used throughout the application.

```java
SessionFactory sessionFactory = configuration.buildSessionFactory();
```

### 3) Session
- A `Session` represents a single unit of work with the database.
- Used to perform CRUD (Create, Read, Update, Delete) operations.

```java
Session session = sessionFactory.openSession();
```

### 4) Transaction
- Transactions group a set of database operations into a single, atomic action.
- Always start a transaction before modifying data and commit it after the changes.
- Although usually required for create, delete, or update, it is good practice to use transactions for read operations as well.

```java
Transaction transaction = session.beginTransaction();

// Perform database operations

transaction.commit();
```

---

## CRUD Operations

### 1) Create

The create operation can be performed using Hibernate's session by calling `session.persist()`, which stores the data in the database.

```java
session.persist(a1); // a1 is an instance of a class mapped to the database
```

---

### 2) Read

Read operations can use different methods and also involve lazy vs. eager fetching:

```java
// id is the primary key to search, User.class is the entity class
session.find(User.class, id);                // Eager fetching
session.byId(User.class).getReference(id);   // Lazy fetching
session.byId(User.class).load(id);           // Eager fetching
```

- **Lazy fetching**: Data is fetched only when actually accessed.
- **Eager fetching**: Data is fetched immediately when the query is executed.

---

### 3) Update

The update operation is typically performed using `session.merge()`.  
It will update an existing entry if found; otherwise, it may create a new one.

```java
session.merge(a1); // a1 is the instance of the entity class
```

---

### 4) Remove

The remove operation deletes an entry from the database:

```java
session.remove(a1); // a1 is an instance of the entity class
```

**Best practice:**

```java
User user = session.find(User.class, id);
session.remove(user);
```

---

## Final Notes

- ORM tools like Hibernate improve efficiency, maintainability, and safety when interacting with databases.
- This README represents my current understanding of these concepts.
- Feedback and suggestions for improvement are welcome!
