package com.example.company;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Controllers.VehiculeController;
import com.example.company.Entety.entity.Vehicule;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Vehicules_liste extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_btn;

    VehiculeController vehiculeController ;
    List<Vehicule> vehicules = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicules_liste);



        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      recyclerView.setAdapter(new Adapter(getApplicationContext(),vehicules));
        add_btn = findViewById(R.id.add);
        vehiculeController = new VehiculeController();

GetVehiculesApi();


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vehicules_liste.this, Add_vehicule.class);
                startActivity(intent);
            }
        });
    }


    private void GetVehiculesApi() {
        vehiculeController.getAllVehicules(new VehiculeController.VehiculeListCallback() {
            @Override
            public void onSuccess(List<Vehicule> vehiculess) {
                vehicules = vehiculess;
                refreshRecyclerView();
            }

            @Override
            public void onError(String message) {

            }
        });

    }

    private void refreshRecyclerView() {

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter(getApplicationContext(),vehicules));
    }

}