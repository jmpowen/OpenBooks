package com.example.business.data.entities;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="user_email")
    String user_email;

    @Column(name="username")
    String username;

    @Column(name="user_biography")
    String user_biography;

    /* Required by JPA for building properly */
    public User() {
        super();
    }
    public User(String user_email, String username, String user_biography) {
        this.user_email = user_email;
        this.username = username;
        this.user_biography = user_biography;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_biography() {
        return user_biography;
    }

    public void setUser_biography(String user_biography) {
        this.user_biography = user_biography;
    }
}
