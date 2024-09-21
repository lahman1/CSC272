package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BalanceCalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Balance Calculator");

        // Create UI elements
        Label depositLabel = new Label("Initial Deposit:");
        TextField depositField = new TextField();

        Label interestLabel = new Label("Annual Interest Rate:");
        TextField interestField = new TextField();

        Label yearsLabel = new Label("Number of Years:");
        TextField yearsField = new TextField();

        Button calculateButton = new Button("Calculate New Balance");
        Label balanceLabel = new Label("Balance: 0.00");

        // Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(20, 20, 20, 20));

        grid.add(depositLabel, 0, 0);
        grid.add(depositField, 1, 0);
        grid.add(interestLabel, 0, 1);
        grid.add(interestField, 1, 1);
        grid.add(yearsLabel, 0, 2);
        grid.add(yearsField, 1, 2);
        grid.add(calculateButton, 1, 3);
        grid.add(balanceLabel, 1, 4);

        calculateButton.setOnAction(e -> {
            double deposit = Double.parseDouble(depositField.getText());
            double interestRate = Double.parseDouble(interestField.getText());
            int years = Integer.parseInt(yearsField.getText());

            BankAccount account = new BankAccount(deposit, interestRate);
            double finalBalance = account.calculateBalance(years);
            balanceLabel.setText(String.format("Balance: %.2f", finalBalance));
        });

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
