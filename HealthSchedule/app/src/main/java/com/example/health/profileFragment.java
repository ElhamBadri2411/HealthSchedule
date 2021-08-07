package com.example.health;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.health.Classes.User;

import org.w3c.dom.Text;

public class profileFragment extends dashboardFragment {
    View view;

    User tag;

    public profileFragment() {
        // Required empty public constructor
    }

    @Override
    public void update(User user) {
        if (view == null) { tag = user; return; }
        TextView textView = view.findViewById(R.id.TextVew);
        textView.setText(user.name());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        if (tag != null) {
            update(tag);
            tag = null;
        }
        return view;
    }
}