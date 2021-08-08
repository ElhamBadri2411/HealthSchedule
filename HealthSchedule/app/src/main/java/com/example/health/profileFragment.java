package com.example.health;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.health.Classes.Patient;
import com.example.health.Classes.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class profileFragment extends dashboardFragment {
    View view;
    User tag;
    Patient p = (Patient)tag;

    private EditText firstname;
    private EditText lastname;
    private EditText birthday;
    private EditText password;
    private TextView email;
    private EditText healthcard;
    private Button btn;


    //private EditText specialist;


    public profileFragment() {
        // Required empty public constructor
    }

    @Override
    public void update(User user) {
        if (view == null) { tag = user; return; }
        p = (Patient) user;
        initialState();
        firstname.setText(p.getFirstName());
        lastname.setText(p.getLastName());
        email.setText(p.getEmail());
        birthday.setText(p.getBirthday());
        password.setText(p.getPassword());
        healthcard.setText(p.getHealthCard());
        //specialist.setText(doctor.getProficiency());
    }

    public void initialState() {
        firstname = view.findViewById(R.id.p_editTextTextFirstName);
        lastname = view.findViewById(R.id.p_editTextTextLastName);
        birthday = view.findViewById(R.id.p_editTextTextBirthday);
        password = view.findViewById(R.id.p_editTextTextPassword);
        healthcard = view.findViewById(R.id.p_editTextTextHealthcard);
        //specialist = getView().findViewById(R.id.p_editTextTextSpecializations);
        email = view.findViewById(R.id.p_emailAddressTextview);
        btn = view.findViewById(R.id.p_buttonSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage("Are you sure to change the profile?");
            }
        });
    }

    public void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(message)
                .setTitle("Warning")
                .setPositiveButton("Sure", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference()
                                .child("Users").child(User.getID(p.getEmail()));
                        p.setFirstName(firstname.getText().toString());
                        p.setLastName(lastname.getText().toString());
                        p.setPassword(password.getText().toString());
                        p.setBirthday(birthday.getText().toString());
                        p.setHealthCard(healthcard.getText().toString());
                        ref.setValue(p);
                    }
                });
        builder.setMessage(message)
                .setTitle("Warning")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        update(p);
                    }
                });
        builder.create().show();
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