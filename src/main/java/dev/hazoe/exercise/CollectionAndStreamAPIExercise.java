package dev.hazoe.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionAndStreamAPIExercise {

    public static void main() {

        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 2000),
                new Employee("Bob", "Engineering", 3000),
                new Employee("Carol", "Marketing", 1500),
                new Employee("Dave", "Marketing", 2500),
                new Employee("Eve", "Engineering", 4000)
        );

        employees
                .stream()
                .filter(employee -> employee.getSalary() > 2000)
                .collect(Collectors.groupingBy(Employee::getDepartment
                        , Collectors.averagingDouble(Employee::getSalary)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue()));


    }

}

class Employee {
    String name;
    String department;
    double salary;
    // constructor, getters

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}