package com.example.company;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.PersonController;
import com.example.company.Entety.entity.Person;

public class Dashboard extends AppCompatActivity {
    TextView username ;

    PersonController personController;
  Long id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageView imgVehicules = findViewById(R.id.imageView);
        ImageView imgMecaniciens = findViewById(R.id.imageView1);
        ImageView imgPilotes= findViewById(R.id.imageView2);
        ImageView imgRapport = findViewById(R.id.imageView3);
        ImageView imgParametres = findViewById(R.id.imageView4);
        ImageView imgProfile = findViewById(R.id.profile);

        personController = new PersonController();

        username = findViewById(R.id.textprofile);

        imgVehicules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Vehicules_liste.class);
                startActivity(intent);
            }
        });
        imgMecaniciens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Mecaniciens_liste.class);
                startActivity(intent);
            }
        });
        imgPilotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Pilotes_liste.class);
                startActivity(intent);
            }
        });
        imgRapport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Rapport.class);
                startActivity(intent);
            }
        });
        imgParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Parametres.class);
                startActivity(intent);
            }
        });
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard.this, Profile.class);
                intent.putExtra("PersonId", id);
                startActivity(intent);
            }
        });
        long receivedPersonId = getIntent().getLongExtra("personId", -1);
        if (receivedPersonId != -1) {
            id = receivedPersonId;
            getProfile();
        }

    }
    private void getProfile() {
        personController.getPersonById(id, new PersonController.PersonCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onSuccess(Person person) {
                username.setText("Bienvenue mr:"+person.getName());

            }

            @Override
            public void onError(String message) {

            }
        });
    }
}