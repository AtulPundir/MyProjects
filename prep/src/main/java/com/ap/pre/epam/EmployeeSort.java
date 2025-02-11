package com.ap.pre.epam;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String city;

    // Constructor
    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    // Getters
    public String getName() {
        return name;
    }

    // toString() for easy printing
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', city='" + city + "'}";
    }
}

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Alice", "New York"),
                new Employee(2, "Charlie", "Los Angeles"),
                new Employee(3, "Bob", "Chicago"),
                new Employee(4, "David", "Houston")
        );

        // Sort employees in reverse alphabetical order by name
        List<Employee> sortedEmployees = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getName).reversed()) // Reverse order
                .collect(Collectors.toList());

        // Print sorted employees
        sortedEmployees.forEach(System.out::println);

    }
}



/*
Q1) Get the Noida city employees from EmployeeList and sort the Noida city employees in the reverse alphabetically order by name of the employee using Java 8

Employee{
id,
name,
city;}
 */