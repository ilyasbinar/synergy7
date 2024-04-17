package org.example.model;

public class Employee {
    private String id;

    private String name;
    private Long salary;

    public Employee(String id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //tidak umum digunakan di real project
    public String toString(){
        return id+". "+name+" | "+salary;
    }

    public String getNameAndSalary(){
        return name+" | "+salary;
    }
}
