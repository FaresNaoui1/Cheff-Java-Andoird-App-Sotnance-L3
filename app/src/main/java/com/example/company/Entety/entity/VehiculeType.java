package com.example.company.Entety.entity;


import java.util.List;

public class VehiculeType {

    private Long IdVType;
    private String Vehiculetype;



    private List<Vehicule> vehicules;

public VehiculeType(String vehiculetype) {
        Vehiculetype = vehiculetype;
    }
public VehiculeType(Long idVType, String vehiculetype) {
        IdVType = idVType;
        Vehiculetype = vehiculetype;
    }
public VehiculeType() {
    }

    @Override
    public String toString() {
        return "VehiculeType{" +
                "IdVType=" + IdVType +
                ", Vehiculetype='" + Vehiculetype + '\'' +
                ", vehicules=" + vehicules +
                '}';
    }

    public Long getIdVType() {
    return IdVType;
}
public void setIdVType(Long idVType) {
    IdVType = idVType;
}
public String getVehiculetype() {
    return Vehiculetype;
}
public void setVehiculetype(String vehiculetype) {
    Vehiculetype = vehiculetype;
}

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }
}
