package com.example.company;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myviewholdermecanicien extends RecyclerView.ViewHolder {
    TextView nom_mecanicien,prenom_mecanicien,telephon_mecanicien;
    public Myviewholdermecanicien(@NonNull View itemView) {
        super(itemView);
        nom_mecanicien= itemView.findViewById(R.id.item_nom_mecanicien);
        prenom_mecanicien= itemView.findViewById(R.id.item_prenom_mecanicien);
        telephon_mecanicien= itemView.findViewById(R.id.item_telephone_mecanicien);

    }
}
