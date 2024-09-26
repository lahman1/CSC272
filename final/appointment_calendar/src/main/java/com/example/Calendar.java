package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<Appointment> appointments;

    public Calendar() {
        this.appointments = new ArrayList<>();
    }

    // Add an appointment to the calendar
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Remove an appointment from the calendar
    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    // Get all appointments for a specific day
    public List<Appointment> getAppointmentsForDay(LocalDate date) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date)) {
                result.add(appointment);
            }
        }
        return result;
    }

    // Update an existing appointment with new details
    public void updateAppointment(Appointment oldAppointment, Appointment newAppointment) {
        int index = appointments.indexOf(oldAppointment);
        if (index != -1) {
            appointments.set(index, newAppointment);
        }
    }

    // Get all appointments in the calendar (for internal use in selection)
    public List<Appointment> getAllAppointments() {
        return appointments;
    }
}
