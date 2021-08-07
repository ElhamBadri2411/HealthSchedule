package com.example.health.Classes;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    private String healthCard;
    private List<Appointment> appointments;

    public Patient() {}

    public Patient(String email, String firstName, String lastName, String gender, String password)
    {
        super(email, firstName, lastName, gender, password);
        healthCard = "";
        appointments = new ArrayList<>();
    }

    public String getIdentity()
    {
        return "patient";
    }

    public String getHealthCard() { return healthCard; }

    public List<Appointment> getAppointments() { return appointments; }
}
