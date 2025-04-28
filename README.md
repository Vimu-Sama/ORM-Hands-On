This project is more inclined towards understanding the concepts of the ORM in Java, and the nuances it offers.
In this project, I have picked up some good things like->
1)- JPA - Jakarta Persistence APIs, These are the rulebook which are needed to be followed by ORMs, so that we have uniform way of performing operations, which earlier used to differ from tool to tool.
2)- JDBC - Java DataBase Connectivity- These are the APIs, which are used for connectivity with Java if you are not using ORM concepts, but this is very basic form of connecting and it is good if the project is not complex, but if there are many operations happening, then it becomes an issue to maintain it again and again. Thus, not efficient keeping in mind the costs incurred, instead we go for an ORM tool.
3)- Hibernate -  Its an ORM tool, and very reliable one. The Hibernate provides with very easy way of implementing ORM, it has many other featues, but this project utilizes ORM feature.
4)- ORM- Last but not least, ORM refers to Object Relational Mapper, it maps the Object to the Relational Database like MySql and Postgresql, here Postgres has been used, the hibernate configuartion file has been knowingly omitted to prevent privacy issue, as I hope to host it, but if not I will update it here.
Thus, ORM helps us achieve the task in fewer lines compared to the JDBC.

How to make changes to the Database using ORM tool Hibernate?

Basically there are four pillars if you want to start with the task at hand->
1)-  Configuration -> If you check out the main file code, then first thing you will come across is Configuration, this is a class which helps in setting up the configuration for the connectivity, the type of database, the connection url(jdbc needs this as well), the user and the password, and as well as hb2ddl.auto, to define if you want to create a new table(yes we need to tell our data exlusively), using it we add annotated classes, and we load the configuration from the file hibernate.cfg.xml(default)
2)- Session Factory -> Session Factory is an interface, which organises a group of sessions, basically sessions are made in factory. We initialize factory as-> SessionFactory sessionFactory = configuration.buildSessionFactory() .
3)- Session -> Session is also an interface. So basically we need it everytime to make changes to the database, so one session can accomodate many changes. We intialize it as-> Session session = sessionFactory.openSession() .
4)- Transaction-> Every operation done, is termed as transaction, so everytime we want to make changes, we need to intialize a transaction, we do it as-> Transaction transaction = session.beginTransaction() . And we make commits after performing the operation, by transaction.commit() .

Thanks for reading through it all. This readme is as per my understanding. If you feel I am lacking in my explaination, feel free to reach out!
