package com.example.company;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.VehiculeController;
import com.example.company.Entety.entity.Vehicule;

public class Add_vehicule extends AppCompatActivity {

    private VehiculeController vehiculeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicule);

        vehiculeController = new VehiculeController(); // Initialize VehiculeController

        initializeVehicule();
    }

    private void initializeVehicule() {
        EditText matriquleEditText = findViewById(R.id.matricule_vehicule);
        EditText marqueEditText = findViewById(R.id.marque_vehicule);
        Button saveButton = findViewById(R.id.dash);

        saveButton.setOnClickListener(v -> {
            String matriqule = matriquleEditText.getText().toString().trim();
            String marque = marqueEditText.getText().toString().trim();

            if (matriqule.isEmpty() || marque.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            Vehicule vehicule = new Vehicule();
            vehicule.setMatricule(matriqule);
            vehicule.setVehiculemarque(marque);

            // Call the method to add the vehicle
            vehiculeController.addVehicule(vehicule, new VehiculeController.VehiculeCallback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onSuccess(Vehicule vehicule) {
                    // Handle success


                }



                @Override
                public void onError(String message) {
                    // Handle error

                }
            });
        });
    }
}
