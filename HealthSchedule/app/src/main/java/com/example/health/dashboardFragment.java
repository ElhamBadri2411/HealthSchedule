package com.example.health;

import androidx.fragment.app.Fragment;

import com.example.health.Classes.User;

public abstract class dashboardFragment extends Fragment {
    public abstract void update(User user);
}
