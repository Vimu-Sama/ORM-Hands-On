package org.vimusama;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"Users\"")
public class User {
    @Id
    private int id;

    @Column(name = "\"userName\"")
    private String userName;
    @Column(name = "\"hashedPassword\"")
    private String hashedPassword;
    private String role;
    @Column(name = "\"isActive\"")
    private Boolean isActive;

    public User(){
        //for hibernate
        this.role = "User" ;
        this.isActive = true;
    }
    public User(int id, String userName, String hashedPassword, String role, Boolean isActive) {
        this.id= id ;
        this.userName = userName;
        this.hashedPassword = hashedPassword;
        this.role = role;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString(){
        return ("UserId: " + this.id + "\nUsername: " + this.userName + "\nRole: " + this.role + "\nUserActive: " + this.isActive) ;
    }
}
