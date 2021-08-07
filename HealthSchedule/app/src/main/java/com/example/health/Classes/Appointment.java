package com.example.health.Classes;

import java.util.Date;

public class Appointment {
    private int time;
    private String doctorID;
    private String patientID;

    Appointment(int time, String doctorID, String patientID) {
        this.time = time;
        this.doctorID = doctorID;
        this.patientID = patientID;
    }

    public boolean done() {
        Date date = new Date(System.currentTimeMillis());
        return time < date.getHours();
    }

    public String timeToString() {
        String res = "";
        if (time < 12) res = res + time + "am - ";
        else res = res + time + "pm - ";
        if (time + 1 < 12) res = res + (time + 1) + "am";
        else res = res + (time + 1) + "pm";
        return res;
    }

    public int getTime() { return time; }
    public String getDoctorID() { return doctorID; }
    public String getPatientID() { return patientID; }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
}
