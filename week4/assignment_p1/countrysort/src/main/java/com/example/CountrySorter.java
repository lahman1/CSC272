package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Class representing a Country
class Country {
    private String name;
    private double area;  // in square kilometers

    // Constructor
    public Country(String name, double area) {
        this.name = name;
        this.area = area;
    }

    // Accessor for name
    public String getName() {
        return name;
    }

    // Accessor for area
    public double getArea() {
        return area;
    }

    // toString method to display country name and area
    @Override
    public String toString() {
        return String.format("%s (%,.0f km²)", name, area);
    }
}

public class CountrySorter {
    public static void main(String[] args) {
        // Create an ArrayList of the 12 largest countries by area
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Russia", 17098242));
        countries.add(new Country("Canada", 9984670));
        countries.add(new Country("China", 9596961));
        countries.add(new Country("United States", 9372610));
        countries.add(new Country("Brazil", 8515767));
        countries.add(new Country("Australia", 7741220));
        countries.add(new Country("India", 3287263));
        countries.add(new Country("Argentina", 2780400));
        countries.add(new Country("Kazakhstan", 2724900));
        countries.add(new Country("Algeria", 2381741));
        countries.add(new Country("Congo", 2344858));
        countries.add(new Country("Greenland", 2166086));

        // Shuffle the countries to create a random order
        Collections.shuffle(countries);

        // Display countries before sorting
        System.out.println("Countries before sorting:");
        for (Country country : countries) {
            System.out.println(country);
        }

        // Sort countries by area in decreasing order using Comparator
        countries.sort(Comparator.comparingDouble(Country::getArea).reversed());

        // Display countries after sorting
        System.out.println("\nCountries after sorting by decreasing area:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
