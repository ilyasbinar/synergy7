package com.example.employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
 
    @Column(name = "name")
    private String name;
 
    @Column(name = "email")
    private String email;
 
    @Column(name = "age")
    private String age;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getAge() {
        return age;
    }
 
    public void setAge(String age) {
        this.age = age;
    }
}