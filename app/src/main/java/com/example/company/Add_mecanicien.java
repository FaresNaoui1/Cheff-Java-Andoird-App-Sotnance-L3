package com.example.company;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.company.Controllers.MeccanicianController;
import com.example.company.Entety.entity.Mecanician;
import com.example.company.Entety.entity.Person;
import com.example.company.Entety.entity.Roll;
import com.example.company.retrofit.AllApi;
import com.example.company.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Add_mecanicien extends AppCompatActivity {

Long id = 2L;
    List<Mecanician> people = new ArrayList<>();
    private MeccanicianController meccanicianController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mecanicien);
      meccanicianController = new MeccanicianController();
        AddMecanicien();
    }

    private void AddMecanicien()
    {
        EditText NAME = findViewById(R.id.nom_mecanicien);
        EditText FreestNAME = findViewById(R.id.prenom_mecanicien);
        EditText PHONE = findViewById(R.id.telephone_mecanicien);
        EditText Brtith = findViewById(R.id.birthday_mecanicien);
        EditText Email = findViewById(R.id.email_mecanicien);
        EditText Password = findViewById(R.id.password_mecanicien);
        Button SAVE = findViewById(R.id.save);

        RetrofitService retrofitService = new RetrofitService();
        AllApi allApi = retrofitService.getRetrofit().create(AllApi.class);

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

            Mecanician person = new Mecanician();
            person.setName(name);
            person.setFirstName(firstname);
            person.setSellPhone(phone);
            //  person.setBirthdate(birthdayString);
            person.setEmail(email);
            person.setPassword(password);

            people.add(person);
meccanicianController.addMecanician(person, new MeccanicianController.MecanicianCallback() {
    @Override
    public void onSuccess() {
        Toast.makeText( Add_mecanicien.this, "Pilot added successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Mecanician mecanician) {
        Toast.makeText( Add_mecanicien.this, "Pilot added successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText( Add_mecanicien.this, "Failed to add Pilot", Toast.LENGTH_SHORT).show();
    }
});
        });
    }


}