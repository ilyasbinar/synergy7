package org.example;

import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.EmployeeComparatorProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Stream");

        //initiate data department
        Department it = new Department("1", "IT");
        Department finance = new Department("2", "Finance");

        //initiate data employee
        Employee panji = new Employee("1", "Panji", 10000000L, it,
                List.of("08111111111"));
        Employee nugrah = new Employee("2", "Nugrah", 15000000L, it,
                Arrays.asList("08222222222", "0833333333"));
        Employee hamid = new Employee("3", "Hamid", 7000000L, it,
                Arrays.asList("0844444444", "085555555555"));
        Employee jalil = new Employee("4", "Jalil", 8000000L, finance,
                List.of("086666666"));
        Employee nisak = new Employee("5", "Nisak", 20000000L, finance,
                List.of("087777777"));

        List<Employee> itEmployees = Arrays.asList(panji, nugrah, hamid);
        List<Employee> financeEmployees = Arrays.asList(jalil, nisak);

        it.setEmployeeList(itEmployees);
        finance.setEmployeeList(financeEmployees);

        List<Employee> employeeList = Arrays.asList(panji, nugrah, hamid, jalil, nisak);
        List<Department> departmentList = Arrays.asList(it, finance);


        List<String> departementNames = departmentList.stream()
                .map(department -> department.getId()+". "+department.getName()).collect(Collectors.toList());

        List<String> departementNamesToList = departmentList.stream()
                .map(Department::getName).toList();

        departementNames.forEach(System.out::println);
        System.out.println("------------");
        departementNamesToList.forEach(System.out::println);

        System.out.println("===Get Employee Name from List<Departement> filter >5====");
        List<String> employeeNames = departmentList.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .map(Employee::getName)
                .toList().stream()
                    .filter(name -> name.length()>5)
                    .toList();

        employeeNames.forEach(System.out::println);

        System.out.println("===Get Employee's No HP from List<Departement>====");

        List<String> noHpList = departmentList.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .flatMap(employee -> employee.getNoHp().stream())
                .toList();
        noHpList.forEach(System.out::println);

        System.out.println("===Get Employee from List<Departement> filter salary>=10jt====");
        List<Employee> employee10mList = departmentList.stream()
                .flatMap(department -> department.getEmployeeList().stream())
                .filter(employee -> employee.getSalary()>=10000000L)
                .filter(employee -> employee.getDepartment().getName().equals("IT"))
                .toList();

        employee10mList.forEach(employee
                -> System.out.println(employee.getName()+" digaji sebesar "+employee.getSalary()));

        System.out.println("===Get sorted Employee from List<Employee> by name");
        List<Employee> sortedByNameEmployeeList = employeeList.stream()
                .sorted(EmployeeComparatorProvider::compareByName)
                .toList();

        sortedByNameEmployeeList.forEach(employee
                -> System.out.println(employee.getName()));


        System.out.println("===Get sorted Employee from List<Employee> by name asc");
        List<Employee> sortedAscByNameEmployeeList = employeeList.stream()
                .sorted(EmployeeComparatorProvider::compareByName)
                .toList().reversed();

        sortedAscByNameEmployeeList.forEach(employee
                -> System.out.println(employee.getName()));


        System.out.println("===Get sorted Employee from List<Employee> by salary");
        List<Employee> sortedBySalaryEmployeeList = employeeList.stream()
                .sorted(EmployeeComparatorProvider::compareBySalary)
                .toList();

        sortedBySalaryEmployeeList.forEach(employee
                -> System.out.println(employee.getName() +"-"+employee.getSalary()));


        /**
         * 45 data
         * 10,10,10,10,5
         */

        System.out.println("===Limit 3===");
        sortedBySalaryEmployeeList.stream()
                .limit(3)
                .forEach(employee -> System.out.println(employee.getName()));


        System.out.println("===Limit 3 Skip(Page) 2===");
        sortedBySalaryEmployeeList.stream()
                .skip(3)
                .limit(3)
                .forEach(employee -> System.out.println(employee.getName()));

        System.out.println("===All Match===");
        boolean isAll0844444444 = sortedBySalaryEmployeeList.stream()
                .flatMap(employee -> employee.getNoHp().stream())
                .allMatch(noHp -> noHp.equals("0844444444"));
        System.out.println(isAll0844444444);

        System.out.println("===Any Match===");
        boolean isAny0844444444 = sortedBySalaryEmployeeList.stream()
                .flatMap(employee -> employee.getNoHp().stream())
                .anyMatch(noHp -> noHp.equals("0844444444"));
        System.out.println(isAny0844444444);

    }
}