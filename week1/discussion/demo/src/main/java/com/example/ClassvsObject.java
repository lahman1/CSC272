package com.example;

// Main.java
public class ClassvsObject {
    public static void main(String[] args) {
        // Creating objects from the Person class
        Person person1 = new Person("John", 30);
        Person person2 = new Person("Jane", 25);

        // Accessing object properties
        System.out.println(person1.getName() + " is " + person1.getAge() + " years old.");
        System.out.println(person2.getName() + " is " + person2.getAge() + " years old.");

        // Modifying object properties
        person1.setAge(31);
        System.out.println(person1.getName() + " is now " + person1.getAge() + " years old.");
    }
}

// Person.java
class Person {
    // Class attributes
    private String name;
    private int age;

    // Constructor to initialize objects
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter methods to access object properties
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter methods to modify object properties
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
