package com.example;

public class Microwave {
    private int time;
    private int powerLevel;

    public Microwave() {
        this.time = 0;
        this.powerLevel = 1;
    }

    public void increaseTime(int seconds) {
        this.time += seconds;
        System.out.println("Time increased by " + seconds + " seconds. Total time: " + this.time + " seconds.");
    }

    public void switchPower() {
        this.powerLevel = this.powerLevel == 1 ? 2 : 1;
        System.out.println("Power level switched to " + this.powerLevel + ".");
    }

    public void start() {
        if (this.time > 0) {
            System.out.println("Cooking for " + this.time + " seconds at level " + this.powerLevel + ".");
        } else {
            System.out.println("Please set the time before starting the microwave.");
        }
    }

    public void reset() {
        this.time = 0;
        this.powerLevel = 1;
        System.out.println("Microwave reset. Time is 0 seconds and power level is 1.");
    }

    public static void main(String[] args) {
        Microwave microwave = new Microwave();
        
        // Simulate a series of operations
        System.out.println("Microwave Operations Simulation:");
        
        microwave.increaseTime(30);  // Increases time by 30 seconds
        microwave.increaseTime(60);  // Increases time by 60 seconds
        microwave.switchPower();  // Switches power level to 2
        microwave.start();  // Starts cooking
        microwave.reset();  // Resets the microwave
        
        // Test another sequence
        microwave.increaseTime(90);  // Increases time by 90 seconds
        microwave.start();  // Starts cooking
        microwave.switchPower();  // Switches power level to 2
        microwave.start();  // Starts cooking again with new power level
        microwave.reset();  // Resets the microwave
    }
}
