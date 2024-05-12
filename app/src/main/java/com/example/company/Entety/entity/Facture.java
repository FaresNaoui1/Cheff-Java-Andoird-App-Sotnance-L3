package com.example.company.Entety.entity;


import java.util.List;

public class Facture {

    public Facture(String facture) {
        this.facture = facture;
    }

private Long idFacture;
private String facture;



private List<Piece> piece;

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", facture='" + facture + '\'' +
                ", piece=" + piece +
                '}';
    }

    public Facture(){}
public Facture(Long idFacture){this.idFacture=idFacture;}
public Facture(Long idFacture,String facture){this.idFacture=idFacture;this.facture=facture;}

public Long getIdFacture() {
    return idFacture;
}
public void setIdFacture(Long idFacture) {
    this.idFacture = idFacture;
}
public String getFacture() {
    return facture;
}
public void setFacture(String facture) {
    this.facture = facture;
}



    public List<Piece> getPiece() {
        return piece;
    }

    public void setPiece(List<Piece> piece) {
        this.piece = piece;
    }
}
