package com.example.health.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Doctor extends User {
    private Map<Integer, Appointment> schedule;

    public Doctor() {
        info = new DoctorInfo();
        schedule = new TreeMap<>();
    }

    public Doctor(String email, String firstName, String lastName, String gender, String password) {
        info = new DoctorInfo(email, firstName, lastName, gender, password);
        schedule = new TreeMap<>();
    }

    public List<Appointment> appointments() {
        List<Appointment> res = new ArrayList<>();
        for (Map.Entry<Integer, Appointment> entry : schedule.entrySet())
            res.add(entry.getValue());
        return res;
    }

    public String getIdentity() { return "doctor"; }

    public String getProficiency() { return ((DoctorInfo) info).getProficiency(); }

    public Map<Integer, Appointment> getSchedule() { return schedule; }

    public void setProficiency(String proficiency) {
        ((DoctorInfo) info).setProficiency(proficiency);
    }
}
