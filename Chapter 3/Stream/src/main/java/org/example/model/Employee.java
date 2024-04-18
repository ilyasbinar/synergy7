package org.example.model;

import java.util.List;

public class Employee {
    private String id;
    private String name;

    private Long salary;

    private Department department;

    private List<String> noHp;

    public Employee(String id, String name, Long salary, Department department, List<String> noHp) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.noHp = noHp;
    }

    public Employee(String id, String name, Long salary, Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public List<String> getNoHp() {
        return noHp;
    }

    public void setNoHp(List<String> noHp) {
        this.noHp = noHp;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
