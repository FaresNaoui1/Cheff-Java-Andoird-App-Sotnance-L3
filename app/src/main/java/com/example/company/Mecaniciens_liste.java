package com.example.company;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Controllers.MeccanicianController;
import com.example.company.Controllers.PersonController;
import com.example.company.Entety.entity.Mecanician;
import com.example.company.Entety.entity.Person;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mecaniciens_liste extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_mecaniciens;
 private MeccanicianController personController;
 List<Mecanician> mechanics = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mecaniciens_liste);
        add_mecaniciens = findViewById(R.id.add_mecanicien);
        recyclerView = findViewById(R.id.recyclerview_mecanicien);
        add_mecaniciens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mecaniciens_liste.this, Add_mecanicien.class);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter.Adapter_Mecanicien(getApplicationContext(),mechanics));
        personController = new MeccanicianController();
        getMechanic();
    }

    private void getMechanic() {
     personController.getAllMecanicians(new MeccanicianController.MecanicianListCallback() {
         @Override
         public void onSuccess(List<Mecanician> mecanicians) {
             mechanics = mecanicians;
             refreshRecyclerView();
             Toast.makeText(Mecaniciens_liste.this, "Successfully retrieved persons", Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onError(String message) {
             Toast.makeText(Mecaniciens_liste.this, "filed retrieved persons", Toast.LENGTH_SHORT).show();
         }
     });

    }
    private void refreshRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter.Adapter_Mecanicien(getApplicationContext(),mechanics));

    }


}