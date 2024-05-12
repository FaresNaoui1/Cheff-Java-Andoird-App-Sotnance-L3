package com.example.company;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Entety.entity.Vehicule;

public class Myviewholder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView Matricule_V,Marque_V;
    public Myviewholder(@NonNull View itemView) {
        super(itemView);
        imageView= itemView.findViewById(R.id.img_item_vehicule);
        Matricule_V= itemView.findViewById(R.id.matriculeV);
        Marque_V= itemView.findViewById(R.id.marquev);
    }

}