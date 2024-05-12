package com.example.company;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.PersonController;
import com.example.company.Entety.entity.Person;

public class Register extends AppCompatActivity {
    private PersonController personController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        personController = new PersonController();
        initializeComponents();
    }

    private void initializeComponents() {
        EditText userName = findViewById(R.id.nom);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText FreestNAME = findViewById(R.id.prenom);
        EditText PHONE = findViewById(R.id.telephone);

        Button registerButton = findViewById(R.id.regibutton);
        registerButton.setOnClickListener(v -> {
            String Username = userName.getText().toString().trim();
            String UserEmail = email.getText().toString().trim();
            String UserPassword = password.getText().toString().trim();
            String firstname = FreestNAME.getText().toString().trim();
            String phoneStr = PHONE.getText().toString().trim();

            if (Username.isEmpty() || UserEmail.isEmpty() || UserPassword.isEmpty() || firstname.isEmpty() || phoneStr.isEmpty()) {
                Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Additional error handling for phone number parsing
            int phone;
            try {
                phone = Integer.parseInt(phoneStr);
            } catch (NumberFormatException e) {
                Toast.makeText(Register.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                return;
            }

            Person person = new Person();
            person.setName(Username);
            person.setFirstName(firstname);
            person.setSellPhone(phone);
            person.setEmail(UserEmail);
            person.setPassword(UserPassword);

            personController.addPerson(person, new PersonController.PersonCallback() {
                @Override
                public void onSuccess() {
                    Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    // Optionally, you can navigate to another activity or perform any other action here
                }

                @Override
                public void onSuccess(Person person) {
                    Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError(String message) {
                    Toast.makeText(Register.this, "Registration failed: " + message, Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}
