package com.example.company.Entety.entity;



import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Cheffeur {

    private Long id;
    private String firstName;
    private String name;

    private int sellPhone;
    private String email;
    private String password;
    private byte[] image;

    private List<Vehicule> vehicules;



    Roll roll;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getSellPhone() {
        return sellPhone;
    }

    public void setSellPhone(int sellPhone) {
        this.sellPhone = sellPhone;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public Roll getRoll() {
        return roll;
    }

    public void setRoll(Roll roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", name='" + name + '\'' +

                ", sellPhone=" + sellPhone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image=" + Arrays.toString(image) +
                ", vehicules=" + vehicules +
                ", roll=" + roll +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
