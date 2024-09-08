package com.example;

public class Instructor extends Person {
    private double salary;

    public Instructor(String name, int yearOfBirth, double salary) {
        super(name, yearOfBirth);  // Call the constructor of the superclass (Person)
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Instructor[" + super.toString() + ", salary=" + salary + "]";
    }
}
