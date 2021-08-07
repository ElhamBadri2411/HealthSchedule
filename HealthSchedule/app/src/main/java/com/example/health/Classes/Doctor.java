package com.example.health.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Doctor extends User {
    private String proficiency;
    private Map<Integer, Appointment> schedule;

    public Doctor() {
        super();
        proficiency = "";
        schedule = new TreeMap<>();
    }

    public Doctor(String email, String firstName, String lastName, String gender, String password) {
        super(email, firstName, lastName, gender, password);
        proficiency = "";
        schedule = new TreeMap<>();
    }

    public List<Appointment> appointments() {
        List<Appointment> res = new ArrayList<>();
        for (Map.Entry<Integer, Appointment> entry : schedule.entrySet())
            res.add(entry.getValue());
        return res;
    }

    public String getIdentity() { return "doctor"; }

    public String getProficiency() { return proficiency; }

    public Map<Integer, Appointment> getSchedule() { return schedule; }
}
