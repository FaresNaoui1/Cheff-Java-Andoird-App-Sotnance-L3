package com.example.company;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.company.Entety.entity.Person;
import com.example.company.Entety.entity.Roll;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_pilote extends AppCompatActivity {
    Roll roll;
    Long id = 3L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pilote);
        GetRoll();
        AddCheffeur();
    }
    private void AddCheffeur()
    {
        EditText NAME = findViewById(R.id.nom_mecanicien);
        EditText FristNAME = findViewById(R.id.prenom_mecanicien);
        EditText PHONE = findViewById(R.id.telephone_mecanicien);
        Button SAVE = findViewById(R.id.save);
        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);
        List<Person> people = new ArrayList<>();
        SAVE.setOnClickListener(v -> {

            String name = String.valueOf(NAME.getText());
            String fristname = String.valueOf(FristNAME.getText());
            int phone = Integer.parseInt(String.valueOf(PHONE.getText()));
            Person person = new Person();
            person.setName(name);
            person.setFirstName(fristname);
            person.setSellPhone(phone);
            person.setRoll(roll);

            people.add(person);
            roll.setPersons(people);


            allApi.addPerson(person).enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    Toast.makeText(Add_pilote.this, "get mecanicien successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    Toast.makeText(Add_pilote.this, "failed to get mecanicien", Toast.LENGTH_SHORT).show();
                }
            });
        });

        allApi.updateRoll(id,roll).enqueue(new Callback<Roll>() {
            @Override
            public void onResponse(Call<Roll> call, Response<Roll> response) {

            }

            @Override
            public void onFailure(Call<Roll> call, Throwable t) {

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

                }else {

                }
            }

            @Override
            public void onFailure(Call<Roll> call, Throwable t) {

            }
        });

    }
}