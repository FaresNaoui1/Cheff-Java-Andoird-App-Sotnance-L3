package com.example.company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.company.Entety.entity.Person;
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
         holder.Matricule_V.setText(vehicules.get(position).getVehiculeMatriquelle());
        holder.Marque_V.setText((CharSequence) vehicules.get(position).getVehiculeMarque());

    }

    @Override
    public int getItemCount() {
        return vehicules.size();
    }

    public static class Adapter_Mecanicien extends RecyclerView.Adapter <Myviewholdermecanicien>{
        Context context;
        List<Person> people;

        public Adapter_Mecanicien(Context context, List<Person> people) {
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
    holder.itemView.findViewById(R.id.item_nom_mecanicien);
            holder.itemView.findViewById(R.id.item_prenom_mecanicien);
            holder.itemView.findViewById(R.id.item_telephone_mecanicien);
        }

        @Override
        public int getItemCount() {
            return people.size();
        }
    }
    public static class Adapter_Cheffeur extends RecyclerView.Adapter <Myviewholdermecanicien>{
        Context context;
        List<Person> people;

        public Adapter_Cheffeur(Context context, List<Person> people) {
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
            holder.itemView.findViewById(R.id.item_nom_cheffeur);
            holder.itemView.findViewById(R.id.item_prenom_cheffeur);
            holder.itemView.findViewById(R.id.item_telephone_cheffeur);
        }

        @Override
        public int getItemCount() {
            return people.size();
        }
    }
}
