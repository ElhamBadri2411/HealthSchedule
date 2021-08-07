package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.example.health.Classes.Doctor;
import com.example.health.Classes.Patient;
import com.example.health.Classes.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardActivity extends AppCompatActivity {
    private User user;
    dashboardFragmentAdapter adapter;
    ViewPager2 pager2;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tabLayout = findViewById(R.id.d_tabLayout);
        pager2 = findViewById(R.id.d_viewPager2);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new dashboardFragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("Dashboard"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(User.getID(email));
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.child("identity").getValue(String.class).equals("patient"))
                    updateUser(snapshot.getValue(Patient.class));
                else
                    updateUser(snapshot.getValue(Doctor.class));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Database read failed: " + error.getCode());
            }
        });
    }

    public void updateUser(User user) {
        this.user = user;
        setTitle("Hi, " + user.name() + "!");
        adapter.update(user);
    }
}
