package com.example.company;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.company.Entety.entity.Vehicule;
import com.example.company.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;
import java.util.List;

public class Vehicules_liste extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_btn;
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

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Vehicules_liste.this, Add_vehicule.class);
                startActivity(intent);
            }
        });
    }


    private void GetVehiculesApi() {
        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);

        allApi.getVehicules().enqueue(new Callback<List<Vehicule>>() {
            @Override
            public void onResponse(Call<List<Vehicule>> call, Response<List<Vehicule>> response) {
                if (response.isSuccessful()) {
                    List<Vehicule> vehicles = response.body();
                    vehicules= vehicles;
                    Toast.makeText(Vehicules_liste.this, "get vehicles successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Vehicules_liste.this, "failed to get vehicles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Vehicule>> call, Throwable t) {
                Toast.makeText(Vehicules_liste.this, "failed to get vehicles", Toast.LENGTH_SHORT).show();
            }
        });
    }

}