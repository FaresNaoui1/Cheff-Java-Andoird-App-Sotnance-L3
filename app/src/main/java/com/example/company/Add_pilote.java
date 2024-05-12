package com.example.company;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.CheffeurController;
import com.example.company.Controllers.RollController;
import com.example.company.Entety.entity.Cheffeur;
import com.example.company.Entety.entity.Roll;

import java.util.ArrayList;
import java.util.List;

public class  Add_pilote extends AppCompatActivity {
    Roll roll;
    Long id = 3L;
    List<Cheffeur> people = new ArrayList<Cheffeur>();
    private CheffeurController personController;
    private RollController rollController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pilote);
        personController = new CheffeurController();
        rollController =new RollController();
        GetRoll();
        initialize();

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

    void initialize() {
        EditText NAME = findViewById(R.id.nom_chauffeur);
        EditText FreestNAME = findViewById(R.id.prenom_chauffeur);
        EditText PHONE = findViewById(R.id.telephone_chauffeur);
        EditText Brtith = findViewById(R.id.birthday_chauffeur);
        EditText Email = findViewById(R.id.email_chauffeur);
        EditText Password = findViewById(R.id.password_chauffeur);
        Button SAVE = findViewById(R.id.dash);

        SAVE.setOnClickListener(v -> {
            String name = String.valueOf(NAME.getText());
            String firstname = String.valueOf(FreestNAME.getText());
            String phoneStr = String.valueOf(PHONE.getText());
            String email = Email.getText().toString();
            String password = Password.getText().toString();

// Convert LocalDate to string in the desired format

            // Validate phone number
            if (phoneStr.isEmpty()) {
                PHONE.setError("Phone number is required");
                return;
            }
            int phone = Integer.parseInt(phoneStr);

            Cheffeur person = new Cheffeur();
            person.setName(name);
            person.setFirstName(firstname);
            person.setSellPhone(phone);
          //  person.setBirthdate(birthdayString);
            person.setEmail(email);
            person.setPassword(password);

            people.add(person);

         personController.addCheffeur(person, new CheffeurController.CheffeurCallback() {

             @Override
             public void onSuccess() {
                 Toast.makeText(Add_pilote.this, "Registration successful", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onSuccess(Cheffeur cheffeur) {
                 Toast.makeText(Add_pilote.this, "Registration successful", Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onError(String message) {
                 Toast.makeText(Add_pilote.this, "Registration failed: " + message, Toast.LENGTH_SHORT).show();
             }
         });
        });
    }
}
