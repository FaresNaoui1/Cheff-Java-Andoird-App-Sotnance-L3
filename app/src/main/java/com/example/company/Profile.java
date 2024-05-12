package com.example.company;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.PersonController;
import com.example.company.Entety.entity.Person;

public class Profile extends AppCompatActivity {
  TextView username ;
   TextView email;
  PersonController personController;

   Long id ;
    Button home;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        home = findViewById(R.id.dash);
        personController = new PersonController();
        email = findViewById(R.id.email_text);
        username = findViewById(R.id.username_text);
        Bundle extras = getIntent().getExtras();

        long receivedPersonId = getIntent().getLongExtra("PersonId", -1);
        if (receivedPersonId != -1) {
            id = receivedPersonId;
            getProfile();
        }
     home.setOnClickListener(v -> {
         Intent intent = new Intent(this ,Dashboard.class);
         startActivity(intent);
     });
    }

    private void getProfile() {
personController.getPersonById(id, new PersonController.PersonCallback() {
    @Override
    public void onSuccess() {

    }

    @Override
    public void onSuccess(Person person) {
username.setText(person.getName());
email.setText(person.getEmail());
    }

    @Override
    public void onError(String message) {

    }
});
    }

}