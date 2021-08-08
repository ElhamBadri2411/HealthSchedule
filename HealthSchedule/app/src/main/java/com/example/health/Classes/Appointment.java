package com.example.health.Classes;

import java.util.Date;

public class Appointment {
    private int time;
    private DoctorInfo doctorInfo;
    private PatientInfo patientInfo;

    public static String Convert24To12(int time) {
        String tmp;
        if (time < 12 || time == 24) tmp = "am";
        else tmp = "pm";
        return ((time + 11) % 12 + 1) + tmp;
    }

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
        return Convert24To12(time) + " - " + Convert24To12(time + 1);
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
