package com.example.company.Entety.entity;


import java.util.List;

public class Onpanne {
@Override
    public String toString() {
        return "Onpanne [IdPanne=" + IdPanne + ", onpanne=" + onpanne + "]";
    }
public Onpanne(String onpanne) {
        this.onpanne = onpanne;
    }
public Onpanne() {
    }
public Onpanne(Long idPanne, String onpanne) {
        IdPanne = idPanne;
        this.onpanne = onpanne;
    }

private Long IdPanne;
private String onpanne;



private List<Vehicule> vehicules;

private Piece piece;
public Long getIdPanne() {
    return IdPanne;
}
public void setIdPanne(Long idPanne) {
    IdPanne = idPanne;
}
public String getOnpanne() {
    return onpanne;
}
public void setOnpanne(String onpanne) {
    this.onpanne = onpanne;
}

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
