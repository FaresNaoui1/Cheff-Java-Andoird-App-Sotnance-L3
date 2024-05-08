package com.example.company.Entety.entity;


import java.util.List;

public class Roll {





    private Long id;
    private String type;



    private List<Person> persons;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", persons=" + persons +
                '}';
    }
}
