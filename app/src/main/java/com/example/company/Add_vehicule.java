package com.example.company;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.company.Entety.entity.Vehicule;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_vehicule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicule);

        initializeVehicule();
    }

    private void initializeVehicule() {
        EditText Matriqule = findViewById(R.id.matricule_vehicule);
        EditText Marque = findViewById(R.id.marque_vehicule);
        Button save = findViewById(R.id.save_vehicule);

        save.setOnClickListener(v -> {
            String matriqule = String.valueOf(Matriqule.getText());

            String marque = String.valueOf(Marque.getText());


            if (matriqule.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Vehicule vehicule = new Vehicule();
            vehicule.setVehiculeMatriquelle(matriqule);
      //    vehicule.setVehiculeMarque(marque);
            vehicule.setIdVehicule(10l);


            RetrofitService retrofitService = new RetrofitService();
            AllApi allApi =  retrofitService.getRetrofit().create(AllApi.class);
            allApi.addVehicule(vehicule).enqueue(new Callback<Vehicule>() {
                @Override
                public void onResponse(@NonNull Call<Vehicule> call, @NonNull Response<Vehicule> response) {
                    Toast.makeText(Add_vehicule.this, "Add vehicule successful", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(@NonNull Call<Vehicule> call, @NonNull Throwable t) {
                    Toast.makeText(Add_vehicule.this, "Failed to add vehicule", Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}
