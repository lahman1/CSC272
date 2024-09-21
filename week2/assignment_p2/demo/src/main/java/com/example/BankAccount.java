package com.example;

public class BankAccount {
    private double initialDeposit;
    private double annualInterestRate;

    public BankAccount(double initialDeposit, double annualInterestRate) {
        this.initialDeposit = initialDeposit;
        this.annualInterestRate = annualInterestRate;
    }

    public double calculateBalance(int years) {
        return initialDeposit * Math.pow(1 + annualInterestRate / 100, years);
    }
}
