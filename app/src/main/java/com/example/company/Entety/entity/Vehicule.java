package com.example.company.Entety.entity;


import java.util.Arrays;
import java.util.List;

public class Vehicule {
    public Vehicule(Long idVehicule, String vehiculeMatriquelle) {
        this.idVehicule = idVehicule;
        VehiculeMatriquelle = vehiculeMatriquelle;
    }

    public Vehicule() {
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "idVehicule=" + idVehicule +
                ", vehiculeMatriquelle='" + VehiculeMatriquelle +
                ", vehiculeMMarque='" + VehiculeMarque +
                ", imageBlob=" + Arrays.toString(image) +
                '}';
    }


    private Long idVehicule;
    private String VehiculeMatriquelle;

    public void setVehiculeMarque(String vehiculeMarque) {
        VehiculeMarque = vehiculeMarque;
    }

    private String VehiculeMarque;
    private byte[] image;

    private List<Person> persons;



private VehiculeMarque vehiculeMarque;


private VehiculeType vehiculeType;


private Location location;



private Onpanne onpanne;


    public Vehicule(String vehiculeMatriquelle) {
        VehiculeMatriquelle = vehiculeMatriquelle;
    }

    public Long getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Long idVehicule) {
        this.idVehicule = idVehicule;
    }

    public String getVehiculeMatriquelle() {
        return VehiculeMatriquelle;
    }

    public void setVehiculeMatriquelle(String vehiculeMatriquelle) {
        VehiculeMatriquelle = vehiculeMatriquelle;
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

    public Onpanne getOnpanne() {
        return onpanne;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public VehiculeType getVehiculeType() {
        return vehiculeType;
    }


    public VehiculeMarque getVehiculeMarque() {
        return vehiculeMarque;
    }


    public void setOnpanne(Onpanne onpanne) {
        this.onpanne = onpanne;
    }

    public void setVehiculeType(VehiculeType vehiculeType) {
        this.vehiculeType = vehiculeType;
    }

    public void setVehiculeMarque(VehiculeMarque vehiculeMarque) {
        this.vehiculeMarque = vehiculeMarque;
    }
}
