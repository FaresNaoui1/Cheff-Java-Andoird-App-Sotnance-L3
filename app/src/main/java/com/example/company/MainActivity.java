package com.example.company;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.PersonController;
import com.example.company.Entety.entity.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    PersonController personController;
Long id;

    public Long getId() {
        return id;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        usernameInput = findViewById(R.id.username);
        passwordInput = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);
        Button registerButton = findViewById(R.id.register1);

        // Initialize PersonController
        personController = new PersonController();

        // Set click listener for login button
        loginButton.setOnClickListener(v -> loginUser());

        // Set click listener for register button
        registerButton.setOnClickListener(v -> openRegistrationPage());
    }

    // Method to handle user login
    private void loginUser() {
        // Retrieve username and password from input fields
        String username = usernameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        // Call the method to fetch all persons from the server
        personController.getAllPersons(new PersonController.PersonListCallback() {
            @Override
            public void onSuccess(List<Person> persons) {
                // Iterate through the list of persons
                for (Person person : persons) {
                    // Check if the entered username and password match any person in the list
                    if (person.getFirstName().equals(username) && person.getPassword().equals(password)) {
                        // If a match is found, open the dashboard activity
                        id = person.getId();
                        Intent intent = new Intent(MainActivity.this, Dashboard.class);
                        intent.putExtra("personId", id);
                        startActivity(intent);

                        return;
                    }
                }
                // If no match is found, display an error message
                Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String message) {
                // Display error message if failed to retrieve persons from the server
                Toast.makeText(MainActivity.this, "Failed to retrieve persons: " + message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to open the registration page
    private void openRegistrationPage() {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}
