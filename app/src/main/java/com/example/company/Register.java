package com.example.company;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Entety.entity.Person;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initalaizeComponents();
    }

    private void initalaizeComponents() {
        EditText UserName = findViewById(R.id.username);
        EditText Email = findViewById(R.id.email);
        EditText Password = findViewById(R.id.password);
        Button Register = findViewById(R.id.regibutton);

        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi =  retrofitService.getRetrofit().create(AllApi.class);
        Register.setOnClickListener(v -> {
            String username =String.valueOf( UserName.getText());
            String email=String.valueOf( Email.getText());
            String password=String.valueOf( Password.getText());
            if (username.isEmpty() || email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }
            Person person = new Person();
            person.setName(username);
            person.setEmail(email);
            person.setPassword(password);
            allApi.addPerson(person).enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    Toast.makeText(Register.this,"add person successfully ",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Person> call, Throwable throwable) {
                    Toast.makeText(Register.this,"failed to add person",Toast.LENGTH_SHORT).show();
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE,"EROOR ",throwable);
                }
            });
        });
    }
}