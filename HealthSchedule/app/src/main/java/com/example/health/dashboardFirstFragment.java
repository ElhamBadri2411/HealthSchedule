package com.example.health;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.health.Classes.User;

public class dashboardFirstFragment extends dashboardFragment {

    public dashboardFirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void update(User user)
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_first, container, false);
    }
}