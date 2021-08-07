package com.example.health.Classes;

public class Appointment {
    private int time;
    private Doctor doctor;
    private Patient patient;

    Appointment(int time, Doctor doctor, Patient patient) {
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getTime() { return time; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
