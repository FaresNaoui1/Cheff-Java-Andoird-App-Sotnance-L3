package com.example.company.Entety.entity;

import java.util.List;



public class Location {

public Location(String location) {
        this.location = location;
    }
public Location(Long idLocation, String location) {
        this.idLocation = idLocation;
        this.location = location;
    }


private Long idLocation;
private String location;



private List<Vehicule> vehicules;

public Long getIdLocation() {
    return idLocation;
}
public void setIdLocation(Long idLocation) {
    this.idLocation = idLocation;
}
public String getLocation() {
    return location;
}
public void setLocation(String location) {
    this.location = location;
}

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    @Override
    public String toString() {
        return "Location{" +
                "idLocation=" + idLocation +
                ", location='" + location + '\'' +
                ", vehicules=" + vehicules +
                '}';
    }
}
