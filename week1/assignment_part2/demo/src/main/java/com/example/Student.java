package com.example;

public class Student extends Person {
    private String major;

    public Student(String name, int yearOfBirth, String major) {
        super(name, yearOfBirth);  // Call the constructor of the superclass (Person)
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return "Student[" + super.toString() + ", major=" + major + "]";
    }
}
