package org.vimusama;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User newUser = new User("vimusama",
                "aPassword",
                "normalUser",
                true);
        Configuration configuration = new Configuration();
        configuration.configure();
        try{
            SessionFactory factory = configuration.buildSessionFactory();
            Session session = factory.openSession();
            session.persist(newUser);
        }
        catch(Exception e){
            System.out.println("An error occured-> " + e) ;
        }
    }
}