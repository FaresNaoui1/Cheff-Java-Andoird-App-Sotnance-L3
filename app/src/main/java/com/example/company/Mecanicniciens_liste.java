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


public class Mecanicniciens_liste extends AppCompatActivity {
        RecyclerView recyclerView;
        FloatingActionButton add_btn;
        Long id=2L;
        Roll roll;
        private List<Person> people = new ArrayList<>();
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_vehicules_liste);
            GetRoll();
         GetMecanicApi();


            Person person = new Person();
            person.setName("fares");
            person.setName("naoui");
            people.add(person);
            people.add(person);  people.add(person);

                    recyclerView = findViewById(R.id.recyclerview_mecanicien);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new Adapter.Adapter_Mecanicien(getApplicationContext(),people));
            add_btn = findViewById(R.id.add);

            add_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(com.example.company.Mecanicniciens_liste.this, Add_vehicule.class);
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
                        Toast.makeText(Mecanicniciens_liste.this, "get roll successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Mecanicniciens_liste.this, "failed to get roll", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Roll> call, Throwable t) {

                }
            });

        }
    private void GetMecanicApi()
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

                   Toast.makeText(Mecanicniciens_liste.this, "get mecanic successfully", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(Mecanicniciens_liste.this, "failed to get mechanics", Toast.LENGTH_SHORT).show();
               }

            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(Mecanicniciens_liste.this, "failed to get mechanics", Toast.LENGTH_SHORT).show();
            }
        });
    }


}