package com.example.company;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Entety.entity.Vehicule;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Update_vehicule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vehicule);

        updateVehicule();
        deletVehicule();
    }

    private void deletVehicule()
    {
        EditText idInput = findViewById(R.id.id_vehicule);
        Button delet = findViewById(R.id.delet_vehicule);

        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);
        delet.setOnClickListener(v -> {
        Long vehiculeId = Long.parseLong(idInput.getText().toString());
        allApi.deleteVehicule(vehiculeId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(Update_vehicule.this, "sucses in  deleting vehicles", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Update_vehicule.this, "Failed to delet vehicles", Toast.LENGTH_SHORT).show();
            }

        });
        });
    }


    private void updateVehicule()
    {
        EditText MAtri = findViewById(R.id.matricule_vehicule);
        EditText MArq = findViewById(R.id.marque_vehicule);
        EditText idInput = findViewById(R.id.id_vehicule);
        Button update = findViewById(R.id.updat_vehicule);


        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);

        update.setOnClickListener(v -> {
        String matricl = String.valueOf(MAtri.getText());
        String markl = String.valueOf(MArq.getText());
        Long vehiculeId = Long.parseLong(idInput.getText().toString());
        Vehicule vehicule = new Vehicule();
        vehicule.setVehiculeMatriquelle(matricl);
        vehicule.setVehiculemarque(markl);
        allApi.updateVehicule(vehiculeId,vehicule).enqueue(new Callback<Vehicule>() {
            @Override
            public void onResponse(Call<Vehicule> call, Response<Vehicule> response) {
                Toast.makeText(Update_vehicule.this, "sucses in  updating vehicles", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Vehicule> call, Throwable t) {
                Toast.makeText(Update_vehicule.this, "Failed to updates vehicles", Toast.LENGTH_SHORT).show();
            }
        });
    });
    }
}