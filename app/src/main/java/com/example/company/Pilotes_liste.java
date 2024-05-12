package com.example.company;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Controllers.CheffeurController;
import com.example.company.Controllers.PersonController;
import com.example.company.Controllers.RollController;
import com.example.company.Entety.entity.Cheffeur;
import com.example.company.Entety.entity.Person;
import com.example.company.Entety.entity.Roll;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
public class Pilotes_liste extends AppCompatActivity {

    RecyclerView recyclerview_pilote ;
    FloatingActionButton add_pilote;
    Long id=3L;
    Roll roll;
    private CheffeurController personController;
    private  RollController rollController;
    private List<Cheffeur> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilotes_liste);
rollController = new RollController();
        personController = new CheffeurController();
GetRoll();
getCHeffeurApi();

        add_pilote = findViewById(R.id.add_pilotes);
        recyclerview_pilote = findViewById(R.id.recyclerview_pilotes);


        recyclerview_pilote.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_pilote.setAdapter(new Adapter.Adapter_Cheffeur(getApplicationContext(),people));
      add_pilote.setOnClickListener(v -> { Intent intent = new Intent(Pilotes_liste.this, Add_pilote.class);
          startActivity(intent);});
    }
    void GetRoll() {
        rollController.GetRoll(id, new RollController.RollCallback() {
            @Override
            public void onSuccess(Roll body) {
                roll = body;
            }

            @Override
            public void onError(String message) {

            }
        });
    }
    private void getCHeffeurApi() {
      personController.getAllCheffeurs(new CheffeurController.CheffeurListCallback() {
          @Override
          public void onSuccess(List<Cheffeur> cheffeurs) {
              Toast.makeText(Pilotes_liste.this, "Successfully retrieved persons", Toast.LENGTH_SHORT).show();

              people = cheffeurs;
              refreshRecyclerView();
          }

          @Override
          public void onError(String message) {
              Toast.makeText(Pilotes_liste.this, "Failed to retrieve persons: " + message, Toast.LENGTH_SHORT).show();
              Log.d("ffffffffffffffffffffffff",message);
          }
      });
    }

    private void refreshRecyclerView() {
        recyclerview_pilote.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_pilote.setAdapter(new Adapter.Adapter_Cheffeur(getApplicationContext(),people));
    }



}