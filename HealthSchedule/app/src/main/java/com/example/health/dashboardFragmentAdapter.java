package com.example.health;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.health.Classes.User;

public class dashboardFragmentAdapter extends FragmentStateAdapter {
    final int count = 2;
    dashboardFragment[] fr;

    public dashboardFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fr = new dashboardFragment[count];
        fr[0] = new dashboardFirstFragment();
        fr[1] = new profileFragment();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fr[position];
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public void update(User user) {
        for (dashboardFragment f : fr)
            f.update(user);
    }
}
