package com.example.health;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.health.Classes.Appointment;
import com.example.health.Classes.Doctor;
import com.example.health.Classes.Patient;
import com.example.health.Classes.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class dashboardFirstFragment extends dashboardFragment {
    View view;
    User tag;
    ListView listView;
    List<String> contents;

    public dashboardFirstFragment() {
        // Required empty public constructor
    }

    public void addNewItem(String s) {
        contents.add(s);
    }

    @Override
    public void update(User user)
    {
        if (view == null) { tag = user; return; }
        List<Appointment> appointments;
        if (user.getIdentity() == "patient")
            appointments = ((Patient) user).getAppointments();
        else
            appointments = ((Doctor) user).appointments();
        contents = new LinkedList<>();
        //for (int i = 0; i < appointments.size(); i += 1)
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dashboard_first, container, false);
        listView = view.findViewById(R.id.df_listViewAppointments);
        if (tag != null) {
            update(tag);
            tag = null;
        }
        return view;
    }
}