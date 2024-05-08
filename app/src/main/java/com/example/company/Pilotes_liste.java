package com.example.company;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.company.Entety.entity.Person;
import com.example.company.Entety.entity.Roll;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class Pilotes_liste extends AppCompatActivity {

    RecyclerView recyclerview_pilote ;
    FloatingActionButton add_pilote;
    Long id=3L;
    Roll roll;
    private List<Person> people = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilotes_liste);
GetRoll();
GetCHeffeurApi();
        add_pilote = findViewById(R.id.add_pilotes);
        recyclerview_pilote = findViewById(R.id.recyclerview_pilotes);



        recyclerview_pilote.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_pilote.setAdapter(new Adapter.Adapter_Cheffeur(getApplicationContext(),people));
        add_pilote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Pilotes_liste.this, Add_pilote.class);
                startActivity(intent);
            }
        });
    }
    void GetRoll( )
    {
        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);
        allApi.getRoll(id).enqueue(new Callback<Roll>() {
            @Override
            public void onResponse(Call<Roll> call, Response<Roll> response) {
                if(response.isSuccessful())
                {
                    roll= response.body();
                    Toast.makeText(Pilotes_liste.this, "get roll successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Pilotes_liste.this, "failed to get roll", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Roll> call, Throwable t) {

            }
        });

    }
    private void GetCHeffeurApi()
    {
        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);
        allApi.getPersons().enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if( response.isSuccessful())
                {
                    List<Person> peoples = response.body();
                    for(Person person : peoples)
                    {
                        if(person.getRoll()==roll)
                        {
                            people=peoples;
                        }
                    }

                    Toast.makeText(Pilotes_liste.this, "get chefeur successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Pilotes_liste.this, "failed to get chefeur", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(Pilotes_liste.this, "failed to get chefeur", Toast.LENGTH_SHORT).show();
            }
        });
    }
}