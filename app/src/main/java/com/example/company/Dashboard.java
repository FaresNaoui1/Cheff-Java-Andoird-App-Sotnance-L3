package com.example.company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Dashboard extends AppCompatActivity {

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

                Intent intent = new Intent(Dashboard.this, Mecanicniciens_liste.class);
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
                startActivity(intent);
            }
        });



    }
}