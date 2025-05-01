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
- SessionFactory is a heavyweight object that manages database connections.
- It is created once and used throughout the application.

```java
SessionFactory sessionFactory = configuration.buildSessionFactory();
```

### 3) Session
- A Session represents a single unit of work with the database.
- Used to perform CRUD (Create, Read, Update, Delete) operations.

```java
Session session = sessionFactory.openSession();
```

### 4) Transaction
- Transactions group a set of database operations into a single, atomic action.
- Always start a transaction before modifying data and commit it after the changes.
- Usually transaction is required to create, delete or update, but it is a good practise to make it for read operations as well.

```java
Transaction transaction = session.beginTransaction();

// Perform database operations

transaction.commit();
```

## CRUD Operations

### 1) Create
    The create operation can be performed using hibernate's session by using the session.persist(_class_object_), which enables us to store the data in database.
    
    ---java
    session.persist(a1) ; a1 refers to the object of a class which is mapped to the database
    ---

### 2) Read
    The read operation has many methods and also encompasses a logic of lazy fetching and eager fetching, here is some code talking about the same.
    
    ---java
    
    //id is the required id to search for the object and User.class is the reference to the class we need to send data for
    session.find(User.class , id) ;               //this performs eager fetching
    session.byId(User.class).getReference(id) ;  //this performs lazy fetching
    session.byId(User.class).load(id) ;          //this performs eager fetching
    
    ---
    
    - lazy fetching - fetching data not on statement but only when there is a requirement for the data being used after the fetch
    - eager fetching - fetching the data from the start itself without waiting/checking if the data needs to be used or not

### 3) Update
    The update operation can be performed using session.merge(instanceOFClass), the peculiar thing to note about this is that if the object or here we can say that if entry is not present in the database then it     will create a knew entry otherwise will update the old one or already present one.

    ---java
    session.persists(a1) ; //a1 - the instance of the required class made in accordance to the database or vice-versa
    ---

### 4) Remove
    The remove operation removes the required entry from the database table, and cabe performed as follows:

    ---java
    
    session.remove(a1) ; // a1- object from the required class
    
    ---
    
    best way to go about this:
    ---java

    User user= session.find(User.class, id);
    session.remove(user) ;
    
    ---


## Final Notes

- ORM tools like Hibernate improve efficiency, maintainability, and safety when interacting with databases.
- This README represents my current understanding of these concepts.
- Feedback and suggestions for improvement are welcome.
