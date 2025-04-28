package org.vimusama;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.Scanner ;


public class UserInterface {

    private Configuration configuration ;
    private SessionFactory sessionFactory;
    private Session session ;
    private Scanner scanner ;

    public UserInterface(){
        this.configuration = new Configuration() ;
        this.configuration.addAnnotatedClass(org.vimusama.User.class) ;
        this.configuration.configure() ;
        this.sessionFactory = this.configuration.buildSessionFactory() ;
        this.session = this.sessionFactory.openSession() ;
        this.scanner = new Scanner(System.in) ;
    }

    public void start(){
        System.out.println("WELCOME to USER MANAGEMENT PORTAL") ;
        System.out.println("This portal helps you to do basic CRUDs on your user data, which is locally connected(for now)") ;
        String choice= "" ;
        while(!choice.equals("exit")){
            System.out.println("Enter: \n1- Create New User \n2- Read details of a User \n3- Update User data \n4- Delete a User \nexit- Exit this Window");
            choice = this.scanner.nextLine() ;
            switch(choice){
                case "1": {
                    CreateUser();
                    continue;
                } case "2": {
                    ReadUser();
                    continue;
                } case "3": {
                    UpdateUser();
                    continue ;
                } case "4": {
                    DeleteUser();
                    continue ;
                }
                case "exit": {
                    break ;
                }
                default: {
                    System.out.println("Wrong input! Please try again with instructions given!") ;
                    continue;
                }
            }
        }
        System.out.println("Thank you for trying out USER MANAGEMENT PORTAL") ;
    }

    //I only want the UserInterface class to have access to
    //these CRUD functions, so that they cannot be used anywhere else
    //apart from the User Management Portal

    private void CreateUser(){
        Transaction transaction = this.session.beginTransaction() ;
        User newUser = new User() ;
        System.out.println("Enter the required User Credentials") ;
        System.out.print("UserName: ") ;
        String tempInputString= this.scanner.nextLine() ;
        newUser.setUserName(tempInputString);
        System.out.print("Password: ") ;
        tempInputString = this.scanner.nextLine() ;
        newUser.setHashedPassword(tempInputString) ;
        System.out.print("Role: ") ;
        tempInputString = this.scanner.nextLine() ;
        newUser.setRole(tempInputString);
        newUser.setActive(true);
        Query<Long> query = session.createQuery("select count(u) from User u", Long.class);
        int count = query.getSingleResult().intValue();
        newUser.setId(count+1);
        session.persist(newUser);
        transaction.commit() ;
        System.out.println("The new user has been created!\n") ;
    }

    private void ReadUser(){
        Transaction transaction = session.beginTransaction() ;
        System.out.println("Enter the Id: ") ;
        try{
            int i = Integer.parseInt(scanner.nextLine()) ;
            User fetchedUser = session.find(User.class, i) ;
            System.out.println("User is-> \n" + fetchedUser) ;
            transaction.commit() ;
        }
        catch(Exception e){
            System.out.println("Exception caught-> " + e) ;
        }
        System.out.println("\n\n") ;
    }

    private void UpdateUser(){
        Transaction transaction = session.beginTransaction() ;
        System.out.println("Enter the details you want the required entry to be updated with -->") ;
        System.out.println("Id:  ") ;
        int id= Integer.parseInt(this.scanner.nextLine()) ;
        User fetchedUser= session.find(User.class, id) ;
        Boolean noData= false;
        if(fetchedUser == null){
            fetchedUser= new User() ;
            noData = true;
        }
        System.out.println("Username: ") ;
        String newUsername = this.scanner.nextLine() ;
        System.out.println("hashedPassword: ") ;
        String newPass = this.scanner.nextLine() ;
        System.out.println("Role: ") ;
        String newRole = this.scanner.nextLine();
        if(noData){
            int count = session.createQuery("select count(u) from User u", Long.class).getSingleResult().intValue() ;
            fetchedUser.setId(count+1);
        }
        fetchedUser.setUserName(newUsername);
        fetchedUser.setHashedPassword(newPass);
        fetchedUser.setRole(newRole);
        session.merge(fetchedUser) ;
        transaction.commit();
        System.out.println("The database has been successfully updated\n\n") ;
    }

    private void DeleteUser(){
        System.out.println("Enter the id which you want to be deleted -->") ;
        int id= Integer.parseInt(this.scanner.nextLine()) ;
        Transaction transaction = session.beginTransaction() ;
        User fetchedUser = session.byId(User.class).load(id) ;
        if(fetchedUser == null){
            System.out.println("The given id is not present in the database, no delete operation was performed\n\n") ;
            return ;
        }
        session.remove(fetchedUser);
        transaction.commit() ;
        System.out.println("The entry with the given id has been deleted from the database\n\n") ;
    }

    public void stop(){
        session.close();
        sessionFactory.close();
    }
}
