package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BalanceCalculatorController {

    @FXML
    private TextField depositField;

    @FXML
    private TextField interestField;

    @FXML
    private TextField yearsField;

    @FXML
    private Label balanceLabel;

    public void calculateBalance() {
        try {
            double deposit = Double.parseDouble(depositField.getText());
            double interestRate = Double.parseDouble(interestField.getText());
            int years = Integer.parseInt(yearsField.getText());

            BankAccount account = new BankAccount(deposit, interestRate);
            double finalBalance = account.calculateBalance(years);
            balanceLabel.setText(String.format("Balance: %.2f", finalBalance));
        } catch (NumberFormatException e) {
            balanceLabel.setText("Invalid input. Please enter valid numbers.");
        }
    }
}
