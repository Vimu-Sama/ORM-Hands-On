package org.vimusama;

public class User {
    private String id;
    private String userName;
    private String hashedPassword;
    private String role;
    private Boolean isActive;

    public User(String userName, String hashedPassword, String role, Boolean isActive) {
        this.userName = userName;
        this.hashedPassword = hashedPassword;
        this.role = role;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
