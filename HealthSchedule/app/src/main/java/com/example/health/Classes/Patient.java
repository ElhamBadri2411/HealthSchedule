package com.example.health.Classes;

import java.util.ArrayList;
import java.util.List;

public class Patient extends User {
    private List<Appointment> appointments;

    public Patient() {
        info = new PatientInfo();
        appointments = new ArrayList<>();
    }

    public Patient(String email, String firstName, String lastName, String gender, String password)
    {
        info = new PatientInfo(email, firstName, lastName, gender, password);
        appointments = new ArrayList<>();
        appointments.add(new Appointment(23, new DoctorInfo("em", "f", "l", "male", "123456"), (PatientInfo) info));
    }

    public String getIdentity()
    {
        return "patient";
    }

    public String getBirthday() { return ((PatientInfo) info).getBirthday(); }

    public String getHealthCard() { return ((PatientInfo) info).getHealthCard(); }

    public List<Appointment> getAppointments() { return appointments; }

    public void setBirthday(String birthday) { ((PatientInfo) info).setBirthday(birthday); }

    public void setHealthCard(String healthCard) { ((PatientInfo) info).setHealthCard(healthCard); }
}
