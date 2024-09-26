package com.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppointmentApp extends Application {
    private Calendar calendar = new Calendar();
    private ListView<String> appointmentList = new ListView<>();
    private YearMonth currentYearMonth = YearMonth.now();
    private VBox layout; // Initialize this field

    // Additional fields for editing
    private Appointment selectedAppointment = null;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Appointment Calendar");

        // Input fields
        DatePicker datePicker = new DatePicker();
        TextField startTimeField = new TextField();
        startTimeField.setPromptText("Start Time (HH:mm)");
        TextField endTimeField = new TextField();
        endTimeField.setPromptText("End Time (HH:mm)");
        TextField descriptionField = new TextField();
        descriptionField.setPromptText("Description");

        // Buttons
        Button addButton = new Button("Add Appointment");
        Button showButton = new Button("Show Appointments");
        Button editButton = new Button("Edit Appointment");
        Button deleteButton = new Button("Delete Appointment");

        // Add appointment event
        addButton.setOnAction(e -> {
            LocalDate date = datePicker.getValue();
            LocalTime startTime = LocalTime.parse(startTimeField.getText());
            LocalTime endTime = LocalTime.parse(endTimeField.getText());
            String description = descriptionField.getText();

            Appointment appointment = new Appointment(date, startTime, endTime, description);
            calendar.addAppointment(appointment);

            descriptionField.clear();
            startTimeField.clear();
            endTimeField.clear();

            // Refresh the calendar view after adding an appointment
            displayCalendarForMonth(currentYearMonth);
        });

        // Show appointments event
        showButton.setOnAction(e -> {
            LocalDate date = datePicker.getValue();
            List<Appointment> appointments = calendar.getAppointmentsForDay(date);
            appointmentList.getItems().clear();

            for (Appointment appointment : appointments) {
                appointmentList.getItems().add(appointment.toString());
            }
        });

        // Calendar Grid View for the current month
        GridPane calendarGrid = new GridPane();

        // Handle selecting an appointment for editing
        appointmentList.setOnMouseClicked(event -> {
            String selected = appointmentList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selectedAppointment = findAppointmentByDescription(selected);
                if (selectedAppointment != null) {
                    datePicker.setValue(selectedAppointment.getDate());
                    startTimeField.setText(selectedAppointment.getStartTime().toString());
                    endTimeField.setText(selectedAppointment.getEndTime().toString());
                    descriptionField.setText(selectedAppointment.getDescription());
                }
            }
        });

        // Edit appointment event
        editButton.setOnAction(e -> {
            if (selectedAppointment != null) {
                LocalDate newDate = datePicker.getValue();
                LocalTime newStartTime = LocalTime.parse(startTimeField.getText());
                LocalTime newEndTime = LocalTime.parse(endTimeField.getText());
                String newDescription = descriptionField.getText();

                Appointment newAppointment = new Appointment(newDate, newStartTime, newEndTime, newDescription);

                // Remove the old appointment before adding the new one
                calendar.removeAppointment(selectedAppointment);
                calendar.addAppointment(newAppointment);

                displayCalendarForMonth(currentYearMonth);
                selectedAppointment = null; // Reset the selected appointment
                appointmentList.getItems().clear();
            }
        });

        // Delete appointment event
        deleteButton.setOnAction(e -> {
            if (selectedAppointment != null) {
                // Remove only the selected appointment, not all appointments for the day
                calendar.removeAppointment(selectedAppointment);
                displayCalendarForMonth(currentYearMonth);
                selectedAppointment = null; // Reset the selected appointment
                appointmentList.getItems().clear();
            }
        });

        // Initialize the VBox layout and store a reference to it
        layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(new Label("Date:"), datePicker,
                                    new Label("Start Time:"), startTimeField,
                                    new Label("End Time:"), endTimeField,
                                    new Label("Description:"), descriptionField,
                                    addButton, showButton, editButton, deleteButton,
                                    appointmentList, calendarGrid);

        // Create the initial calendar view
        displayCalendarForMonth(currentYearMonth);

        // Set up the scene and show the stage
        Scene scene = new Scene(layout, 500, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to find an appointment by its string representation
    private Appointment findAppointmentByDescription(String description) {
        for (Appointment appointment : calendar.getAllAppointments()) {
            if (appointment.toString().equals(description)) {
                return appointment;
            }
        }
        return null;
    }

    // Display the calendar grid for the current month
    private void displayCalendarForMonth(YearMonth yearMonth) {
        appointmentList.getItems().clear();

        GridPane calendarGrid = new GridPane();
        calendarGrid.setPadding(new Insets(10));
        calendarGrid.setVgap(5);
        calendarGrid.setHgap(5);
        calendarGrid.setAlignment(Pos.CENTER);

        // Get the first and last day of the month
        LocalDate firstOfMonth = yearMonth.atDay(1);
        int daysInMonth = yearMonth.lengthOfMonth();

        // Display each day of the month
        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate date = firstOfMonth.withDayOfMonth(day);

            Button dayButton = new Button(String.valueOf(day));
            dayButton.setOnAction(e -> {
                List<Appointment> appointments = calendar.getAppointmentsForDay(date);
                appointmentList.getItems().clear();

                for (Appointment appointment : appointments) {
                    appointmentList.getItems().add(appointment.toString());
                }
            });

            // If there are appointments, show a marker
            if (!calendar.getAppointmentsForDay(date).isEmpty()) {
                dayButton.setStyle("-fx-background-color: #add8e6;"); // light blue for days with appointments
            }

            calendarGrid.add(dayButton, (day - 1) % 7, (day - 1) / 7); // Add buttons to the grid
        }

        // Update the layout with the calendar grid using the reference to layout
        layout.getChildren().set(9, calendarGrid); // Update the calendar grid
    }

    public static void main(String[] args) {
        launch(args);
    }
}
