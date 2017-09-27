package com.csye6225.demo.controllers;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class user {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String password;

    private String email;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }


}