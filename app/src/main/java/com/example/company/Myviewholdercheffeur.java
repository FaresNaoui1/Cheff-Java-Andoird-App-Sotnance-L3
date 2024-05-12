package com.example.company;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Entety.entity.Person;

public class Myviewholdercheffeur extends RecyclerView.ViewHolder{
    TextView nom_cheffeur,prenom_cheffeur,telephon_cheffeur;
    public Myviewholdercheffeur(@NonNull View itemView) {
        super(itemView);

        nom_cheffeur= itemView.findViewById(R.id.item_nom_cheffeur);
        prenom_cheffeur= itemView.findViewById(R.id.item_prenom_cheffeur);
        telephon_cheffeur= itemView.findViewById(R.id.item_telephone_cheffeur);

    }
    public void AddP(Person person)
    {
        nom_cheffeur.setText(person.getName());
        prenom_cheffeur.setText(person.getFirstName());
        telephon_cheffeur.setText(person.getSellPhone());
    }
}
