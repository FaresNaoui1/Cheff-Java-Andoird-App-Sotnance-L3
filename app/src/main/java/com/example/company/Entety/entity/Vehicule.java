package com.example.company.Entety.entity;

import java.util.Arrays;
import java.util.List;

public class Vehicule {

    public Vehicule(Long idVehicule, String matricule, VehiculeType vehiculeType) {
        this.idVehicule = idVehicule;
        this.matricule = matricule;
        this.vehiculeType = vehiculeType;
    }

    public Vehicule() {
    }

    public String getVehiculemarque() {
        return vehiculemarque;
    }

    public void setVehiculemarque(String vehiculemarque) {
        this.vehiculemarque = vehiculemarque;
    }


    private Long idVehicule;


    private byte[] image;
    private  String matricule;

    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +

                ", image=" + Arrays.toString(image) +
                ", matricule='" + matricule + '\'' +
                ", vehiculemarque='" + vehiculemarque + '\'' +
                ", persons=" + persons +
                '}';
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    private String vehiculemarque;


    private List<Person> persons;



    private VehiculeType vehiculeType;

    public VehiculeType getVehiculeType() {
        return vehiculeType;
    }

    public void setVehiculeType(VehiculeType vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

    private Location location;


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    private Onpanne onpanne;


    public Onpanne getOnpanne() {
        return onpanne;
    }

    public void setOnpanne(Onpanne onpanne) {
        this.onpanne = onpanne;
    }

    public Vehicule(String vehiculeMatriquelle) {
        vehiculeMatriquelle = vehiculeMatriquelle;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }



    public void setVehiculeMatriquelle(String vehiculeMatriquelle) {
        vehiculeMatriquelle = vehiculeMatriquelle;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
