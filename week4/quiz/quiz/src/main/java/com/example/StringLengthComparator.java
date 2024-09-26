package com.example;

import java.util.ArrayList;
import java.util.Comparator;

public class StringLengthComparator {
    public static void main(String[] args) {
        // Sample ArrayList of strings
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Tom");
        stringList.add("Dick");
        stringList.add("Harry");
        stringList.add("Romeo");
        stringList.add("Juliet");
        stringList.add("William");
        stringList.add("Sarah");
        stringList.add("Dixon");
        stringList.add("Robert");
        stringList.add("Tomaz");

        // Sort by increasing length using a Comparator
        stringList.sort(Comparator.comparingInt(String::length));

        // Print the sorted list
        System.out.println("Sorted by length (increasing):");
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
