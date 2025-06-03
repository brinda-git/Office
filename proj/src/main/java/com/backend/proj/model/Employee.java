package com.backend.proj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Column(unique = true)
    private String email;

    private String password;



    private String confirmpassword;

    public Employee(int id, String username, String email, String password, String confirmpassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }


    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }


}

