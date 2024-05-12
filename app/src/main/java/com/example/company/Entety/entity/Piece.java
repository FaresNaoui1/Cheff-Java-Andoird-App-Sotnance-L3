package com.example.company.Entety.entity;


import java.util.List;

public class Piece {
    public Piece(String pieceName) {
        PieceName = pieceName;
    }
    public Piece() {
    }
    public Piece(Long idPiece, String pieceName) {
        this.idPiece = idPiece;
        PieceName = pieceName;
    }

private Long idPiece;
private String PieceName;


private List<Onpanne> onpanne;


private Facture facture;

public Long getIdPiece() {
    return idPiece;
}
public void setIdPiece(Long idPiece) {
    this.idPiece = idPiece;
}
public String getPieceName() {
    return PieceName;
}
public void setPieceName(String pieceName) {
    PieceName = pieceName;
}

    @Override
    public String toString() {
        return "Piece{" +
                "idPiece=" + idPiece +
                ", PieceName='" + PieceName + '\'' +
                ", onpanne=" + onpanne +
                ", facture=" + facture +
                '}';
    }

    public List<Onpanne> getOnpanne() {
        return onpanne;
    }

    public void setOnpanne(List<Onpanne> onpanne) {
        this.onpanne = onpanne;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
