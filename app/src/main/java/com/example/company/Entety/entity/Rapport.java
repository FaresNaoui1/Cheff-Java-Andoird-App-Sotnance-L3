package com.example.company.Entety.entity;

public class Rapport {


    private long id;
    private  String rapport;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRapport() {
        return rapport;
    }

    public void setRapport(String rapport) {
        this.rapport = rapport;
    }

    @Override
    public String toString() {
        return "Rapport [id=" + id + ", rapport=" + rapport + "]";
    }
}
