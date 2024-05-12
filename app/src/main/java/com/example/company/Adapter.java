package com.example.company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Entety.entity.Cheffeur;
import com.example.company.Entety.entity.Mecanician;
import com.example.company.Entety.entity.Vehicule;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Myviewholder> {

    Context context;
    List<Vehicule> vehicules;

    public Adapter(Context context, List<Vehicule> vehicules) {
        this.context = context;
        this.vehicules = vehicules;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myviewholder(LayoutInflater.from(context).inflate(R.layout.vehicule_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
         holder.Matricule_V.setText(vehicules.get(position).getMatricule());
        holder.Marque_V.setText((CharSequence) vehicules.get(position).getVehiculemarque());


    }

    @Override
    public int getItemCount() {
        return vehicules.size();
    }

    public static class Adapter_Mecanicien extends RecyclerView.Adapter <Myviewholdermecanicien>{
        Context context;
        List<Mecanician> people;

        public Adapter_Mecanicien(Context context, List<Mecanician> people) {
            this.context = context;
            this.people = people;
        }

        @NonNull
        @Override
        public Myviewholdermecanicien onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Myviewholdermecanicien(LayoutInflater.from(context).inflate(R.layout.mecanicien_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull Myviewholdermecanicien holder, int position) {
            holder.nom_mecanicien.setText(people.get(position).getName());
            holder.prenom_mecanicien.setText(people.get(position).getFirstName());
            holder.telephon_mecanicien.setText(String.valueOf(people.get(position).getSellPhone()));
        }

        @Override
        public int getItemCount() {
            return people.size();
        }
    }
    public static class Adapter_Cheffeur extends RecyclerView.Adapter<Myviewholdercheffeur> {
        Context context;
        List<Cheffeur> people;

        public Adapter_Cheffeur(Context context, List<Cheffeur> people) {
            this.context = context;
            this.people = people;
        }

        @NonNull
        @Override
        public Myviewholdercheffeur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Myviewholdercheffeur(LayoutInflater.from(context).inflate(R.layout.chauffeur_item,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull Myviewholdercheffeur holder, int position) {
            holder.nom_cheffeur.setText(people.get(position).getName());
            holder.prenom_cheffeur.setText(people.get(position).getFirstName());
            holder.telephon_cheffeur.setText(String.valueOf(people.get(position).getSellPhone()));


        }


        @Override
        public int getItemCount() {
            return people.size();
        }
    }
}
