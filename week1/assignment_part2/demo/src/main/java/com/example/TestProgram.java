package com.example;

public class TestProgram {
    public static void main(String[] args) {
        // Create a Person
        Person person = new Person("John Doe", 1980);
        System.out.println(person);

        // Create a Student
        Student student = new Student("Alice Smith", 2000, "Computer Science");
        System.out.println(student);

        // Create an Instructor
        Instructor instructor = new Instructor("Dr. Brown", 1970, 80000);
        System.out.println(instructor);
    }
}
