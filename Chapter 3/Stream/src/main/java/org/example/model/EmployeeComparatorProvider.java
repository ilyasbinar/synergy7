package org.example.model;

public class EmployeeComparatorProvider {
    public static int compareByName(Employee e1, Employee e2){
        return e1.getName().compareTo(e2.getName());
    }

    public static int compareBySalary(Employee e1, Employee e2){
        return e1.getSalary().compareTo(e2.getSalary());
    }
}
