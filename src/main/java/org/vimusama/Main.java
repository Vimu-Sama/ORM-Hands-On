package org.vimusama;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User newUser = new User(103,"vimusamaTrial",
                "aPassword",
                "normalUser",
                true);
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(org.vimusama.User.class) ;
        configuration.configure();
        try{
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            Transaction createTransaction = session.beginTransaction() ;
            session.persist(newUser);
//            createTransaction.commit() ;
//            Transaction getTransaction = session.beginTransaction() ;
            User temp = session.find(User.class, 6) ;
//            getTransaction.commit();
//            Transaction deleteTransaction = session.beginTransaction() ;
            session.remove(temp) ;
//            deleteTransaction.commit();
            User updatedUser = new User(102,"vimusamaUpdated",
                    "aPassword",
                    "normalUser",
                    true);
//            Transaction updateTransaction = session.beginTransaction();
            session.merge(updatedUser) ;
//            updateTransaction.commit() ;

            createTransaction.commit() ;
        }
        catch(Exception e){
            System.out.println("An error occured-> " + e) ;
        }
    }
}