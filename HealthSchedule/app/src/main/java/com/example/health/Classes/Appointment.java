package com.example.health.Classes;

import java.util.Date;

public class Appointment {
    private int time;
    private DoctorInfo doctorInfo;
    private PatientInfo patientInfo;

    public Appointment() {
        time = 0;
        doctorInfo = new DoctorInfo();
        patientInfo = new PatientInfo();
    }

    public Appointment(int time, DoctorInfo doctorInfo, PatientInfo patientInfo) {
        this.time = time;
        this.doctorInfo = doctorInfo;
        this.patientInfo = patientInfo;
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
    public DoctorInfo getDoctorInfo() { return doctorInfo; }
    public PatientInfo getPatientInfo() { return patientInfo; }

    public void setTime(int time) {
        this.time = time;
    }

    public void setDoctorInfo(DoctorInfo doctorInfo) {
        this.doctorInfo = doctorInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }
}
