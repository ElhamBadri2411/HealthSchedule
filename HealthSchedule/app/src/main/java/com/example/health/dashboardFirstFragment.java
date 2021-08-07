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
    List<Appointment> appointments;

    public dashboardFirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void update(User user)
    {
        if (view == null) { tag = user; return; }
        if (user.getIdentity() == "patient")
            appointments = ((Patient) user).getAppointments();
        else
            appointments = ((Doctor) user).appointments();
        List<String> contents = new LinkedList<>();
        for (Appointment a : appointments)
            if (user.getIdentity() == "patient")
                contents.add(a.timeToString() + "\tDoctor " + a.getDoctorInfo().name());
            else
                contents.add(a.timeToString() + "\t" + a.getPatientInfo().name());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
                                        , R.layout.fragment_dashboard_first, contents);
        listView.setAdapter(adapter);
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