package com.example.company.Entety.entity;


import java.util.List;

public class VehiculeMarque {

    private Long IdVM;
    private String Vehiculemarque;


    private List<Vehicule> vehicules;


    public VehiculeMarque(String vehiculemarque) {
        Vehiculemarque = vehiculemarque;
    }
    public VehiculeMarque(Long idVM, String vehiculemarque) {
        IdVM = idVM;
        Vehiculemarque = vehiculemarque;
    }
    public VehiculeMarque() {
    }
    @Override
    public String toString() {
        return "VehiculeMarque [IdVM=" + IdVM + ", Vehiculemarque=" + Vehiculemarque + "]";
    }
 
    public Long getIdVM() {
        return IdVM;
    }
    public void setIdVM(Long idVM) {
        IdVM = idVM;
    }
    public String getVehiculemarque() {
        return Vehiculemarque;
    }
    public void setVehiculemarque(String vehiculemarque) {
        Vehiculemarque = vehiculemarque;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules() {
        this.vehicules = vehicules;
    }
}
