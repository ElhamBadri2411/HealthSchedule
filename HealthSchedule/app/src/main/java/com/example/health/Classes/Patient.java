package com.example.health.Classes;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    private String birthday;
    private String healthCard;
    private List<Appointment> appointments;

    public Patient() {
        super();
        birthday = "";
        healthCard = "";
        appointments = new ArrayList<>();
    }

    public Patient(String email, String firstName, String lastName, String gender, String password)
    {
        super(email, firstName, lastName, gender, password);
        birthday = "";
        healthCard = "";
        appointments = new ArrayList<>();
        appointments.add(new Appointment(1, User.getID("123@qq.com"), User.getID(email)));
    }

    public String getIdentity()
    {
        return "patient";
    }

    public String getBirthday() { return birthday; }

    public String getHealthCard() { return healthCard; }

    public List<Appointment> getAppointments() { return appointments; }
}
